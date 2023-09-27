package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.constants.Space

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentHistory(navController: NavHostController) {
    Column{
       TopAppBar(
           title = { Text("Payment History", color = colorResource(id =R.color.white)) },
           navigationIcon = {
               IconButton(onClick = { navController.navigateUp() }) {
                   Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
            AsyncImage(
//                model = "https://img.freepik.com/premium-vector/utility-bills-statements-electricity-natural-gas-water-internet-telephone_183665-887.jpg?size=626&ext=jpg&uid=R68194178&semt=ais",
                model ="https://img.freepik.com/free-vector/payment-with-mobile-phone_1133-381.jpg?size=626&ext=jpg&uid=R68194178&semt=ais",
                contentDescription = "nodata",
                modifier = Modifier
//                    .height(65.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Space(spaced = 5)
            Text(text = "You have not made any Purchases yet.", fontSize = 8.sp, fontStyle = FontStyle.Italic)
        
        }
        }
        }
@Preview
@Composable
fun PaymentHistoryPreview(){
    PaymentHistory(navController = rememberNavController())
}



