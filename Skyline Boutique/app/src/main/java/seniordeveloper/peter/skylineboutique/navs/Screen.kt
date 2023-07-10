package seniordeveloper.peter.skylineboutique.navs

sealed class Screen(val route: String){
    object  Home:Screen("home")
    object  Login:Screen("login")
    object  About:Screen("about")
    object  Cart:Screen("cart")
    object  Settings:Screen("settings")
    object  CartContent:Screen("cartcontent")
    object  OrderTracker:Screen("ordertracker")


}
