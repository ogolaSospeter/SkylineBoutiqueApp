package seniordeveloper.peter.skylineboutique.closetModel

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClosetViewDatabase(navController:NavHostController)
{
    TopAppBar {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(Icons.Filled.ArrowBack, "BackIcon", tint = Color.White)
        }

        Text(
            text = "View Database Data",
            color = Color.White,
            modifier = Modifier.padding(start = 60.dp)

        )
    }

    Column {
        AddDataToDatabase(LocalContext.current)
    }

}

@Composable
fun AddDataToDatabase(
    context: Context
) {
    val clickCount = remember { mutableStateOf(0) }
    Column {
        val activity = context as Activity
        // on below line creating a variable for battery status
        val clothetitle = remember {
            mutableStateOf(TextFieldValue())
        }
        val clotheprice= remember {
            mutableStateOf(TextFieldValue())
        }
        val clothecategory = remember {
            mutableStateOf(TextFieldValue())
        }
        val clothedescription = remember {
            mutableStateOf(TextFieldValue())
        }
        val clotheimage = remember {
            mutableStateOf(TextFieldValue())
        }


        // on below line we are creating a column,
        Column(
            // on below line we are adding a modifier to it,
            modifier = Modifier
                .fillMaxSize()
                // on below line we are adding a padding.
                .padding(all = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            val dbHandler: ClosetDBHandler = ClosetDBHandler(context)

            // on below line we are adding a text for heading.
            Text(
                // on below line we are specifying text
                text = "SQlite Database in Android",
                // on below line we are specifying text color, font size and font weight
                color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = clothetitle.value,
                onValueChange = { clothetitle.value = it },
                placeholder = { Text(text = "Enter your clothe title") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = clothecategory.value,
                onValueChange = { clothecategory.value = it },
                placeholder = { Text(text = "Enter your clothe category") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = clotheprice.value,
                onValueChange = { clotheprice.value = it },
                placeholder = { Text(text = "Enter your clothe pricing") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = clothedescription.value,
                onValueChange = { clothedescription.value = it },
                placeholder = { Text(text = "Enter your clothe description") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = clotheimage.value,
                onValueChange = { clotheimage.value = it },
                placeholder = { Text(text = "Enter your clothe image") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Handle the "Done" action if needed
                    }
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {
                dbHandler.addNewCloth(
                    clothetitle.value.text,
                    clotheprice.value.text.toFloat(),
                    clothecategory.value.text,
                    clothedescription.value.text,
                    clotheimage.value.text
                )
                Toast.makeText(context, "Clothe item $clothetitle Added to Database", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Add Clothe to Database", color = Color.White)
            }
//
//            Spacer(modifier = Modifier.height(15.dp))
//            Button(
//                onClick = {
//                    if (clickCount.value < 1) {
//                        dbHandler.initializeDatabaseWithClothesData()
//                    }
//                    clickCount.value++
//                },
//                enabled = clickCount.value < 1 // Disable the button when clickCount is >= 1
//            ) {
//                Text(text = "Initialize the Database", color = Color.White)
//            }
            Spacer(modifier = Modifier.height(15.dp))

            // on below line creating a button to open view course activity
            Button(onClick = {
                val i = Intent(context, ViewClothes::class.java)
                context.startActivity(i)
            }) {
                // on below line adding a text for our button.
                Text(text = "Read Clothes to Database", color = Color.White)
            }
        }
    }
}