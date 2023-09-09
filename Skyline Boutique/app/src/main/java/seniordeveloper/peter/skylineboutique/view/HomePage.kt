package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BadgedBox
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.closetModel.ClosetData
import seniordeveloper.peter.skylineboutique.models.categories
import seniordeveloper.peter.skylineboutique.models.constants.GlobalWidgets
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.models.overFlow
import seniordeveloper.peter.skylineboutique.navs.Screen


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(navController: NavHostController) {
    var menustate by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var itemCount by remember { mutableStateOf(0) }
//    val categoryItems = _menwears.shuffled().take(4)
    var selectedItem by remember { mutableStateOf(0) }
    val navitems = listOf("Track Order", "Home", "Payment History")
    val navicons = listOf(Icons.Filled.Place, Icons.Filled.Home, Icons.Filled.DateRange)
    val navs = listOf(Screen.OrderTracker.route, Screen.Home.route, Screen.PaymentHistory.route)
    var selectedCategory by remember { mutableStateOf("") }
    val dbHandle:ClosetDBHandler = ClosetDBHandler(context)
    val cartCount = dbHandle.getCartCount()
    val categoryItems = dbHandle.getClosetData()?.shuffled()?.take(4)
    val catItems = dbHandle.getClosetData()?.shuffled()?.take(9)

    val closetData = dbHandle.getClosetData()




    Column {
        Scaffold(
            topBar = {
                TopAppBar(contentColor = Color.White,
                    backgroundColor = (colorResource(id = R.color.statusBar)),
                    title = { Text("Home Page") },
                    navigationIcon = {
                        IconButton(
                            onClick = { menustate = !menustate },
                            content = { Icon(Icons.Filled.Menu, contentDescription = null) })
                        if (menustate) {

                            DropdownMenu(
                                expanded = menustate,
                                onDismissRequest = { menustate = !menustate },
                                properties = PopupProperties(focusable = true),
                                offset = DpOffset.Zero,
                                modifier = Modifier
                                    .background(
                                        color = colorResource(id = R.color.white),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .width(170.dp)
                                    .height(IntrinsicSize.Max)
                            ) {
                                overFlow.forEach { item ->
                                    DropdownMenuItem(
                                        leadingIcon = { Icon(painter = painterResource(id = item.image ), contentDescription = null, modifier = Modifier.size(10.dp))},
                                        text = { Text(item.txt, style = TextStyle(
                                        colorResource(id = R.color.black),
                                    ) )}, onClick = {
                                        run { navController.navigate(item.route) }
                                            Toast.makeText(
                                                context,
                                                context.getString(R.string.select, item.txt),
                                                Toast.LENGTH_SHORT
                                            ).show()

                                        }, contentPadding = PaddingValues(10.dp))
                                }
                                Space(spaced = 5)
                                Divider(color = colorResource(id = R.color.black), thickness = 1.dp, startIndent = 2.dp)
                                Space(spaced = 5)
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.padding(start=5.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.prsn),
                                        contentDescription = "profile image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .clip(
                                                CircleShape
                                            )
                                            .size(50.dp)
                                    )
                                    Space(spaced = 2)
                                    Text(
                                        text = "captainsos483@gmail.com", style = TextStyle(
                                            colorResource(id = R.color.black),
                                        ), fontSize = 12.sp
                                    )
                                }
                                Space(spaced = 2)

                                Divider(color = colorResource(id = R.color.black), thickness = 1.dp, startIndent = 2.dp)

                            }
                        }
                    },
                    actions = {

                        IconButton(onClick = { navController.navigate(Screen.Notifications.route) }) {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        IconButton(onClick = { navController.navigate(Screen.ShoppingCart.route) }) {
                            BadgedBox(badge ={
//                                if (itemCount > 0) {
                                    Text(
                                        text = cartCount.toString(),
                                        color = Color.Red,
                                        fontWeight = FontWeight.W800,
                                        fontSize = 15.sp
                                        )

                            }
                                ) {
                                Icon(
                                    Icons.Filled.ShoppingCart,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp),
                                    tint = Color.White
                                )
                            }
                        }
                        Image(painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier= Modifier
                                .clip(CircleShape)
                                .size(30.dp),
                            contentScale = ContentScale.Crop)


                    }

                )
            },

            bottomBar = {
                BottomAppBar(modifier = Modifier.height(IntrinsicSize.Max)){
                        navitems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                icon = { Icon(navicons[index], contentDescription = item)},
                                label = { androidx.compose.material3.Text(item) },
                                selected = false,
//                                selected = selectedItem == index  ,
                                onClick = {
                                    selectedItem = index
                                    navController.navigate(navs[index])
                                },
                                alwaysShowLabel = true,
                                colors = NavigationBarItemDefaults.colors(
                                    colorResource(id = R.color.statusBar),
                                    colorResource(id = R.color.statusBar),
                                    Color.White,
                                    Color.Black,
                                    Color.Black
                                )

                            )
                        }
                    }
            }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.bk),
                    contentDescription = "background.",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.2f)
                )


                Column {

                    Column {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(2.dp)
                        ) {
                            items(categories) { itm ->
                                OutlinedButton(
                                    onClick = {
                                        selectedCategory = itm
                                        if(dbHandle.getClosetData()?.filter { it.category == selectedCategory }
                                                ?.isNotEmpty() == true){
                                            navController.navigate(Screen.Category.route + "/$selectedCategory")
//                                        if (_menwears.filter { it.category == selectedCategory }
//                                                .isNotEmpty()
//                                        ) {
//                                            navController.navigate(Screen.Category.route + "/$selectedCategory")
//
//                                        } else {
                                            navController.navigate(Screen.Undefined.route)
                                        }
                                        navController.navigate(Screen.Category.route + "/$selectedCategory")
                                    },
                                    shape = RoundedCornerShape(10.dp)
                                ) { Text(itm, color = colorResource(id = R.color.statusBar)) }
                            }

                        }
                        // Navigation route

//                    if (selectedCategory.isNotEmpty()) {
//                        navController.navigate(Screen.Category.route + "/$selectedCategory"
//                        )
//                    }
                        Spacer(modifier = Modifier.height(10.dp))
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                                .verticalScroll(
                                    state = ScrollState(1),
                                    enabled = true,
                                    flingBehavior = ScrollableDefaults.flingBehavior()
                                )
                        ) {
                            GlobalWidgets(text = "#Hot Deals🔥🔥")
                            Spacer(modifier = Modifier.height(5.dp))

                            LazyRow(content = {
                                items(categoryItems.orEmpty()) { item ->
                                    ClotheCard(clotheWear = item, onClick = {
                                        navController.navigate(Screen.ItemDetails.route + "/${item.title}")
                                        itemCount += 1
                                    }
                                    )
                                }
                            })
                            Spacer(modifier = Modifier.height(10.dp))
                            GlobalWidgets(text = "#Trending...\nThe Tailors' Choice✅")
                            Spacer(modifier = Modifier.height(5.dp))

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(7.dp),
                                verticalArrangement = Arrangement.Center,
                                maxItemsInEachRow = 3,
                            ) {
//                                for (category in categories) {
//                                    // Filter items for the current category
//                                    val categoryItemsForCategory =
//                                        categoryItems?.filter { it.category == category }

                                    catItems?.forEach {
                                        ClotheCard(clotheWear = it, onClick = {
                                            navController.navigate(Screen.ItemDetails.route + "/${it.title}")
                                            itemCount += 1
                                        }
                                        )
//                                    }
                                }
                            }
                            val closetItems = dbHandle.getClosetData()
                            val grouped = closetItems?.groupBy { it.category }
                            grouped?.forEach { (category, items) ->
                                GlobalWidgets(text = category)
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(7.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    items(items.take(3)) {
                                        ClotheCard(clotheWear = it, onClick = {
                                            navController.navigate(Screen.ItemDetails.route + "/${it.title}")
                                            itemCount += 1
                                        }
                                        )
                                    }
//                                    ClotheCard(clotheWear = it, onClick = {
//                                        navController.navigate(Screen.ItemDetails.route + "/${it.title}")
//                                        itemCount += 1
//                                    }
//                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row {
                                Text(
                                    "\nSkyliners Boutique.\nCome we Fashion You. #Price Meets QUALITY.",
                                    textAlign = TextAlign.Center,
                                    fontSize = 15.sp,
                                    color = colorResource(id = R.color.statusBar),
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 10.dp)
                                        .padding(bottom = 50.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(50.dp))

                        }

                    }
                }
            }
        }

    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClotheCard(clotheWear: ClosetData, onClick:() -> Unit = { }) {

    val context = LocalContext.current


    Card(
        modifier = Modifier
//            .size(width = 106.dp, height = 115.dp)
            .size(width = 105.dp, height = 120.dp)

            .clickable {
                Toast
                    .makeText(context, "${clotheWear.title} Selected.", Toast.LENGTH_SHORT)
                    .show()
                onClick.invoke()
            },
        elevation = 2.dp,
    backgroundColor = Color.Transparent,
        border = null,

        ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top =8.dp, start = 5.dp, end = 5.dp, bottom = 5.dp)
        ) {
            AsyncImage(
                model = clotheWear.image,
                contentDescription = clotheWear.title,
                modifier = Modifier
//                    .height(65.dp)
                    .height(70.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
//            Image(
//                painter = painterResource(id = clotheWear.image),
//                contentDescription = null,
//                modifier = Modifier
////                    .height(65.dp)
//                    .height(70.dp)
//                    .clip(RoundedCornerShape(2.dp))
//                    .fillMaxWidth(),
//                contentScale = ContentScale.Crop
//            )
            Text(text = clotheWear.title , style = TextStyle(fontSize = 12.sp))
            Text(text = "Kshs. ${clotheWear.price}")
            Spacer(modifier =Modifier.height(10.dp))
        }
    }


}
@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    Home(navController = rememberNavController())
}
