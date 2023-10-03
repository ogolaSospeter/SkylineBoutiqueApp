package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
            AsyncImage(model = "https://img.freepik.com/free-vector/404-error-page-found_41910-364.jpg?size=626&ext=jpg&uid=R68194178&semt=ais",
                contentDescription = "nodata",
                modifier=Modifier.size(200.dp)
                )
            Text(text = stringResource(id = R.string.progress))

        }
    }
)
    }
}