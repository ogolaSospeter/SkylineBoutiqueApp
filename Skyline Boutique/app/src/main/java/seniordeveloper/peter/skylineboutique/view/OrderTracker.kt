package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models._orderStatus
import seniordeveloper.peter.skylineboutique.models.constants.Space

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun TrackOrder(navController: NavHostController){
    Column{
                TopAppBar(title = {Text("Track Order", color = colorResource(R.color.white))},
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp()}){
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = colorResource(R.color.white))
                        }
                    },
                    contentColor = colorResource(R.color.white),
                    backgroundColor = colorResource(R.color.statusBar),
                )
            Column {
                LazyColumn(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(1f)
                ) {
                    items(_orderStatus) { item ->
                        Card(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            backgroundColor = Color.Transparent,
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.padding(2.dp)
                                ) {
                                    AsyncImage(model = item.image,
                                        contentDescription = item.text,
                                        modifier = Modifier.size(80.dp)
                                        )
                                    Text(item.text)
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.padding(2.dp)
                                ) {
                                    Space(spaced = 3)
                                    Text("Status.")
                                    Space(3)
                                    AsyncImage(
                                        model = item.status,
                                        contentDescription = item.text,
                                        modifier = Modifier.size(50.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackOrderPreview(){
    TrackOrder(navController = rememberNavController())
}