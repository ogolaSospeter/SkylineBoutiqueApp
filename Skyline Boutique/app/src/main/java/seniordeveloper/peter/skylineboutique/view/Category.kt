package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.ClotheData
import seniordeveloper.peter.skylineboutique.models._menwears
import seniordeveloper.peter.skylineboutique.navs.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryPage(navController: NavHostController,category: String) {
    Column {
        TopAppBar(title = { Text(text = category) },
            navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "BackIcon")
            }
        },
        backgroundColor = colorResource(id = R.color.statusBar),
            contentColor = colorResource(id = R.color.white)
            )

        val filteredData = remember {
            mutableStateListOf<ClotheData>()
        }
        // Filter the data based on the category
        filteredData.clear()
        filteredData.addAll(_menwears.filter { it.category == category })

        // Display the filtered items
        LazyColumn {
            items(filteredData) { item ->
                // Display the item in your desired format
                Column(modifier = Modifier.padding(5.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(onClick = {
                        navController.navigate(Screen.ItemDetails.route + "/${item.title}")

                    }, modifier = Modifier
                        .fillMaxWidth()
                        .height(intrinsicSize = IntrinsicSize.Max)
                        .padding(5.dp),
                        ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(5.dp)

                        ) {
                            AsyncImage(
                                model = item.image,
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(200.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )

                            Text(text = " ${item.title} || ${item.category}")
                            Text(text = "Kshs. ${item.price}")
                            Text(text = item.description)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(colors = ButtonDefaults.buttonColors(colorResource(id = R.color.statusBar)),onClick = { /*TODO*/ }, modifier = Modifier
                                .width(150.dp)
                                .height(40.dp)) {
                                Text(text = "Add to Cart", color = colorResource(id = R.color.white))

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                        }

                    }
                }

            }
        }
    }
}
