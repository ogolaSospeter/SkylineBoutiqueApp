package seniordeveloper.peter.skylineboutique.models

import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.navs.Screen


data class ClotheData(val title: String, val price: Float, val category: String, val description: String, val image: String)

val _menwears = listOf(
    ClotheData("Men Suit", 4599.99f, "suits", generateRandomDescription(), "https://img.freepik.com/premium-photo/silk-blazer-isolated_624181-2387.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Jeans", 850.69f, "shorts", generateRandomDescription(), "https://img.freepik.com/free-photo/child-s-simple-plain-white-shorts_53876-97016.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Outdoor Short", 799.23f, "shorts", generateRandomDescription(),"https://img.freepik.com/premium-psd/white-shorts-isolated-mockup-realistic_181945-1354.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Men Checked Short", 1009.55f, "shorts", generateRandomDescription(), "https://img.freepik.com/premium-psd/shorts-pants-cotton-mockup-realistic_181945-1397.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Cool & Drip Suit", 3200.30f, "suits", generateRandomDescription(), "https://img.freepik.com/premium-photo/classic-shirt-black-silk-with-long-sleeves-pockets-chest-half-turn-front-side-back_236836-22576.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Executive wear", 1304.57f, "shorts", generateRandomDescription(), "https://img.freepik.com/free-photo/casual-men-short-pants_1203-8186.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
    ClotheData("Golden Crowned", 1260.65f, "shorts", generateRandomDescription(), "https://img.freepik.com/free-photo/casual-men-short-pants_1203-8171.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
    ClotheData("Chicago Wear", 1578.67f, "shorts", generateRandomDescription(), "https://img.freepik.com/premium-psd/shorts-pants-cotton-mockup-realistic_181945-1397.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Sneakers", 2235.90f, "shoes", generateRandomDescription(), "https://img.freepik.com/free-photo/men-s-ankle-sneakers-white-street-style-apparel-shoot_53876-119733.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
ClotheData("3-Piece Suits", 4235.00f, "suits", generateRandomDescription(), "https://img.freepik.com/free-vector/realistic-black-suit-object-white-with-cotton-shirt-strict-elegant-tie-colored-as-jacket-isolated_1284-49101.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
    ClotheData("Men-Flavor Suits", 5235.50f, "suits", generateRandomDescription(),"https://img.freepik.com/free-vector/mans-suit-realistic-composition-with-smart-costume-with-white-shirt-tie-jacket_1284-54345.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),


//     Dresses
    ClotheData("Dress 1", 650.00f, "dresses", generateRandomDescription(),"https://img.freepik.com/free-photo/fashion-woman-with-clothes_1203-8302.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
ClotheData("Dress 2", 500.00f, "dresses", generateRandomDescription(), "https://img.freepik.com/free-photo/graphic-woman-dress-trendy-design-white-background_460848-13623.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
ClotheData("Dress 3", 690.00f, "dresses", generateRandomDescription(), "https://img.freepik.com/free-photo/fashion-woman-with-clothes_1203-8302.jpg?size=626&ext=jpg&uid=R68194178&semt=sph"),
//// ... Add more dress items here
//
//// Shorts
//ClotheData("shorts", "Shorts 1", 29.99f, "shorts", generateRandomDescription(), R.drawable.shorts1),
//ClotheData("shorts", "Shorts 2", 39.99f, "shorts", generateRandomDescription(), R.drawable.shorts2),
//ClotheData("shorts", "Shorts 3", 49.99f, "shorts", generateRandomDescription(), R.drawable.shorts3),
//// ... Add more shorts items here
//
ClotheData("ShoesSneakers", 5799.99f, "shoes", generateRandomDescription(), "https://img.freepik.com/free-photo/pair-trainers_144627-3799.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
ClotheData( "Men Sneakers", 5999.99f, "shoes", generateRandomDescription(), "https://img.freepik.com/free-photo/fashion-shoes-sneakers_1203-7528.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
ClotheData( "Executive Leather", 2890.99f, "shoes", generateRandomDescription(), "https://img.freepik.com/free-photo/one-white-sneaker-shoe-isolated-white_93675-134695.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
    ClotheData( "Executive Leather", 3230.99f, "shoes", generateRandomDescription(), "https://img.freepik.com/free-photo/white-vintage-view-new-shoes_1203-6515.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),

//// ... Add more shoes items here
//
//// Shirts
ClotheData( "Blue Cotton", 699.99f, "shirts", generateRandomDescription(), "https://img.freepik.com/free-photo/men-shirt-clothing_1203-8356.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
ClotheData( "Cotton Grey", 990.00f, "shirts", generateRandomDescription(), "https://img.freepik.com/premium-psd/dress-shirt-mockup-front-vie_373676-5.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
    ClotheData( "Multi choice", 599.99f, "shirts", generateRandomDescription(), "https://img.freepik.com/free-photo/white-shirt_1339-6376.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
    ClotheData( "Checked Blue", 999.99f, "shirts", generateRandomDescription(), "https://img.freepik.com/premium-photo/mens-blue-shirt-isolated-white-background-generative-ai_945369-2069.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
    ClotheData( "Cotton White", 1200.90f, "shirts", generateRandomDescription(), "https://img.freepik.com/premium-psd/business-formal-blue-shirt-front-back-view-mock-up-template-your-design_34168-1391.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),

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
// Suits
ClotheData("Men Fashion Suits", 8000.00f, "suits", generateRandomDescription(), "https://img.freepik.com/free-vector/mans-suit-realistic-composition-with-smart-costume-with-white-shirt-tie-jacket_1284-54345.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
ClotheData("Dorn 3 Piece", 4570.50f,  "suits", generateRandomDescription(), "https://img.freepik.com/free-vector/man-suit-realistic-set-with-smart-jackets-neckties-shirts-different-colors-isolated-vector-illustration_1284-75786.jpg?size=626&ext=jpg&uid=R68194178&semt=ais"),
ClotheData("2 Piece Suit", 5700.00f, "suits", generateRandomDescription(), "https://img.freepik.com/free-vector/realistic-black-suit-object-white-with-cotton-shirt-strict-elegant-tie-colored-as-jacket-isolated_1284-49101.jpg?size=626&ext=jpg&uid=R68194178&semt=aisR.drawable.sut3"),
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
    OrderTracker(R.drawable.orderwait,"Awaiting Payment"),
    OrderTracker(R.drawable.orderprocessed,"Order Successfully Processed"),
    OrderTracker(R.drawable.ordercomplete,"Order Purchase Complete"),
    OrderTracker(R.drawable.orderdeliver,"Order Picked")
    )


data class SettingData(val image: Int, val txt:String, val route:String)

val setdata = listOf(
    SettingData(R.drawable.setting,"General",Screen.Undefined.route),
    SettingData(R.drawable.sounds,"Sounds",Screen.Undefined.route),
    SettingData(R.drawable.language,"App Language",Screen.Undefined.route),
    SettingData(R.drawable.backup,"BackUp",Screen.Undefined.route),
    SettingData(R.drawable.privacy,"Privacy Center",Screen.Undefined.route),
    SettingData(R.drawable.prsn,"About Developer",Screen.About.route),
)

data class OverFlow(val image: Int, val txt:String, val route:String)

val overFlow = listOf(
    OverFlow(R.drawable.setting,"Settings",Screen.Settings.route),
    OverFlow(R.drawable.history,"Payments History",Screen.PaymentHistory.route),
    OverFlow(R.drawable.ttrack,"Track Orders",Screen.OrderTracker.route),
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
    Contact("LinkedIn", "We're also on LinkedIn", R.drawable.ln,Screen.Undefined.route)
)