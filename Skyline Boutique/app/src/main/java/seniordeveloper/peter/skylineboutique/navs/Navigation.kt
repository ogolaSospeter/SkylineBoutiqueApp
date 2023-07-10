package seniordeveloper.peter.skylineboutique.navs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import seniordeveloper.peter.skylineboutique.AboutApp
import seniordeveloper.peter.skylineboutique.Home
import seniordeveloper.peter.skylineboutique.Notifications
import seniordeveloper.peter.skylineboutique.model.Settings
import seniordeveloper.peter.skylineboutique.view.ClothesView
import seniordeveloper.peter.skylineboutique.view.TrackOrder
import seniordeveloper.peter.skylineboutique.view.UserLoginPage

@Composable
fun AppNav(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(Screen.Home.route){ Home(navController) }
        composable(Screen.Settings.route){ Settings(navController) }
        composable(Screen.About.route){ AboutApp(navController) }
//        composable(Screen.Login.route){ LoginPage(navController) }
        composable(Screen.Login.route){ UserLoginPage(navController) }

        composable(Screen.Cart.route){ ClothesView(navController)  }
        composable(Screen.CartContent.route){ Notifications(navController)  }
        composable(Screen.OrderTracker.route){ TrackOrder(navController)  }

    }
}