package seniordeveloper.peter.skylineboutique.notes

/**
 * Created by Peter on 01.02.2021.\
 * DropdownMenuItem(text = { Text("Clothes")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("FootWear")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Belts")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Caps")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Official Wear")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Casuals")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Track Suits")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("African Wear")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Blazers")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Shorts")}, onClick = { Toast.makeText(context,"In progress.....",Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Settings")}, onClick = { Toast.makeText(context,R.string.progress,Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Payments History")}, onClick = { Toast.makeText(context,R.string.progress,Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Track Order")}, onClick = { Toast.makeText(context,R.string.progress,Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Promotions")}, onClick = { Toast.makeText(context,R.string.progress,Toast.LENGTH_SHORT).show() })
//                                DropdownMenuItem(text = { Text("Logout")}, onClick = { Toast.makeText(context,R.string.progress,Toast.LENGTH_SHORT).show() })


if (isCardClicked) {

BottomSheetScaffold(backgroundColor = Color.Transparent, sheetContent = {
Column(
modifier = Modifier.fillMaxWidth(),
horizontalAlignment = Alignment.CenterHorizontally
) {
Image(
painter = painterResource(menWear.image),
contentDescription = null,
modifier = Modifier.size(150.dp)
)
Text(
text = menWear.name,
color = Color.White,
fontWeight = FontWeight.Bold,
fontSize = 30.sp
)
Text(
text = "Kshs. ${menWear.price}",
color = Color.White,
fontWeight = FontWeight.Bold,
fontSize = 30.sp
)
Text(
text = menWear.description,
color = Color.White,
fontWeight = FontWeight.Bold,
fontSize = 30.sp
)
}
}, sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp), sheetPeekHeight = LocalConfiguration.current.screenHeightDp.dp.div(2)) {}
}

ModalBottomSheetLayout(
sheetContent = {
Column(
modifier = Modifier.fillMaxWidth(),
horizontalAlignment = Alignment.CenterHorizontally
) {
IconButton(
onClick = { coroutineScope.launch { bottomSheetState.hide() } },
modifier = Modifier.padding(16.dp)
) {
Icon(Icons.Filled.ArrowBack, "BackIcon", tint = Color.White)
}

Image(
painter = painterResource(menWear.image),
contentDescription = null,
modifier = Modifier.size(150.dp)
)
Text(
text = menWear.name,
color = Color.White,
fontWeight = FontWeight.Bold,
fontSize = 30.sp
)
Text(
text = "Kshs. ${menWear.price}",
color = Color.White,
fontWeight = FontWeight.Bold,
fontSize = 30.sp
)
Text(
text = menWear.description,
color = Color.White,
fontWeight = FontWeight.Bold,
fontSize = 30.sp
)
}
},
sheetState = bottomSheetState
) {
// Card content
}

"Clothes","FootWear","Belts","Caps","Official Wear","Casuals","Track Suits","African Wear","Blazers","Shorts",


//
//val menwears = listOf(
//    ClotheWear("shirts","T-Shirt", 29.99f, "Comfortable cotton t-shirt", R.drawable.lp1),
//    ClotheWear("shorts","Jeans", 49.69f, "Stylish denim jeans", R.drawable.st1),
//    ClotheWear("shirts","Men Shirt", 79.23f, "Style the show.", R.drawable.st2),
//    ClotheWear("shirts","Men Checked Shirt", 109.55f, "All events wear", R.drawable.st3),
//    ClotheWear("shirts","Cool & Drip Shirt", 120.30f, "Fluffy Cotton Shirt", R.drawable.st4),
//    ClotheWear("shirts","Executive wear", 134.57f, "Executive mens shirt", R.drawable.st5),
//    ClotheWear("shirts","Golden Crowned", 126.65f, "Men Shirt", R.drawable.st6),
//    ClotheWear("shirts","Chicago Wear", 157.67f, "Men Shirt", R.drawable.st7),
//
//    ClotheWear("shoes","Sneakers", 223.90f, "Sporty sneakers", R.drawable.st5)
//
//
//    )


package seniordeveloper.peter.skylineboutique.model

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class ClotheWear(val id: String, val title: String, val price: Int, val category: String, val description: String, val image: Int)



interface ClothingApiService {
@GET("products/category/clothing")
suspend fun getClothingItems(): List<ClotheWear>
}
suspend fun fetchClothingItems(): List<ClotheWear> {
val retrofit = Retrofit.Builder()
.baseUrl("https://fakestoreapi.com")
.addConverterFactory(GsonConverterFactory.create())
.build()

val apiService = retrofit.create(ClothingApiService::class.java)

return apiService.getClothingItems()

}
object ClothingData {
val menwears: List<ClotheWear> by lazy {
runBlocking {
fetchClothingItems().take(50)
}
}
}


if(showDialog){
AlertDialog(
onDismissRequest = { showDialog = false },
confirmButton = {
OutlinedButton(onClick = {showDialog = false}) {
Text(text = stringResource(R.string.ok))}
},
icon = { Icons.Filled.Info},
title = { Text(text = "Invalid Credentials!") },
text = { Text(text = "Kindly Fill in the Correct Credentials.") }
)
}
if(passLog){
AlertDialog(
onDismissRequest = { showDialog = false },
confirmButton = {
OutlinedButton(onClick = {showDialog = false}) {
Text(text = stringResource(R.string.ok))}
},
icon = { Icons.Filled.Info},
title = { Text(text = "Login Success!") },
text = { Text(text = "User Logged in Successsfully.") }
)
}



if(logErrorDialog){
AlertDialog(
onDismissRequest = { showDialog = false },
confirmButton = {
OutlinedButton(onClick = {logErrorDialog = false}) {
Text(text = stringResource(R.string.ok))}
},
icon = { Icons.Filled.Info},
title = { Text(text = "Invalid Credentials!") },
text = { Text(text = "Invalid Username or Password.") }
)
}
, colors = ButtonDefaults.elevatedButtonColors(White)

//        if (showDialog) {
//            AlertDialog(
//                onDismissRequest = { showDialog = false },
//                confirmButton = {
//                    OutlinedButton(onClick = {navController.navigate("mainPage")}) {
//                        Text(text = stringResource(R.string.login))}
//                    },
//                modifier = Modifier.width(400.dp).height(180.dp),
//                dismissButton = {
//                    OutlinedButton(onClick = {showDialog = false}) {
//                        Text(text = stringResource(R.string.cancel))}
//                },
//                icon = { Icons.Filled.Info},
//                title = { Text(text = "Confirm Login") },
//                text = { Text(text = "Proceed to Main Page?") }
//            )
//        }


//
//                    val groupedMenWears = clothes.groupBy { it.category }
//
//                    groupedMenWears.forEach { (id, items) ->
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(10.dp)
//                        ) {
//                            Text(
//                                text = id,
//                                style = TextStyle(
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold,
//                                    fontFamily = MaterialTheme.typography.titleMedium.fontFamily
//                                )
//                            )
//                            Spacer(modifier = Modifier.height(10.dp))
//
//                        }
//                        LazyRow {
//
//                            items(items.take(4)) { menWear ->
//                                ClotheCard(clotheWear = menWear)
//                            }
//                        }
//                    }




//Box {
//                                Column {
//                                    Icon(
//                                        Icons.Filled.ShoppingCart,
//                                        contentDescription = null,
//                                        modifier = Modifier.size(20.dp)
//                                    )
//                                    if (itemCount > 0) {
//                                        Box(
//                                            modifier = Modifier
//                                                .size(20.dp)
//                                                .background(Color.Red, shape = CircleShape)
//                                        ) {
//                                            Text(
//                                                text = itemCount.toString(),
//                                                color = Color.Red,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.align(Alignment.Center)
//                                            )
//                                        }
//                                    }
//                                }
//                            }


TopAppBar(
title = { Text("Your Notifications") },
colors = TopAppBarDefaults.centerAlignedTopAppBarColors( colorResource(id = R.color.statusBar)),
actions = {
IconButton(onClick = {navController.navigateUp() }) {
Icon(Icons.Filled.ArrowBack,contentDescription = null)
}
}

)




Row {
Icon(
Icons.Filled.Settings,
contentDescription = "General Settings",
tint = Color.Black,
modifier = Modifier.size(20.dp)
)
Spacer(modifier = Modifier.width(20.dp))
ClickableText(
text = AnnotatedString("General"),
onClick = {
showToast = ! showToast
}
)
if (showToast){
ToastMessage("Under General Development")
}
}
Spacer(modifier = Modifier.height(5.dp))
VariableData()
Spacer(modifier = Modifier.height(20.dp))
Row {
Icon(
Icons.Filled.Call,
contentDescription = "Sounds",
tint = Color.Black,
modifier = Modifier.size(20.dp)

)
Spacer(modifier = Modifier.width(20.dp))
ClickableText(
text = AnnotatedString("Sounds"),
onClick = {
showToast = ! showToast
}
)
if (showToast){
ToastMessage("This feature is still under Development")
}
}

Spacer(modifier = Modifier.height(5.dp))
VariableData()
Spacer(modifier = Modifier.height(20.dp))
Row {
Image(
painter = painterResource(R.drawable.language),
contentDescription = "App Language",
modifier = Modifier.size(20.dp)
)
Spacer(modifier = Modifier.width(20.dp))
ClickableText(
text = AnnotatedString("App Language"),
onClick = {
run{
navController.navigate(Screen.Cart.route)
}
}
)
}

Spacer(modifier = Modifier.height(5.dp))
VariableData()
Spacer(modifier = Modifier.height(20.dp))
Row {
Image(
painter = painterResource(R.drawable.backup),
contentDescription = "Backup",
modifier = Modifier.size(20.dp)

)
Spacer(modifier = Modifier.width(20.dp))
ClickableText(
text = AnnotatedString("Backup"),
onClick = {
showToast = ! showToast
}
)
if(showToast){
ToastMessage(message = "Backing Up soon!😘")
}
}

Spacer(modifier = Modifier.height(5.dp))
VariableData()
Spacer(modifier = Modifier.height(20.dp))
Row {
Image(
painter = painterResource(R.drawable.privacy),
contentDescription = "Privacy",
modifier = Modifier.size(20.dp)

)
Spacer(modifier = Modifier.width(20.dp))
ClickableText(
text = AnnotatedString("Privacy Center"),
modifier = Modifier.padding(top = 4.dp),
onClick = {
run {
navController.navigate(Screen.About.route)
showToast = ! showToast
}

}
)
if (showToast){
ToastMessage(message = "Feature under development")
}
}

Spacer(modifier = Modifier.height(5.dp))
VariableData()
Spacer(modifier = Modifier.height(20.dp))
NavigationDrawerItem(
label = { Text("Privacy Center") },
selected = true,
onClick = {
run {
navController.navigate(Screen.About.route)
showToast = ! showToast
}
}
)
Spacer(modifier = Modifier.height(5.dp))
VariableData()
Spacer(modifier = Modifier.height(5.dp))
NavigationDrawerItem(
icon = {Icon(Icons.Default.Person, "Person")},
label = { Text("About Developer") },
selected = true ,
onClick = { navController.navigate(Screen.About.route)},
colors = NavigationDrawerItemDefaults.colors(Color.White)
)
VariableData()
}
}


IconButton(onClick = { navController.navigate(Screen.Settings.route) }) {
Icon(
Icons.Filled.Settings,
contentDescription = null,
modifier = Modifier.size(20.dp)
)
}

OutlinedButton(onClick = { /*navController.navigate(Screen.Registration.route)*/ }
,modifier = Modifier.width(125.dp))
{
Text(
text = stringResource(R.string.register),
fontFamily = FontFamily.Monospace,
textAlign = TextAlign.Center,
fontStyle = FontStyle.Normal,
color = Color.Black
)
}

//                        item {
//                            OutlinedButton(
//                                onClick = { /*TODO*/ },
//                                shape = RoundedCornerShape(10)
//                            ) { Text("Gents") }
//                        }
//
//                        item {
//                            OutlinedButton(
//                                onClick = { /*TODO*/ },
//                                shape = RoundedCornerShape(10)
//                            ) { Text("Ladies") }
//                        }
//
//                        item {
//                            OutlinedButton(
//                                onClick = { /*TODO*/ },
//                                shape = RoundedCornerShape(10.dp)
//                            ) { Text("Children") }
//                        }
//
//                        item {
//                            OutlinedButton(
//                                onClick = { /*TODO*/ },
//                                shape = RoundedCornerShape(10.dp)
//                            ) { Text("Unisex") }
//                        }


Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 70.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.email),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Email link.",
//                    modifier = Modifier
//                        .size(20.dp)
//                        .clip(
//                            CircleShape
//
//                        )
//                )
//                Column(modifier = Modifier.padding(start = 50.dp, top = 5.dp)) {
//                    ClickableText(
//                        text = AnnotatedString("Reach Out to Us Via Email"),
//                        onClick = { navController.navigate("Emails") },
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 15.sp,
//
//                            )
//
//                    )
//                }
//            }
//            Divider(
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(end = 10.dp), color = Color.LightGray
//            )
//            Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 70.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.lp1),
//                    contentDescription = "Facebook",
//                    modifier = Modifier.size(25.dp)
//
//                )
//                Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
//                    ClickableText(
//                        text = AnnotatedString("Get Us on FaceBook"),
//                        onClick = { navController.navigate("FaceBook") },
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 15.sp,
//
//                            )
//                    )
//                }
//
//            }
//            Divider(
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(end = 10.dp), color = Color.LightGray
//            )
//
//            Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start =70.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.lp1),
//                    contentDescription = "Instagram",
//                    modifier = Modifier.size(30.dp)
//
//                )
//                Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
//                    ClickableText(
//                        text = AnnotatedString("Follow us on Instagram"),
//                        onClick = {},
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 15.sp,
//
//                            )
//
//                    )
//                }
//            }
//            Divider(
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(end = 10.dp), color = Color.LightGray
//            )
//
//            Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 70.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.lp1),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "WhatsApp",
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//
//                )
//                Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
//                    ClickableText(
//                        text = AnnotatedString("Let's Chat on WhatsApp"),
//                        onClick = {},
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 15.sp,
//
//                            )
//
//                    )
//                }
//            }
//            Divider(
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(end = 10.dp), color = Color.LightGray
//            )
//            Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 70.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.lp1),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "linkedIn",
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//
//                )
//                Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
//                    ClickableText(
//                        text = AnnotatedString("We're also on LinkedIn"),
//                        onClick = {},
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 15.sp,
//
//                            )
//
//                    )
//                }
//            }
//
//            Divider(
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(end = 10.dp), color = Color.LightGray
//            )
//        }


loginbuttons

//OutlinedButton(
//modifier = Modifier.width(250.dp),
//onClick = { navController.navigate(Screen.Home.route) }) {
//Row {
//Image(
//painter = painterResource(id = R.drawable.googlelogo),
//contentDescription = stringResource(R.string.googlelogo),
//modifier = Modifier.size(25.dp)
//)
//Text(
//stringResource(R.string.google_account_login),
//Modifier.offset(5.dp, 2.dp),
//color = Color.DarkGray
//)
//}
//}
//
//OutlinedButton(modifier = Modifier.width(250.dp), onClick = { }) {
//Row {
//Image(
//painter = painterResource(id = R.drawable.email),
//contentDescription = stringResource(R.string.email_logo),
//modifier = Modifier.size(25.dp)
//)
//Text(
//stringResource(R.string.email_account_login),
//Modifier.offset(5.dp, 2.dp),
//color = Color.DarkGray
//)
//}
//}
//
//OutlinedButton(
//modifier = Modifier.width(250.dp),
//onClick = { navController.navigate(Screen.Home.route) }) {
//Row {
//Image(
//painter = painterResource(id = R.drawable.phonelog),
//contentDescription = stringResource(R.string.phone_login),
//modifier = Modifier.size(25.dp)
//)
//Text(
//stringResource(R.string.login_with_phone),
//Modifier.offset(5.dp, 2.dp),
//color = Color.DarkGray
//)
//}
//}


 landing page
//                Text("Next", fontSize = 22.sp)
//                IconButton(onClick = {navController.navigate(Screen.Login.route)}) {
//                    Icon(Icons.Filled.ArrowForward,contentDescription = null,modifier=Modifier.size(25.dp), tint = colorResource(id = R.color.statusBar))
//                }


 Updating the sumtotal


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCartPage(navController: NavHostController) {
//    val vm = ClotheViewModel()
val quantity by remember { mutableIntStateOf(1) }

var sumTotal by remember{ mutableFloatStateOf(0.0F) }
// Create a list to store the calculated total prices for each item
val itemTotalPrices = _menwears.map { clotheWear ->
clotheWear.price * quantity.toFloat()
}

// Calculate the sum total by summing up all the item total prices
sumTotal = itemTotalPrices.sum()

Column {
TopAppBar(
title = { Text(text = "Shopping Cart", color = colorResource(id = R.color.white)) },
navigationIcon = {
IconButton(onClick = { navController.navigateUp() }) {
Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
}
},
backgroundColor = colorResource( R.color.statusBar),
contentColor = colorResource(R.color.white),

)
Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
if (_menwears.isEmpty()) {
EmptyCart()
}
else {
LazyColumn {
items(_menwears) { item ->
CartCard(clotheWear = item)
Space(spaced = 2)
}
item {
ElevatedCard(onClick = { /*TODO*/ }) {
val context = LocalContext.current
Row {
Column {
Text("Item Count:\n \t${_menwears.size}")
}
Column {
Text("\t\tTotal:\n \t${sumTotal}")
}
}
Space(spaced = 2)
OutlinedButton(onClick = {
Toast.makeText(
context,
"Checkout Initiated. Await the Payment Prompt",
Toast.LENGTH_SHORT
).show()
}) {
Text(text = "Proceed to Checkout")

}
}
}

}

}

}

}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartCard(clotheWear: ClotheData){

var quantity by remember { mutableIntStateOf(1) }
var totalPrice by remember { mutableStateOf(clotheWear.price * quantity) }

ElevatedCard(onClick = { /*TODO*/ },
modifier = Modifier.height(130.dp)) {
Row(modifier= Modifier
.fillMaxWidth()
.safeContentPadding(), horizontalArrangement = Arrangement.SpaceEvenly) {
Column{
Image(painter = painterResource(id = clotheWear.image),
contentDescription = null,
modifier = Modifier
.size(100.dp)
.clip(CircleShape),
contentScale = ContentScale.Crop)
Space(spaced = 5)
Text(text = clotheWear.title)

}
Column (modifier=Modifier.padding(top = 5.dp)){
Text(text = "Unit Price: Kshs.${clotheWear.price}")
Space(spaced =1)
Text("Quantity: ${quantity}")
Space(spaced =1)
Row(horizontalArrangement = Arrangement.spacedBy(5.dp)){
IconButton(onClick = {
if(quantity > 1){
quantity --
totalPrice -= clotheWear.price

}

}) {
Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Remove", tint = Color.Red)
}
IconButton(onClick = {
quantity ++
totalPrice += clotheWear.price

}) {
Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Add", tint = Color.Green)
}
}
Space(spaced =1)

Text(text = "Total: Kshs.${totalPrice}")

}

}
}
Space(spaced = 10)

}

//The item page
package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.models.ClotheData
import seniordeveloper.peter.skylineboutique.models._menwears

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemDetailsPage(navController: NavHostController, itemId: ClotheData) {
val context = LocalContext.current
val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
val viewModelScope = rememberCoroutineScope()
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
AsyncImage(
model = item.image,
contentDescription = item.title,
modifier = Modifier
//                    .height(65.dp)
.height(250.dp)
.clip(RoundedCornerShape(10.dp))
.fillMaxWidth()
.padding(2.dp),
contentScale = ContentScale.Crop
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
Row(){
while (rev <5){
Icon(Icons.Filled.Star,contentDescription = null, tint = colorResource(
id = R.color.statusBar
))
rev ++
}
}
//                            while (rev <5){
//                                Icon(Icons.Filled.Star,contentDescription = null, tint = colorResource(
//                                    id = R.color.statusBar
//                                ))
//                                rev ++
//                            }
}
}
}

}
}
}
}


//Shopping cart

package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dev.shreyaspatil.easyupipayment.EasyUpiPayment
import dev.shreyaspatil.easyupipayment.model.PaymentApp
import seniordeveloper.peter.skylineboutique.MainActivity
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.closetModel.ClosetData
import seniordeveloper.peter.skylineboutique.models.constants.Space
import seniordeveloper.peter.skylineboutique.navs.Screen
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCartPage(navController: NavHostController) {
var quantity by remember { mutableIntStateOf(1) }
var sumTotal by remember { mutableFloatStateOf(0.0F) }
val context = LocalContext.current
val activity = (LocalContext.current as? Activity)
val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
val viewModelScope = rememberCoroutineScope()
val cartCount = dbHandle.getCartCount()
var cartItems by remember { mutableStateOf(dbHandle.getCartData() ?: emptyList()) }

Column {
TopAppBar(
title = { Text(text = "Shopping Cart", color = colorResource(id = R.color.white)) },
navigationIcon = {
IconButton(onClick = { navController.navigateUp() }) {
Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
}
},
backgroundColor = colorResource(R.color.statusBar),
contentColor = colorResource(R.color.white),
actions = {
IconButton(onClick = {
dbHandle.deleteAllCartItems()
Toast.makeText(context, "Cart Emptied", Toast.LENGTH_SHORT).show()
}) {
Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = Color.White)
}
}
)
Column(
verticalArrangement = Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally,
modifier = Modifier.padding(20.dp)
) {
if (cartItems.isEmpty()) {
EmptyCart()
} else {
val itemTotalPrices = cartItems.map { clotheWear ->
clotheWear.price * quantity.toFloat()
}
// Calculate the sum total by summing up all the item total prices
sumTotal = itemTotalPrices.sum()
LazyColumn {
items(dbHandle.getCartData()!!) { item ->
CartCard(clotheWear = item, quantity,navController) { updatedPrice ->
sumTotal += updatedPrice
}
Space(spaced = 2)
}
item {
ElevatedCard(onClick = { /*TODO*/ },modifier =Modifier.fillMaxWidth()) {
Row {
Column {
Text("Shopping Cart Items Count:\n \t$cartCount")
}
Column {
Text("\t\tTotal:\n \t\t\t${sumTotal}")
}
}
Space(spaced = 2)
OutlinedButton(onClick = {
Toast.makeText(
context,
"Checkout Initiated. Await the Payment Prompt",
Toast.LENGTH_SHORT
).show()

//Payment Handling
// on below line we are getting date and then we
// are setting this date as transaction id.
val c: Date = Calendar.getInstance().getTime()
val df = SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault())
val transcId: String = df.format(c)
val description = "Skyline Boutique Online Shopping"

// on below line we are calling make
// payment method to make payment.
makePayment(
sumTotal.toString(),
sumTotal.toString(),
description,
transcId,
context,
activity!!,
mainActivity = activity
)
},
// on below line we are adding modifier to our button.
modifier = Modifier
.fillMaxWidth()
.padding(16.dp)
) {
Text(text = "Proceed to Checkout")
}
}
LaunchedEffect(cartItems) {
// This code will run whenever cartItems changes
cartItems = dbHandle.getCartData() ?: emptyList()
}
}

}
}
}
}
}

// on below line we are creating
// a make payment method to make payment.
private fun makePayment(
amount: String,
name: String,
desc: String,
transcId: String, ctx: Context, activity: Activity, mainActivity: Activity?
) {
try {
// START PAYMENT INITIALIZATION
val easyUpiPayment = EasyUpiPayment(activity) {
this.paymentApp = PaymentApp.ALL
this.payeeName = name
this.transactionId = transcId
this.transactionRefId = transcId
this.payeeMerchantCode = transcId
this.description = desc
this.amount = amount


}
// END INITIALIZATION
// Register Listener for Events
easyUpiPayment.setPaymentStatusListener(LocalContext as MainActivity)

// Start payment / transaction
easyUpiPayment.startPayment()
} catch (e: Exception) {
// on below line we are handling exception.
e.printStackTrace()
Toast.makeText(ctx, e.message, Toast.LENGTH_SHORT).show()
}
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartCard(clotheWear: ClosetData, initialQuantity: Int,navController: NavHostController, onUpdateTotal: (Float) -> Unit,) {
val context = LocalContext.current
val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
var quantity by remember {
mutableStateOf(initialQuantity)}
var totalPrice by remember { mutableFloatStateOf(clotheWear.price * quantity) }

ElevatedCard(
onClick = { /*TODO*/ },
modifier = Modifier.height(130.dp)
) {
Row(
modifier = Modifier
.fillMaxWidth()
.safeContentPadding(),
horizontalArrangement = Arrangement.SpaceEvenly
) {
Column {
AsyncImage(
model = clotheWear.image,
contentDescription = clotheWear.title,
modifier = Modifier
//                    .height(65.dp)
.size(95.dp)
.clip(RoundedCornerShape(10.dp)),
contentScale = ContentScale.Crop
)

Space(spaced = 5)
Text(text = clotheWear.title)
}
Column(modifier = Modifier.padding(top = 5.dp)) {
Text(text = "Unit Price: Kshs.${clotheWear.price}")
Space(spaced = 1)
Text("Quantity: $quantity")
Space(spaced = 1)
Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
IconButton(onClick = {
if (quantity > 1) {
quantity--
totalPrice -= clotheWear.price
onUpdateTotal(-clotheWear.price)
}
}) {
Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Remove", tint = Color.Red)
}
IconButton(onClick = {
quantity++
totalPrice += clotheWear.price
onUpdateTotal(clotheWear.price)
}) {
Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Add", tint = Color.Green)
}

IconButton(onClick = {
dbHandle.deleteCartItem(clotheWear.title)
Toast.makeText(context, "${clotheWear.title} Deleted Successfully.", Toast.LENGTH_SHORT).show()
navController.navigate(Screen.ShoppingCart.route)

}) {
Column {
Icon(Icons.Filled.Delete, contentDescription = null, tint = Color.Red)
Space(spaced = 1)
Text(text ="Delete")
}
}
}
Space(spaced = 1)
Text(text = "Total: Kshs.${totalPrice}")
}
}
}
Space(spaced = 10)
}

@Composable
fun EmptyCart(){
Text(text = "Your cart is empty.")
Image(painter = painterResource(id = R.drawable.nocart), contentDescription = null)
}


@Preview
@Composable
fun PreviewShoppingCartPage() {
ShoppingCartPage(navController = rememberNavController())
}

 */