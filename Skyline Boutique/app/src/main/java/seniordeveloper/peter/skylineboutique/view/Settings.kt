package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.constants.VariableData
import seniordeveloper.peter.skylineboutique.models.setdata

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        TopAppBar(backgroundColor = (colorResource(id = R.color.statusBar))) {

            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "BackIcon", tint = Color.White)
            }

            Text(
                text = "Settings",
                color = Color.White,
                modifier = Modifier.padding(start = 60.dp)
            )

        }
            Column(modifier = Modifier.padding(20.dp)) {

                setdata.forEach {item->
                    Row (modifier = Modifier
                        .clickable {
                            navController.navigate(item.route)
                        }
                        .height(50.dp)
                        .fillMaxWidth()
                        ,
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            item.image,
                            contentDescription = null,
                            modifier=Modifier.size(20.dp),
                            tint = colorResource(id = R.color.statusBar)
                            )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(item.txt)
                    }
                    VariableData()

                    }
                }
            }
        }

@Preview
@Composable
fun SettingsPreview() {
    Settings(navController = rememberNavController())
}
