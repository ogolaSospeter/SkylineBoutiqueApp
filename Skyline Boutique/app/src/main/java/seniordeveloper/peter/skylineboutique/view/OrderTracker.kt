package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.closetModel.ClosetData
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.models.constants.ToastMessage
import seniordeveloper.peter.skylineboutique.models.orderState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun TrackOrder(navController: NavHostController){
    val context = LocalContext.current
    val dbHandle:ClosetDBHandler = ClosetDBHandler(context)

    val orderData = dbHandle.getCartData()
    Column {
        TopAppBar(
            title = { Text("Track Order", color = colorResource(R.color.white)) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = colorResource(R.color.white)
                    )
                }
            },
            contentColor = colorResource(R.color.white),
            backgroundColor = colorResource(R.color.statusBar),
        )
        Column {
            if (orderData.isEmpty()) {
                Column(modifier = Modifier.padding(3.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    ToastMessage(message = "No Current Orders made!")
                    AsyncImage(
                        model = "https://img.freepik.com/free-vector/people-vector_53876-17382.jpg?size=626&ext=jpg&uid=R68194178&semt=ais",
                        contentDescription = "Empty order"
                    )
                    Space(spaced = 3)
                    Text(
                        "There are no Active Orders Yet",
                        fontSize = 12.sp,
                        fontFamily = MaterialTheme.typography.caption.fontFamily,
                        fontStyle = MaterialTheme.typography.overline.fontStyle,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            textMotion = TextMotion.Animated
                        ),
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(1f),
                    contentPadding = PaddingValues(3.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    items(orderData) { item ->
                        OrderCard(cartData = item)
                        Spacer(modifier = Modifier.height(5.dp))
                    }
//                    items(_orderStatus) { item ->
//                        Card(onClick = { /*TODO*/ },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(150.dp),
//                            backgroundColor = Color.Transparent,
//                        ) {
//                            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
//                                Column(
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.Center,
//                                    modifier = Modifier.padding(2.dp)
//                                ) {
//                                    AsyncImage(model = item.image,
//                                        contentDescription = item.text,
//                                        modifier = Modifier.size(80.dp)
//                                        )
//                                    Text(item.text)
//                                }
//                                Column(
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.Center,
//                                    modifier = Modifier.padding(2.dp)
//                                ) {
//                                    Space(spaced = 3)
//                                    Text("Status.")
//                                    Space(3)
//                                    AsyncImage(
//                                        model = item.status,
//                                        contentDescription = item.text,
//                                        modifier = Modifier.size(50.dp)
//                                    )
//                                }
//                            }
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                }
                }
            }
        }
    }
        }


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderCard(cartData:ClosetData){
    val randomIndex = kotlin.random.Random.nextInt(orderState.size)
    val ord = orderState[randomIndex]

    Card(onClick = { /*TODO*/ },
        elevation = 5.dp,
    ) {
        Column (

            modifier = Modifier.padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(model = cartData.image,
                contentDescription = cartData.title,
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(6.dp))
                ,
                contentScale = ContentScale.Crop
            )
            Text("Kshs. " + cartData.price)
            Space(spaced = 2)
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(ord.color)
                        .height(5.dp)
                        .width(15.dp)
                )
                Text(ord.state)
            }
            Space(spaced = 3)


        }

        
    }

}

@Preview(showBackground = true)
@Composable
fun TrackOrderPreview(){
    TrackOrder(navController = rememberNavController())
}