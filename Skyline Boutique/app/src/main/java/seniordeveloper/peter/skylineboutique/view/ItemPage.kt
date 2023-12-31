package seniordeveloper.peter.skylineboutique.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.closetModel.ClosetData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemDetailsPage(navController: NavHostController, itemId: ClosetData) {
    val context = LocalContext.current
    val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
    val viewModelScope = rememberCoroutineScope()
    val selectItem = dbHandle.getClotheItem(itemId.title)
    Column {
        TopAppBar(
            title = {
                if (selectItem != null) {
                    Text(text = " ${selectItem.title}",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        color = colorResource(id = R.color.white))
                }
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "BackIcon")
                }
            },
            backgroundColor = colorResource(id = R.color.statusBar),
            contentColor = colorResource(id = R.color.white)
        )

//        val filteredData = remember {
//            mutableStateListOf<ClosetData>()
//        }
//        val filtData = dbHandle.getClosetData()
//        // Filter the data based on the category
//        filteredData.clear()
//        filtData?.filter { it.title == itemId.title }?.let { filteredData.addAll(it) }

        // Display the filtered items
//        LazyColumn {
//            items(filteredData)
        selectItem?.let{ item ->
                // Display the item in your desired format
                Column(modifier = Modifier.padding(2.dp)) {
                    Card(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(start = 5.dp, end = 5.dp, top = 2.dp, bottom = 5.dp)
                        ) {
                            AsyncImage(
                                model = item.image,
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(250.dp)
                                    .clip(CircleShape)
                                    .padding(2.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(text = item.title, fontSize = 20.sp, fontWeight = FontWeight.W500, overflow = TextOverflow.Ellipsis, maxLines = 1)
                            Text(text = "Price:  $ ${item.price}")
                            Text(text = "Category: ${item.category}")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = " Description: ",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.padding(start = 2.dp),
                                )
                            Text(text = item.description)
                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.statusBar)),
                                onClick = {
                                    viewModelScope.launch {
                                        dbHandle.addNewClothToCart(
                                            item.title,
                                            item.price,
                                            item.category,
                                            item.description,
                                            item.image
                                        )
                                        delay(500 )
                                        val maxTitleLength = 30 // Adjust the maximum length as needed

                                        val itemTitle = if (item.title.length > maxTitleLength) {
                                            "${item.title.substring(0, maxTitleLength)}..." // Truncate title if too long
                                        } else {
                                            item.title
                                        }
                                        Toast.makeText(context, "${itemTitle} added to cart Successfully", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(40.dp)
                            ) {
                                Text(
                                    text = "Add to Cart",
                                    color = colorResource(id = R.color.white)
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Reviews:",
                                fontStyle = MaterialTheme.typography.caption.fontStyle,
                                fontWeight = MaterialTheme.typography.h1.fontWeight
                            )
                            var rev = 0
                            Row {
                                while (rev < 5) {
                                    Icon(
                                        Icons.Filled.Star,
                                        contentDescription = null,
                                        tint = colorResource(
                                            id = R.color.statusBar
                                        )
                                    )
                                    rev++
                                }
                            }
                        }
                    }
                }
            }

        }
    }
//}

