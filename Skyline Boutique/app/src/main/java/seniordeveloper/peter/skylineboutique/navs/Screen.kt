package seniordeveloper.peter.skylineboutique.navs

sealed class Screen(val route: String){
    object  Home:Screen("home")
    object  Login:Screen("login")
    object  Registration:Screen("registration")
    object  About:Screen("about")
    object  Cart:Screen("cart")
    object  Settings:Screen("settings")
    object  Notifications:Screen("notifications")
    object  OrderTracker:Screen("ordertracker")
    object  PaymentHistory:Screen("paymenthistory")
    object ShoppingCart:Screen("shoppingcart")
    object  Undefined:Screen("undefined")
    object Category:Screen("category")
    object ItemDetails:Screen("itemdetails")
    object  Landing:Screen("landing")
    object ViewDatabase:Screen("viewdatabase")
    object  Payment:Screen("payment")


}
