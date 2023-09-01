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

 */