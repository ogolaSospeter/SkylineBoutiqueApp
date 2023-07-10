package seniordeveloper.peter.skylineboutique.navs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import seniordeveloper.peter.skylineboutique.models._menwears
import seniordeveloper.peter.skylineboutique.models.constants.ToastMessage
import seniordeveloper.peter.skylineboutique.view.AboutApp
import seniordeveloper.peter.skylineboutique.view.CategoryPage
import seniordeveloper.peter.skylineboutique.view.ClothesView
import seniordeveloper.peter.skylineboutique.view.Home
import seniordeveloper.peter.skylineboutique.view.ItemDetailsPage
import seniordeveloper.peter.skylineboutique.view.Notifications
import seniordeveloper.peter.skylineboutique.view.PaymentHistory
import seniordeveloper.peter.skylineboutique.view.Settings
import seniordeveloper.peter.skylineboutique.view.ShoppingCartPage
import seniordeveloper.peter.skylineboutique.view.TrackOrder
import seniordeveloper.peter.skylineboutique.view.Undefined
import seniordeveloper.peter.skylineboutique.view.UserLoginPage

@Composable
fun AppNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { Home(navController) }
        composable(Screen.Settings.route) { Settings(navController) }
        composable(Screen.About.route) { AboutApp(navController) }
//        composable(Screen.Login.route){ LoginPage(navController) }
        composable(Screen.Login.route) { UserLoginPage(navController) }

        composable(Screen.Cart.route) { ClothesView(navController) }
        composable(Screen.Notifications.route) { Notifications(navController) }
        composable(Screen.OrderTracker.route) { TrackOrder(navController) }
        composable(Screen.PaymentHistory.route) { PaymentHistory(navController) }
        composable(Screen.ShoppingCart.route) { ShoppingCartPage(navController) }
        composable(Screen.Undefined.route) { Undefined(navController) }
        composable(Screen.Category.route + "/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")

            if (category == null)
            {
                ToastMessage(message = "Category is null")
                // Handle the case when the category is null, e.g., navigate back or show an error message
            }

            else {
                CategoryPage(navController = navController, category = category)
            }

        }

        composable(Screen.ItemDetails.route + "/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")

            if (itemId != null) {
                // Retrieve the item details based on the itemId, e.g., from a database or data source
                val item = _menwears.find { it.title == itemId }
                ItemDetailsPage(navController, itemId = item!!)
            } else {
                // Handle the case when the itemId is null, e.g., navigate back or show an error message
            }
        }

    }
}


//        composable(Screen.Category.route + "/{category}") { backStackEntry ->
//            val category = backStackEntry.arguments?.getString("category")
//            // Check if category is not null before displaying the CategoryPage
//            category?.let {
//                CategoryPage(navController = navController, category = it)
//            }
//        }    }
//}
