package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.ClotheData
import seniordeveloper.peter.skylineboutique.models._menwears

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemDetailsPage(navController: NavHostController, itemId: ClotheData) {
    Column {
        TopAppBar(title = { Text(text = " ${itemId.title} || ${itemId.category}") },
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
        filteredData.addAll(_menwears.filter { it.title == itemId.title})

        // Display the filtered items
        LazyColumn {
            items(filteredData) { item ->
                // Display the item in your desired format
                Column(modifier = Modifier.padding(2.dp)) {
                    Card(onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = item.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(150.dp)
                                    .clip(CircleShape)
                            )
                            Text(text = item.title,fontSize = 20.sp, fontWeight = FontWeight.W500)
                            Text(text = "Price:  $ ${item.price}")
                            Text(text = "Category: ${item.category}")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = " Description: ", fontWeight = FontWeight.SemiBold, fontSize = 20.sp, textDecoration = TextDecoration.Underline)
                            Text(text = item.description)
                            Spacer(modifier = Modifier.height(10.dp))

                            Button(colors = ButtonDefaults.buttonColors(colorResource(id = R.color.statusBar)),onClick = { /*TODO*/ }, modifier = Modifier
                                .width(150.dp)
                                .height(40.dp)) {
                                Text(text = "Add to Cart", color = colorResource(id = R.color.white))

                            }
                            Spacer(modifier = Modifier.height(10.dp))
Text(text = "Reviews:", fontStyle = MaterialTheme.typography.caption.fontStyle, fontWeight = MaterialTheme.typography.h1.fontWeight)
                            var rev = 0
                            while (rev <5){
                                Icon(Icons.Filled.Star,contentDescription = null, tint = colorResource(
                                    id = R.color.statusBar
                                ))
                                rev ++
                            }
                        }
                    }
                }

            }
        }
    }
}
