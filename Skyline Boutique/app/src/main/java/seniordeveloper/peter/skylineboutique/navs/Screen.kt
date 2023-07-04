package seniordeveloper.peter.skylineboutique.navs

sealed class Screen(val route: String){
    object  Home:Screen("home")
    object  Login:Screen("login")
    object  Settings:Screen("settings")
}
