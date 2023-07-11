package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.constants.DividerDefaults
import seniordeveloper.peter.skylineboutique.models.contactData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutApp(navController: NavHostController) {
    Column {
        val color= Color(0xFF1976D2)


        Column(
            //modifier = Modifier.background(color = Color.Blue),
            verticalArrangement = Arrangement.Center
        ) {


            TopAppBar(backgroundColor = (colorResource(id = R.color.statusBar))) {

                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, "BackIcon", tint = Color.White)
                }

                androidx.compose.material.Text(
                    text = "About Developer",
                    color = Color.White,
                    modifier = Modifier.padding(start = 60.dp)

                )

            }


            val myImage = painterResource(id = R.drawable.ppl)
            Box {

                Column(modifier = Modifier) {

                    Row(modifier = Modifier.padding(top = 3.dp, start = 140.dp)) {
                        Image(
                            painter = myImage,
                            contentDescription = "Developer's image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .height(50.dp)
                                .width(50.dp)
                        )
                    }

                }
            }
            Text(
                text = "Developer's Contact Information:",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(start = 40.dp)
            )
            DividerDefaults()

            contactData.forEach {
                NavigationDrawerItem(
                    icon = {Icon(painter = painterResource(id = it.image), contentDescription = null)},
                    label = { Text(text = it.description)},
                    selected = false,
                    onClick = { navController.navigate(it.route)},
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 70.dp)
                    )
                DividerDefaults()

            }


    }
}
}

@Preview
@Composable
fun Preview(){
    AboutApp(navController = rememberNavController())
}