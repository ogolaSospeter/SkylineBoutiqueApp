package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
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
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.DataList
import seniordeveloper.peter.skylineboutique.navs.Screen


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLoginPage(navController:NavHostController) {
    var userName by remember{ mutableStateOf("") }
    var password by  remember{ mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var showDialog by remember{mutableStateOf(false)}
    var logErrorDialog by remember{mutableStateOf(false)}
    var passLog by remember{mutableStateOf(false)}
    val dataList = DataList()


//    val authViewModel: AuthViewModel = viewModel()
    val username by mutableStateOf("")
    val userPassword by mutableStateOf("")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(15.dp))
            Image(
                painter = painterResource(R.drawable.auth),
                contentDescription = stringResource(R.string.login_image),
                Modifier.size(250.dp)

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
                value = userName,
                onValueChange = { userName = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                placeholder = { Text(text = stringResource(R.string.username)) },
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle "Done" action */ }
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
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle "Done" action */ }
                ),
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
            Spacer(modifier = Modifier.height(15.dp))

            //        Button(onClick = {showDialog = true},modifier = Modifier.width(150.dp)){
            Row {
                OutlinedButton(onClick = {

                    if (userName != "" && password.length <= 8) {
                        navController.navigate(Screen.Home.route)

                    } else {
                        showDialog = !showDialog
                    }
                }, modifier = Modifier.width(125.dp)) {

                    Text(
                        text = stringResource(R.string.login),
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        color = Color.Black

                    )
                }
                ClickableText(
                    text = AnnotatedString(stringResource(R.string.register)),
                    onClick = {},
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.offset(5.dp, 13.dp)

                )

            }
            //

            OutlinedButton(
                modifier = Modifier.width(250.dp),
                onClick = { navController.navigate(Screen.Home.route) }) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.googlelogo),
                        contentDescription = stringResource(R.string.googlelogo),
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        stringResource(R.string.google_account_login),
                        Modifier.offset(5.dp, 2.dp),
                        color = Color.DarkGray
                    )
                }
            }

            OutlinedButton(modifier = Modifier.width(250.dp), onClick = { }) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = stringResource(R.string.email_logo),
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        stringResource(R.string.email_account_login),
                        Modifier.offset(5.dp, 2.dp),
                        color = Color.DarkGray
                    )
                }
            }

            OutlinedButton(
                modifier = Modifier.width(250.dp),
                onClick = { navController.navigate(Screen.Home.route) }) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.phonelog),
                        contentDescription = stringResource(R.string.phone_login),
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        stringResource(R.string.login_with_phone),
                        Modifier.offset(5.dp, 2.dp),
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogPreview(){
    UserLoginPage(navController = rememberNavController())
}