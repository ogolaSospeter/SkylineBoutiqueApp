package seniordeveloper.peter.skylineboutique.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.models.constants.AlertBox
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.navs.Screen

@Composable
fun Registration(navController: NavHostController) {
    Column {
        RegisterUser(context = navController.context,navController = navController)
    }

}

@Composable
fun RegisterUser(context: Context,navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
    var showDialog by remember { mutableStateOf(false) }
    var alertSuccess by remember { mutableStateOf(false) }
    var alertDuplicate by remember { mutableStateOf(false) }
    val viewModelScope = rememberCoroutineScope()


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        AsyncImage(
            model = "https://img.freepik.com/free-vector/authentication-concept-illustration_114360-2168.jpg?t=st=1694160916~exp=1694161516~hmac=21bc4595944bdd9eee1a0712fd83ae1cb35a2fb4b2b59281ad9baf1a4e8ddaed",
            contentDescription = "registration",
            modifier = Modifier
                .size(350.dp)
                .clip(RoundedCornerShape(2.dp)),
            contentScale = ContentScale.Crop
        )
        Space(spaced = 2)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Your Email") },
            placeholder = { Text(text = "Input Your Email") },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp)),
            keyboardActions = KeyboardActions(KeyboardActions.Default.onNext),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Space(spaced = 2)

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Your Password") },
            placeholder = { Text(text = "Input Your Password") },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp)),
            keyboardActions = KeyboardActions(KeyboardActions.Default.onGo),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    if (passwordVisible) {
                        Image(
                            painter = painterResource(id = R.drawable.visibility),
                            "Hide Password"
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.visibility_off),
                            "Show Password"
                        )
                    }
                }
            }
        )
        Space(spaced = 2)

        OutlinedButton(onClick = {
            if (email.isEmpty() || password.isEmpty()) {
                showDialog = !showDialog

                return@OutlinedButton
            }
            viewModelScope.launch {
                run {
                    val existUser = dbHandle.getUser(email)
                    if (existUser != null) {
                        alertDuplicate = !alertDuplicate
                        delay(2000)
                        alertDuplicate = !alertDuplicate

                    } else {
                        dbHandle.addUser(email, password)
                        alertSuccess = !alertSuccess
                        delay(1500)
                        dbHandle.initializeDatabaseWithClothesData()
                        navController.navigate(Screen.Login.route)
                    }
                }
            }
        }
        ) {
            Text(text = "Register")

        }


    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = !showDialog },
            confirmButton = {
                androidx.compose.material3.OutlinedButton(onClick = { showDialog = !showDialog }) {
                    androidx.compose.material3.Text(text = "Ok.")
                }
            },
            title = { androidx.compose.material3.Text(text = "Empty Entry(s)") },
            text = { androidx.compose.material3.Text("Kindly Enter Password and UserEmail") },
            icon = { Icon(Icons.Filled.Warning, contentDescription = null, tint = Color.Red) }
        )
    }

    if (alertSuccess) {

        AlertDialog(
            onDismissRequest = { alertSuccess = !alertSuccess },
            confirmButton = {
                androidx.compose.material3.OutlinedButton(onClick = {
                    alertSuccess = !alertSuccess
                }) {
                    androidx.compose.material3.Text(text = "Ok.")
                }
            },
            title = { androidx.compose.material3.Text(text = "Success") },
            text = { androidx.compose.material3.Text("Registration Successful") },
            icon = {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.size(30.dp)
                )
            }
        )
    }

    if (alertDuplicate) {
        AlertBox(
            title = "Email Exists",
            message = "The email is already registered!",
            icon = Icons.Filled.Warning,
            dialogue = alertDuplicate,
            color = Color.Red, accept = "OK")
    }
}
