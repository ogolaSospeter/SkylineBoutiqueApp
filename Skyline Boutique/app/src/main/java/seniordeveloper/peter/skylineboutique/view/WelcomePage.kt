package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.models.constants.ActionButton
import seniordeveloper.peter.skylineboutique.models.constants.AlertBox
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.navs.Screen
import java.time.Duration


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLoginPage(context: Context, navController:NavHostController) {
    var userEmail by remember{ mutableStateOf("") }
    var password by  remember{ mutableStateOf("") }
    //Check email matches

    var passwordVisible by remember { mutableStateOf(false) }
    var showDialog by remember{mutableStateOf(false)}
    val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
    val viewModelScope = rememberCoroutineScope()
    var alertSuccess by remember { mutableStateOf(false) }
    var alertDuplicate by remember { mutableStateOf(false) }
    var alertNull by remember { mutableStateOf(false) }





    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

       Column(
            modifier = Modifier
//                .padding(top = 1.dp, start = 1.dp, end = 1.dp, bottom = 1.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Column(
            modifier = Modifier
                .padding(top = 2.dp, start = 13.dp, end = 13.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(15.dp))
            AsyncImage(
                model = "https://img.freepik.com/premium-vector/sign-page-abstract-concept-vector-illustration_107173-25670.jpg?size=626&ext=jpg&uid=R68194178&semt=sph",
                contentDescription = "nodata",
                modifier = Modifier
//                    .height(65.dp)
                    .size(350.dp)
                    .clip(RoundedCornerShape(2.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(R.string.logd),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(3.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = userEmail,
                onValueChange = { userEmail = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                placeholder = { Text(text = stringResource(R.string.username)) },
                keyboardActions = KeyboardActions(
                    onDone = {

                    }
                ),
                shape = RoundedCornerShape(10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        viewModelScope.launch {
                            run {
                                if (userEmail.isNotEmpty() && password.isNotEmpty()) {
                                    val user = dbHandle.getUser(userEmail)
                                    if (user != null && user.password == password) {
                                        alertSuccess = !alertSuccess
                                        delay(duration = Duration.ofMillis(2000))
                                        navController.navigate(Screen.Home.route)
                                    } else {
                                        if (user!==null) {
                                            alertDuplicate = !alertDuplicate
                                            delay(duration = Duration.ofMillis(2000))
                                            alertDuplicate = !alertDuplicate
                                        }
                                        if (user == null) {
                                            alertNull = !alertNull
                                            delay(duration = Duration.ofMillis(2000))
                                            alertNull = !alertNull
                                        }
                                        // Handle incorrect credentials here, e.g., show an error message
                                    }
                                }
                                else {
                                    showDialog = !showDialog
                                    delay(duration = Duration.ofMillis(2000))
                                    showDialog = !showDialog
                    }
                            }
                        }
                    }
                )                ,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                placeholder = { Text(text = stringResource(R.string.password)) },
                trailingIcon = {
                    val description =
                        if (passwordVisible) stringResource(R.string.hide_password) else stringResource(
                            R.string.show_password
                        )

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        if (passwordVisible)
                            Image(
                                painter = painterResource(id = R.drawable.visibility),
                                modifier = Modifier.size(20.dp),
                                contentDescription = description
                            )
                        else
                            Image(
                                painter = painterResource(id = R.drawable.visibility_off),
                                modifier = Modifier.size(20.dp),
                                contentDescription = description
                            )
                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
            Space(spaced = 20)
            //        Button(onClick = {showDialog = true},modifier = Modifier.width(150.dp)){

            Row(
                modifier = Modifier.safeContentPadding(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        viewModelScope.launch {
                            run {
                                if (userEmail.isNotEmpty() && password.isNotEmpty()) {
                                    val user = dbHandle.getUser(userEmail)
                                    if (user != null && user.password == password) {
                                        alertSuccess = !alertSuccess
                                        delay(duration = Duration.ofMillis(2000))
                                        navController.navigate(Screen.Home.route)
                                    } else {
                                        if (user!==null) {
                                            alertDuplicate = !alertDuplicate
                                            delay(duration = Duration.ofMillis(2000))
                                            alertDuplicate = !alertDuplicate
                                        }
                                        if (user == null) {
                                            alertNull = !alertNull
                                            delay(duration = Duration.ofMillis(2000))
                                            alertNull = !alertNull
                                        }
                                        // Handle incorrect credentials here, e.g., show an error message
                                    }
                                }
                                else {
                                    showDialog = !showDialog
                                    delay(duration = Duration.ofMillis(2000))
                                    showDialog = !showDialog


                                }
                            }
                        }
                    },
                    modifier = Modifier.width(150.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        color = Color.Black
                    )
                }

                ActionButton(R.string.register, Screen.Registration.route, 150, navController)
            }
            Space(spaced = 20)

        }
    }

    }
    if (showDialog) {
        AlertBox(title = "Empty Fields", message = "Fields Cannot be Empty!", icon = Icons.Filled.Warning, dialogue = showDialog,
            color = Color.Red, accept = "OK"
        )
    }
    if(alertSuccess){
        AlertBox(title = "Successful Login", message = "User $userEmail login Successful", icon = Icons.Filled.Done, dialogue = alertSuccess,
            color = Color.Green, accept = "OK"
        )
    }
    if (alertDuplicate) {
        AlertBox(
            title = "Incorrect Details",
            message = "Incorrect Email or Password!!",
            icon = Icons.Filled.Warning,
            dialogue = alertDuplicate,
            color = Color.Red, accept = "OK")
    }
    if (alertNull) {
        AlertBox(
            title = "No user.",
            message = "User $userEmail does not exist!!\nPlease Register.",
            icon = Icons.Filled.Warning,
            dialogue = alertNull,
            color = Color.Red, accept = "OK")
    }
}

@Preview(showBackground = true)
@Composable
fun LogPreview(){
    UserLoginPage(LocalContext.current,navController = rememberNavController())
}