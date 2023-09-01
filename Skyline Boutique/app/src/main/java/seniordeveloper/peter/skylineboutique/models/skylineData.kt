package seniordeveloper.peter.skylineboutique.models

import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.navs.Screen


data class ClotheData(val title: String, val price: Float, val category: String, val description: String, val image: Int)

val _menwears = listOf(
    ClotheData("Men Suit", 4599.99f, "suits", generateRandomDescription(), R.drawable.sut2),
    ClotheData("Jeans", 409.69f, "shorts", generateRandomDescription(), R.drawable.st1),
    ClotheData("Outdoor Short", 799.23f, "shorts", generateRandomDescription(), R.drawable.st2),
    ClotheData("Men Checked Short", 1009.55f, "shorts", generateRandomDescription(), R.drawable.st3),
    ClotheData("Cool & Drip Suit", 3200.30f, "suits", generateRandomDescription(), R.drawable.sut3),
    ClotheData("Executive wear", 1304.57f, "shorts", generateRandomDescription(), R.drawable.st5),
    ClotheData("Golden Crowned", 1260.65f, "shorts", generateRandomDescription(), R.drawable.st6),
    ClotheData("Chicago Wear", 1578.67f, "shorts", generateRandomDescription(), R.drawable.st7),
    ClotheData("Sneakers", 2235.90f, "shoes", generateRandomDescription(), R.drawable.st5),
ClotheData("3-Piece Suits", 4235.90f, "suits", generateRandomDescription(), R.drawable.sut4),
    ClotheData("Men-Flavor Suits", 5235.90f, "suits", generateRandomDescription(), R.drawable.sut5),


//     Dresses
    ClotheData("Dress 1", 49.99f, "dresses", generateRandomDescription(), R.drawable.not),
ClotheData("Dress 2", 59.99f, "dresses", generateRandomDescription(), R.drawable.nocart),
ClotheData("Dress 3", 69.99f, "dresses", generateRandomDescription(), R.drawable.nocart),
//// ... Add more dress items here
//
//// Shorts
//ClotheData("shorts", "Shorts 1", 29.99f, "shorts", generateRandomDescription(), R.drawable.shorts1),
//ClotheData("shorts", "Shorts 2", 39.99f, "shorts", generateRandomDescription(), R.drawable.shorts2),
//ClotheData("shorts", "Shorts 3", 49.99f, "shorts", generateRandomDescription(), R.drawable.shorts3),
//// ... Add more shorts items here
//
ClotheData("ShoesSneakers", 99.99f, "shoes", generateRandomDescription(), R.drawable.nocart),
ClotheData( "Men Leather", 109.99f, "shoes", generateRandomDescription(), R.drawable.nopage),
ClotheData( "Executive Leather", 119.99f, "shoes", generateRandomDescription(), R.drawable.nonot),
//// ... Add more shoes items here
//
//// Shirts
ClotheData( "Multi choice", 39.99f, "shirts", generateRandomDescription(), R.drawable.ppl),
ClotheData( "Cotton White", 49.99f, "shirts", generateRandomDescription(), R.drawable.ppl),
//ClotheData("shirts", "Shirt 3", 59.99f, "shirts", generateRandomDescription(), R.drawable.shirt3),
//// ... Add more shirts items here
//
//// Vests
//ClotheData("vests", "Vest 1", 19.99f, "vests", generateRandomDescription(), R.drawable.vest1),
//ClotheData("vests", "Vest 2", 29.99f, "vests", generateRandomDescription(), R.drawable.vest2),
//ClotheData("vests", "Vest 3", 39.99f, "vests", generateRandomDescription(), R.drawable.vest3),
//// ... Add more vests items here
//
//// Jackets
//ClotheData("jackets", "Jacket 1", 89.99f, "jackets", generateRandomDescription(), R.drawable.jacket1),
//ClotheData("jackets", "Jacket 2", 99.99f, "jackets", generateRandomDescription(), R.drawable.jacket2),
//ClotheData("jackets", "Jacket 3", 109.99f, "jackets", generateRandomDescription(), R.drawable.jacket3),
//// ... Add more jackets items here
//
//// Suits
//ClotheData("suits", "Suit 1", 199.99f, "suits", generateRandomDescription(), R.drawable.suit1),
//ClotheData("suits", "Suit 2", 209.99f, "suits", generateRandomDescription(), R.drawable.suit2),
//ClotheData("suits", "Suit 3", 219.99f, "suits", generateRandomDescription(), R.drawable.suit3),
//// ... Add more suits items here
)

fun generateRandomDescription(): String {
    val descriptions = listOf(
        "Experience unmatched comfort and style with our collection of premium clothing. Crafted with care and attention to detail, these garments are designed to elevate your look and keep you feeling confident.",
        "Step into luxury with our exquisite clothing collection. Each piece is carefully crafted to provide unparalleled comfort and style. Made from the finest materials, our garments offer a high-quality experience that will leave you feeling confident and empowered.",
        "Embrace modern design with our cutting-edge styles that combine fashion-forward aesthetics with impeccable craftsmanship. Enjoy a perfect fit that flatters your body and enhances your natural curves.",
        "Discover elegance and sophistication in every stitch. Our clothing is designed to withstand the test of time, providing enduring quality and timeless appeal.",
        "Add a touch of elegance to your wardrobe with our premium clothing collection. From formal occasions to casual outings, our garments are versatile and suitable for any event.",
        "Experience the ultimate comfort with our collection of soft and breathable fabrics. Whether you're lounging at home or going out for a night on the town, our clothing will keep you feeling cozy and stylish.",
        "Upgrade your wardrobe with our trendy and fashion-forward designs. Stay ahead of the fashion curve and make a statement with our unique and eye-catching styles.",
        "Indulge in the luxury of our premium materials and impeccable craftsmanship. Our clothing is meticulously made to provide a superior fit and feel.",
        "Dress to impress with our collection of stylish and sophisticated clothing. From tailored suits to elegant dresses, our garments exude class and refinement.",
        "Experience the perfect blend of comfort and style. Our clothing is designed to enhance your confidence and make you look and feel your best.",
        "Elevate your look with our collection of fashion essentials. From classic basics to statement pieces, our clothing will take your style to new heights.",
        "Invest in quality and craftsmanship with our premium clothing collection. Each piece is made with attention to detail and designed to stand the test of time.",
        "Discover the joy of dressing well with our carefully curated collection of clothing. Express your unique sense of style and make a lasting impression wherever you go.",
        "Unleash your individuality with our collection of bold and expressive clothing. Stand out from the crowd and let your fashion choices reflect your personality.",
        "Experience the confidence that comes from wearing well-fitted and flattering clothing. Our garments are designed to complement your body and enhance your natural features.",
        "Step out in style with our collection of trendy and fashion-forward clothing. From casual streetwear to formal attire, we have the perfect outfit for every occasion.",
        "Make a statement with our collection of eye-catching and unique clothing. Express your personal style and let your outfit be a reflection of your creativity.",
        "Experience the luxury of our premium fabrics against your skin. Our clothing offers a sumptuous feel and exceptional comfort that will keep you coming back for more.",
        "Upgrade your wardrobe with our collection of timeless classics. From essential basics to elegant pieces, our clothing will never go out of style.",
        "Discover the perfect balance of comfort and elegance with our collection of sophisticated clothing. From tailored silhouettes to relaxed styles, we have something for every taste.",
        "Experience the difference that quality makes with our premium clothing collection. Our garments are made to the highest standards, ensuring long-lasting durability and style."
    )

    return descriptions.random()
}


class DataList {
    val mutableStringList = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday")
    //    val mutableLoginData = mutableMapOf("username" to "password")
    val mutableLoginData = mutableMapOf<String, String>()

}

data class OrderTracker(val image:Int,val text:String)

val _orderStatus = listOf<OrderTracker>(
    OrderTracker(R.drawable.placeorder,"Order Placed"),
    OrderTracker(R.drawable.orderpaymentwait,"Awaiting Payment"),
    OrderTracker(R.drawable.orderprocessed,"Order Successfully Processed"),
    OrderTracker(R.drawable.ordercomplete,"Order Purchase Complete"),
    OrderTracker(R.drawable.orderpaymentwait,"Order Picked")
    )


data class SettingData(val image: Int, val txt:String, val route:String)

val setdata = listOf(
    SettingData(R.drawable.settings,"General",Screen.Home.route),
    SettingData(R.drawable.sound,"Sounds",Screen.Undefined.route),
    SettingData(R.drawable.language,"App Language",Screen.Undefined.route),
    SettingData(R.drawable.backup,"BackUp",Screen.Undefined.route),
    SettingData(R.drawable.privacy,"Privacy Center",Screen.Undefined.route),
    SettingData(R.drawable.person,"About Developer",Screen.About.route),
)

data class OverFlow(val image: Int, val txt:String, val route:String)

val overFlow = listOf(
    OverFlow(R.drawable.settings,"Settings",Screen.Settings.route),
    OverFlow(R.drawable.payment,"Payments History",Screen.PaymentHistory.route),
    OverFlow(R.drawable.tracks,"Track Orders",Screen.OrderTracker.route),
    OverFlow(R.drawable.person,"About Us",Screen.About.route),
    OverFlow(R.drawable.logout,"Log Out",Screen.Login.route)
)

data class LazyList(val txt:String, val route:String)

val lazLst = listOf(
    LazyList("Gents",Screen.Undefined.route),
    LazyList("Ladies",Screen.Undefined.route),
    LazyList("Children",Screen.Undefined.route),
    LazyList("Unisex",Screen.Undefined.route),
)

val categories = listOf("suits","shorts","shirts","jackets","dresses","trousers")

data class Contact(val name: String, val description: String, val image: Int, val route: String) {
}

val contactData = listOf(
    Contact("Email", "Reach Out to Us Via Email", R.drawable.email,Screen.Undefined.route),
    Contact("Facebook", "Get Us on FaceBook", R.drawable.fb,Screen.Undefined.route),
    Contact("Instagram", "Follow us on Instagram", R.drawable.ig,Screen.Undefined.route),
    Contact("WhatsApp", "Let's Chat on WhatsApp", R.drawable.what,Screen.Undefined.route),
    Contact("LinkedIn", "We're also on LinkedIn", R.drawable.lkn,Screen.Undefined.route)
)