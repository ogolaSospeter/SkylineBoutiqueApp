package seniordeveloper.peter.skylineboutique.navs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import seniordeveloper.peter.skylineboutique.Home
import seniordeveloper.peter.skylineboutique.model.Settings

@Composable
fun AppNav(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(Screen.Home.route){ Home(navController) }
        composable(Screen.Settings.route){ Settings(navController) }

    }
}