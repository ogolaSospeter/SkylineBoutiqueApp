package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Undefined(navController: NavHostController) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
Scaffold(
    topBar ={
        TopAppBar(backgroundColor = colorResource(id = R.color.white), contentColor = colorResource(R.color.statusBar)) {
            BottomNavigationItem(icon = { Icons.Filled.ThumbUp},selected = true, onClick = { navController.navigateUp() },
                label = { Text(text = "Go Back")}
            )
        }
    },
    content = {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.nodata), contentDescription = null)
            Text(text = stringResource(id = R.string.progress))

            AsyncImage(model="https://img.freepik.com/free-vector/fashion-shop-concept-illustration_114360-9613.jpg?w=740&t=st=1694098633~exp=1694099233~hmac=2f28f0e34d13a98acca3e5e53529334f27875251819fc193f4675b1f855be74b",contentDescription="loaded immage")
        }
    }
)
    }
}