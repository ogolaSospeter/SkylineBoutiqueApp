package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.ClotheData
import seniordeveloper.peter.skylineboutique.models._menwears

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryPage(navController: NavHostController,category: String) {
    Column {
        TopAppBar(title = { Text(text = category) },
            navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, "BackIcon")
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
                    Card(onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth()
                        .height(intrinsicSize = IntrinsicSize.Max)
                        .padding(5.dp),
                        ) {
                        Column(
                            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = item.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(150.dp)
                                    .clip(CircleShape),
                            )
                            Text(text = item.title)
                            Text(text = item.price.toString())
                            Text(text = item.description)
                            Text(text = item.category + "\n " )
                        }

                    }
                }

            }
        }
    }
}
