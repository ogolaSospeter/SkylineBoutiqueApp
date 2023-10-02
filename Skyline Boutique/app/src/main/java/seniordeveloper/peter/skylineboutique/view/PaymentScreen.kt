package seniordeveloper.peter.skylineboutique.view

import android.Manifest
import android.content.Context
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.models.constants.ToastMessage


@Composable
fun PaymentScreen(navController: NavHostController) {

    Column {
        TopAppBar(
            title = { Text(text ="Payment/ Checkout")},
            navigationIcon = {
                IconButton(onClick = {navController.navigateUp()}) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)

                }
            },
            backgroundColor = colorResource(id = R.color.statusBar),
            contentColor = Color.White,
            elevation = 12.dp,


            )
        Space(spaced = 2)

        var paymentSuccessful by remember { mutableStateOf(false) }
        var paymentFailed by remember { mutableStateOf(false) }

        CheckOutScreen(
            onPaymentSuccessful = {
                paymentSuccessful = true
                // Handle payment success
            },
            onPaymentFailed = {
                paymentFailed = true
                // Handle payment failure
            }
        )

        if (paymentSuccessful) {
            // Show a success message or navigate to another screen
            ToastMessage(message = "Payment Successful!")
        } else if (paymentFailed) {
            // Show a failure message or take appropriate action
            ToastMessage(message = "Payment Failed!")
        }
    }
}

@Composable
fun CheckOutScreen(
    onPaymentSuccessful: () -> Unit,
    onPaymentFailed: () -> Unit
) {
    // Define local state for phone number and amount
    var phoneNumber = remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    val viewModelScope = rememberCoroutineScope()
    var emailSent by remember{ mutableStateOf(false)}
    var messageSent by remember{ mutableStateOf(false)}
    val dbHandler = ClosetDBHandler(LocalContext.current)
    val items= listOf( dbHandler.getCartData())
    var ttl = 0.0
    var messg = "Thank you for shopping with us. " +
            "You have ordered the following items:\n\n"
            for (item in items) {
                messg += " * ${item[0].title} for   Kshs. ${item[0].price}\n"
                ttl += item[0].price.toDouble()
            }
            messg +="Your total order  is Kshs. ${String.format("%.3f",ttl)}. \n\n" +
            "Your order will be delivered to you in 3-5 business days. \n\n" +
            "Regards, \n" +
            "Skyline Boutique Team" +
                    "Call us on +254795398253 or email us on skylinersystemdevelopers@gmail.com"
    val msg = messg
    // Initialize the permission launcher at this level
    val context = LocalContext.current
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Permission is granted, you can send the SMS.
                try {
                    val smsManager: SmsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(phoneNumber.value, null, msg, null, null)
                    // Display a toast message for successful sending.
                    Toast.makeText(
                        context,
                        "Message Sent to ${phoneNumber.value} successfully.",
                        Toast.LENGTH_LONG
                    ).show()
                    // Add a log for debugging.
                    Log.d("SendMessage", "Message sent successfully: $msg")
                } catch (e: Exception) {
                    // Handle any errors and display a toast message.
                    Toast.makeText(
                        context,
                        "Error: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    // Add a log for debugging.
                    Log.d("SendMessage", "Error: ${e.message}")
                }
            } else {
                // Permission denied by the user.
                // Handle the case where the user denies the permission.
                Toast.makeText(
                    context,
                    "Permission to send SMS denied by the user.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            label = { Text("Phone Number") }
        )

        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") }
        )

        Button(
            onClick = {
                // Call a function to initiate the payment
                viewModelScope.launch {
                    delay(1000)
                    messageSent = !messageSent
                    emailSent = !emailSent
                }
            }
        ) {
            Text("Pay Now")
        }
    }
    if (messageSent) {
        SendMessage(LocalContext.current,phoneNumber.value,messg,requestPermissionLauncher)
    }

}


fun SendMessage(
    context: Context,
    phoneNumber: String,
    message: String,
    requestPermissionLauncher: androidx.activity.result.ActivityResultLauncher<String>
                ) {


    // Check if the app has the SEND_SMS permission.
    val hasPermission = checkSelfPermission(context, Manifest.permission.SEND_SMS) == PERMISSION_GRANTED

    if (hasPermission) {
        // Permission is already granted, send the SMS.
        try {
            val smsManager: SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            // Display a toast message for successful sending.
            Toast.makeText(
                context,
                "Message Sent to $phoneNumber successfully.",
                Toast.LENGTH_LONG
            ).show()
        } catch (e: Exception) {
            // Handle any errors and display a toast message.
            Toast.makeText(
                context,
                "Error: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    } else {
        // Request the SEND_SMS permission from the user.
    //
    // The method onRequestPermissionsResult() will be invoked if the user accepts the permission request.
        requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)
    }
}


//@Composable
//fun SendMessage(context: Context, phoneNumber: String, message: String) {
//    try {
//        // on below line initializing sms manager.
//        val smsManager: SmsManager = SmsManager.getDefault()
//        // on below line sending sms
//        smsManager.sendTextMessage(phoneNumber, null, message, null, null)
//        // on below line displaying
//        // toast message as sms send.
//        Toast.makeText(
//            context,
//            "Message Sent to $phoneNumber successfully.",
//            Toast.LENGTH_LONG
//        ).show()
//
//    } catch (e: Exception) {
//        // on below line handling error and
//        // displaying toast message.
//        Toast.makeText(
//            context,
//            "Error : " + e.message,
//            Toast.LENGTH_LONG
//        ).show()
//    }
//}


//
//@Composable
//fun CustomDialog(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {
//
//    val txtFieldError = remember { mutableStateOf("") }
//    val txtField = remember { mutableStateOf(value) }
//
//    Dialog(onDismissRequest = { setShowDialog(false) }) {
//        Surface(
//            shape = RoundedCornerShape(16.dp),
//            color = Color.White
//        ) {
//            Box(
//                contentAlignment = Alignment.Center
//            ) {
//                Column(modifier = Modifier.padding(20.dp)) {
//
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = "Set value",
//                            style = TextStyle(
//                                fontSize = 24.sp,
//                                fontFamily = FontFamily.Default,
//                                fontWeight = FontWeight.Bold
//                            )
//                        )
//                        Icon(
//                            imageVector = Icons.Filled.Cancel,
//                            contentDescription = "",
//                            tint = colorResource(android.R.color.darker_gray),
//                            modifier = Modifier
//                                .width(30.dp)
//                                .height(30.dp)
//                                .clickable { setShowDialog(false) }
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.height(20.dp))
//
//                    TextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .border(
//                                BorderStroke(
//                                    width = 2.dp,
//                                    color = colorResource(id = if (txtFieldError.value.isEmpty()) android.R.color.holo_green_light else android.R.color.holo_red_dark)
//                                ),
//                                shape = RoundedCornerShape(50)
//                            ),
//                        colors = TextFieldDefaults.textFieldColors(
//                            backgroundColor = Color.Transparent,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        leadingIcon = {
//                            Icon(
//                                imageVector = Icons.Filled.Money,
//                                contentDescription = "",
//                                tint = colorResource(android.R.color.holo_green_light),
//                                modifier = Modifier
//                                    .width(20.dp)
//                                    .height(20.dp)
//                            )
//                        },
//                        placeholder = { Text(text = "Enter value") },
//                        value = txtField.value,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                        onValueChange = {
//                            txtField.value = it.take(10)
//                        })
//
//                    Spacer(modifier = Modifier.height(20.dp))
//
//                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
//                        Button(
//                            onClick = {
//                                if (txtField.value.isEmpty()) {
//                                    txtFieldError.value = "Field can not be empty"
//                                    return@Button
//                                }
//                                setValue(txtField.value)
//                                setShowDialog(false)
//                            },
//                            shape = RoundedCornerShape(50.dp),
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(50.dp)
//                        ) {
//                            Text(text = "Done")
//                        }
//                    }
//                }
//            }
//        }
//    }
//}