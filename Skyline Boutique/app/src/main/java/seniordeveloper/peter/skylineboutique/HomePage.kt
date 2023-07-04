package seniordeveloper.peter.skylineboutique

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylineboutique.model.MenWear
import seniordeveloper.peter.skylineboutique.model.menwear
import seniordeveloper.peter.skylineboutique.navs.Screen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(navController: NavHostController){
    val scaffoldState = rememberScaffoldState()
    var menustate by remember{ mutableStateOf(false) }
    val context = LocalContext.current
    Column() {
        Scaffold (
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(title = {Text("Home Page")},
                    navigationIcon = {IconButton(onClick = {menustate = !menustate}, content = {Icon(Icons.Filled.Menu,contentDescription = null)})},
                    actions = {
                        Column {
                            Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        Icons.Filled.Favorite,
                                        contentDescription = null,
                                        tint = Color.Red,
                                        modifier = Modifier.size(15.dp)
                                    )
                                }
                                IconButton(onClick = { navController.navigate(Screen.Settings.route) }) {
                                    Icon(
                                        Icons.Filled.Settings,
                                        contentDescription = null,
                                        modifier = Modifier.size(15.dp)
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        Icons.Filled.Notifications,
                                        contentDescription = null,
                                        modifier = Modifier.size(15.dp)
                                    )
                                }
                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Filled.ShoppingCart,
                                        contentDescription = null,
                                        modifier = Modifier.size(15.dp)
                                    )
                                }
                            }
                        }


                        if(menustate){

                            val itemLists = listOf("Clothes","FootWear","Belts","Caps","Official Wear","Casuals","Track Suits","African Wear","Blazers","Shorts","Settings","Payments History","Track Orders","About Us","Log Out")

//                             itemLists.forEach { item ->
//                                DropdownMenuItem(text = {Text(item)},onClick = { Toast.makeText(context,"${R.string.progress}",Toast.LENGTH_SHORT).show() })
//                            }
                            DropdownMenu(expanded = menustate, onDismissRequest = { menustate = !menustate}, properties = PopupProperties(focusable = true), offset = DpOffset.Zero) {
                                itemLists.forEach { item ->
                                    DropdownMenuItem(text = {Text(item)},onClick = { Toast.makeText(context,"${R.string.progress}",Toast.LENGTH_SHORT).show() })
                                }
                            }

                        }
                    }

                ) },
            bottomBar = {
                BottomAppBar(
                    contentPadding = PaddingValues(10.dp),
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.AccountBox, contentDescription = null)
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Home, contentDescription = null)

                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.MoreVert, contentDescription = null)

                            }

                        }

                    })
            },
            content = {
                Column {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(5.dp)){
                        OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(10)) {Text("Gents")}
                        OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(10)) {Text("Ladies")}
                        OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(10.dp)) {Text("Children")}
                        OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(10.dp)) {Text("Unisex")}

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Weekly Specials", style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MaterialTheme.typography.titleMedium.fontFamily
                    ))
                    LazyVerticalGrid(
                        columns =  GridCells.Fixed(2),
                        contentPadding = PaddingValues(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        content = {
                        items(menwear){
                                menWear ->
                            ClotheCard(menWear = menWear)
                        }
                    })
//
                }
            }
        )


    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClotheCard(menWear: MenWear) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val isCardClicked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .size(width = 150.dp, height = 150.dp)
            .clickable { coroutineScope.launch { bottomSheetState.show() } },
        elevation = 2.dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(menWear.image),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(text = menWear.name)
            Text(text = "Kshs. ${menWear.price}")
            Text(text = menWear.description)
        }
    }



}
@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    Home(navController = rememberNavController())
}
