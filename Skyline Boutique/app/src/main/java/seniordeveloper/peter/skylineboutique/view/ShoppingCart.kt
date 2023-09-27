package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.telephony.SmsManager
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.androidstudy.daraja.Daraja
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.closetModel.ClosetData
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.navs.Screen
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCartPage(navController: NavHostController) {
    var quantity by remember { mutableIntStateOf(1) }
    var sumTotal by remember { mutableFloatStateOf(0.0F) }
    val context = LocalContext.current
    val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
    val cartCount = dbHandle.getCartCount()
    var cartItems by remember { mutableStateOf(dbHandle.getCartData() ?: emptyList()) }
    val daraja = Daraja


    Column {
        TopAppBar(
            title = { Text(text = "Shopping Cart", color = colorResource(id = R.color.white)) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            backgroundColor = colorResource(R.color.statusBar),
            contentColor = colorResource(R.color.white),
            actions = {
                if (cartCount > 0) {
                    IconButton(onClick = {
                        dbHandle.deleteAllCartItems()
                        Toast.makeText(context, "Cart Emptied", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screen.ShoppingCart.route)
                    }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = Color.White)
                    }
                }
                else
                    return@TopAppBar
            }
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            if (cartItems.isEmpty()) {
                EmptyCart()
            } else {
                val itemTotalPrices = cartItems.map { clotheWear ->
                    clotheWear.price * quantity.toFloat()
                }
    // Calculate the sum total by summing up all the item total prices
                sumTotal = itemTotalPrices.sum()
                LazyColumn {
                    items(dbHandle.getCartData()!!) { item ->
                        CartCard(clotheWear = item, quantity,navController) { updatedPrice ->
                            sumTotal += updatedPrice
                        }
                        Space(spaced = 2)
                    }
                    item {
                        ElevatedCard(onClick = { /*TODO*/ },modifier =Modifier.fillMaxWidth()) {
                            Row {
                                Column {
                                    Text("Cart Items Count:\n \t\t\t$cartCount")
                                }
                                Column {
                                    Text("\t\t\tTotal:\n \t\t\t${sumTotal}")
                                }
                            }
                            Space(spaced = 2)
                            OutlinedButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "Checkout Initiated. Await the Payment Prompt",
                                    Toast.LENGTH_SHORT
                                ).show()
                                //Payment Handling
// on below line we are getting date and then we
                                // are setting this date as transaction id.
                                val c: Date = Calendar.getInstance().getTime()
                                val df = SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault())
                                val transcId: String = df.format(c)
                                val description = "Skyline Boutique Online Shopping"
                                navController.navigate(Screen.Payment.route)
                            },
                                // on below line we are adding modifier to our button.
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = "Proceed to Checkout")
                            }
                        }
                        LaunchedEffect(cartItems) {
                            // This code will run whenever cartItems changes
                            cartItems = dbHandle.getCartData() ?: emptyList()
                        }
                    }

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartCard(
    clotheWear: ClosetData,
    initialQuantity: Int,
    navController: NavHostController,
    onUpdateTotal: (Float) -> Unit
) {
    val context = LocalContext.current
    val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
    var quantity by remember {
        mutableStateOf(initialQuantity)}
    var totalPrice by remember { mutableFloatStateOf(clotheWear.price * quantity) }

    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = Modifier.height(130.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .safeContentPadding(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                AsyncImage(
                    model = clotheWear.image,
                    contentDescription = clotheWear.title,
                    modifier = Modifier
//                    .height(65.dp)
                        .size(95.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

               Space(spaced = 5)
                Text(text = clotheWear.title,
                    modifier=Modifier.width(90.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = colorResource(id = R.color.black))
            }
            Column(modifier = Modifier.padding(top = 5.dp)) {
                Text(text = "Unit Price: Kshs.${clotheWear.price}")
                Space(spaced = 1)
                Text("Quantity: $quantity")
                Space(spaced = 1)
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    IconButton(onClick = {
                        if (quantity > 1) {
                            quantity--
                            totalPrice -= clotheWear.price
                            onUpdateTotal(-clotheWear.price)
                        }
                    }) {
                        Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Remove", tint = Color.Red)
                    }
                    IconButton(onClick = {
                        quantity++
                        totalPrice += clotheWear.price
                        onUpdateTotal(clotheWear.price)
                    }) {
                        Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Add", tint = Color.Green)
                    }

                    IconButton(onClick = {
                        dbHandle.deleteCartItem(clotheWear.title)
                        Toast.makeText(context, "${clotheWear.title} Deleted Successfully.", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screen.ShoppingCart.route)

                    }) {
                        Column {
                            Icon(Icons.Filled.Delete, contentDescription = null, tint = Color.Red)
Space(spaced = 1)
                            Text(text ="Delete")
                        }
                    }
                }
                Space(spaced = 1)
                Text(text = "Total: Kshs.${totalPrice}")
            }
        }
    }
    Space(spaced = 10)
}

@Composable
fun EmptyCart(){
        Text(text = "Your cart is empty.")
        Image(painter = painterResource(id = R.drawable.nocart), contentDescription = null)
    }

@Composable
fun SendMessage(phoneNumber: String, message: String) {
    val smsManager = SmsManager.getDefault()
    val sentIntent = PendingIntent.getBroadcast(
        LocalContext.current,
        0,
        Intent("SMS_SENT"),
        PendingIntent.FLAG_IMMUTABLE
    )

    val deliveredIntent = PendingIntent.getBroadcast(
       LocalContext.current,
        0,
        Intent("SMS_DELIVERED"),
        PendingIntent.FLAG_IMMUTABLE
    )

    try {
        smsManager.sendTextMessage(
            phoneNumber,
            null,
            message,
            sentIntent,
            deliveredIntent
        )
    } catch (e: Exception) {
        // Handle SMS sending failure
        // You can display a toast or provide feedback to the user
        // using Composable functions like Snackbar or Toast Composables
        Toast.makeText(
            LocalContext.current,
            "Failed to send SMS",
            Toast.LENGTH_SHORT
        ).show()
    }
}




@Preview
@Composable
fun PreviewShoppingCartPage() {
    ShoppingCartPage(navController = rememberNavController())
}
