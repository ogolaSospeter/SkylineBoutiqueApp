package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models._orderStatus

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TrackOrder(navController: NavHostController){
    Column{
                TopAppBar(title = {Text("Track Order")},
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp()}){
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.MoreVert, contentDescription = "Back")
                        }
                    },
                    contentColor = colorResource(R.color.white),
                    backgroundColor = colorResource(R.color.statusBar),
                )
            Column {
                FlowRow(
                    maxItemsInEachRow = 1,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(1f)
                ) {
                    for (item in  _orderStatus){
                        Card(onClick = { /*TODO*/ }, enabled = true,modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)) {
                            Column {
                                Image(painter = painterResource(item.image), contentDescription = null, modifier = Modifier.size(100.dp))
                                Text(item.text)
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))

                }

            }

        }

    }
}

@Preview
@Composable
fun TrackOrderPreview(){
    TrackOrder(navController = rememberNavController())
}