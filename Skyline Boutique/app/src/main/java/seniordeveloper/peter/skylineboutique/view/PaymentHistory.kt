package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylineboutique.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentHistory(navController: NavHostController) {
    Column{
       TopAppBar(
           title = { Text("Payment History", color = colorResource(id =R.color.white)) },
           navigationIcon = {
               IconButton(onClick = { navController.navigateUp() }) {
                   Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
               }
           },
           contentColor = colorResource(id =R.color.white),
           backgroundColor = colorResource(id = R.color.statusBar),
       )
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "No Payment History", style = MaterialTheme.typography.h6)
            Image(painter = painterResource(id = R.drawable.paym), contentDescription = null)
        }
        }
        }
@Preview
@Composable
fun PaymentHistoryPreview(){
    PaymentHistory(navController = rememberNavController())
}



