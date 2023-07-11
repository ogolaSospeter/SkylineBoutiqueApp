package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BadgedBox
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.ClotheData
import seniordeveloper.peter.skylineboutique.models._menwears
import seniordeveloper.peter.skylineboutique.models.categories
import seniordeveloper.peter.skylineboutique.models.constants.GlobalWidgets
import seniordeveloper.peter.skylineboutique.models.overFlow
import seniordeveloper.peter.skylineboutique.navs.Screen


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    var menustate by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var itemCount by remember { mutableStateOf(0) }
    val categoryItems = _menwears.shuffled().take(4)
    var selectedItem by remember { mutableStateOf(0) }
    val navitems = listOf("Purchases", "Home", "On Order")
    val navicons = listOf(Icons.Filled.Build, Icons.Filled.Home, Icons.Filled.Info)
    val navs = listOf(Screen.OrderTracker.route, Screen.Home.route, Screen.Notifications.route)
    var selectedCategory by remember { mutableStateOf("") }


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
                                        leadingIcon = { Icon(painter = painterResource(id = item.image ), contentDescription = null, modifier = Modifier.size(20.dp))},
                                        text = { Text(item.txt, style = TextStyle(
                                        colorResource(id = R.color.black),
                                    ) )}, onClick = {
                                        run { navController.navigate(item.route) }
                                        Toast.makeText(
                                            context,
                                            "${R.string.progress}",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }, contentPadding = PaddingValues(10.dp))
                                }
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
                                if (itemCount > 0) {
                                    Text(
                                        text = itemCount.toString(),
                                        color = Color.Red,
                                        fontWeight = FontWeight.W800,
                                        fontSize = 15.sp
                                        )
                                }
                            }) {
                                Icon(
                                    Icons.Filled.ShoppingCart,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        IconButton(onClick = { navController.navigate(Screen.Sample.route) }) {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )

                        }

                    }

                )
            },

            bottomBar = {
                BottomAppBar{
                        navitems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                icon = { Icon(navicons[index], contentDescription = item)},
                                label = { androidx.compose.material3.Text(item) },
                                selected = selectedItem == index  ,
                                onClick = {
                                    selectedItem = index
                                    navController.navigate(navs[index])
                                }
                            )
                        }
                    }
            }
        ) {

            Column {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(2.dp)
                ) {
                    items(categories) { itm ->
                        OutlinedButton(
                            onClick = {
                                selectedCategory = itm
                                if (_menwears.filter { it.category == selectedCategory }
                                        .isNotEmpty()
                                ) {
                                    navController.navigate(Screen.Category.route + "/$selectedCategory")

                                } else {
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
                    GlobalWidgets(text = "Weekly Specials 🌟🌟")
                    Spacer(modifier = Modifier.height(3.dp))

                    LazyRow(content = {
                        items(categoryItems) { item ->
                            ClotheCard(clotheWear = item, onClick = {
                                navController.navigate(Screen.ItemDetails.route + "/${item.title}")
                                itemCount += 1
                            }
                            )
                        }
                    })
                    Spacer(modifier = Modifier.height(10.dp))
                    GlobalWidgets(text = "Specially Tailored.👔👕👘")
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        maxItemsInEachRow = 2,
                    ) {
                        _menwears.take(10).forEach {
                            ClotheCard(clotheWear = it, onClick = {
                                navController.navigate(Screen.ItemDetails.route + "/${it.title}")
                                itemCount += 1
                            }
                            )
                        }
                    }

                    val grouped = _menwears.groupBy { it.category }
                    grouped.forEach { (category, items) ->
                        GlobalWidgets(text = category)
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(7.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            items(items.take(4)) {
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

                }
            }
        }

    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClotheCard(clotheWear: ClotheData,onClick:() -> Unit = { }) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val isCardClicked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    val itemCount = remember { mutableStateOf(sharedPreferences.getInt("itemCount", 0)) }
    val editor = sharedPreferences.edit()


    Card(
        modifier = Modifier
            .size(width = 165.dp, height = 160.dp)
            .clickable {
                Toast
                    .makeText(context, "${clotheWear.title} Selected.", Toast.LENGTH_SHORT)
                    .show()
                onClick.invoke()
            },
        elevation = 2.dp,
    backgroundColor = Color.Transparent,
        ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = clotheWear.image),
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = clotheWear.title , style = TextStyle(fontSize = 12.sp))
            Text(text = "$. ${clotheWear.price}")
            Spacer(modifier =Modifier.height(3.dp))
//            OutlinedButton(onClick = {
//                onClick.invoke()
//                itemCount.value += 1
//                editor.putInt("itemCount", itemCount.value)
//                editor.apply()
//            }, ) {
//                Text(text = "Add to Cart", style = TextStyle(fontSize = 12.sp),color = Color.Blue)
//            }
            Spacer(modifier =Modifier.height(7.dp))

//            Text(text = clotheWear.description)
        }
    }



}
@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    Home(navController = rememberNavController())
}
