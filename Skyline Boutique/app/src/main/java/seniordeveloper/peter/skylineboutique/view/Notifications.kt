package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylineboutique.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notifications(navController: NavHostController){
    val items = listOf("Songs", "Artists", "Playlists")
    val icons = listOf(Icons.Filled.Favorite, Icons.Filled.Home, Icons.Filled.Favorite)
    var selectedItem by remember { mutableStateOf(0) }
    val clr = colorResource(id = R.color.statusBar)
    val cntclr = colorResource(id = R.color.white)

    Column{
    TopAppBar (
        title = { Text("Your Notifications", color = cntclr) },
        navigationIcon = {IconButton(onClick = {navController.navigateUp() }) {
            Icon(Icons.Filled.ArrowBack,contentDescription = null, tint = cntclr)
        }},
        backgroundColor = clr,
        contentColor = cntclr
    )
        Column (modifier=Modifier.padding(20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Your Notifications should appear here.")
            Image(painter = painterResource(id = R.drawable.not), contentDescription = null)
            Text(text = "Nothing here yet. Enjoy the Tranquility", fontSize = 8.sp, fontStyle = FontStyle.Italic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotifications(){
    Notifications(navController = rememberNavController())
}
