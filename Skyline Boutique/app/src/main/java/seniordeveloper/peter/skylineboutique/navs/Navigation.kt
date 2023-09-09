package seniordeveloper.peter.skylineboutique.navs

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import seniordeveloper.peter.skylineboutique.closetModel.ClosetDBHandler
import seniordeveloper.peter.skylineboutique.closetModel.ClosetViewDatabase
import seniordeveloper.peter.skylineboutique.models.constants.ToastMessage
import seniordeveloper.peter.skylineboutique.view.AboutApp
import seniordeveloper.peter.skylineboutique.view.CategoryPage
import seniordeveloper.peter.skylineboutique.view.ClothesView
import seniordeveloper.peter.skylineboutique.view.Home
import seniordeveloper.peter.skylineboutique.view.ItemDetailsPage
import seniordeveloper.peter.skylineboutique.view.LandingPage
import seniordeveloper.peter.skylineboutique.view.Notifications
import seniordeveloper.peter.skylineboutique.view.PaymentHistory
import seniordeveloper.peter.skylineboutique.view.Registration
import seniordeveloper.peter.skylineboutique.view.Sample
import seniordeveloper.peter.skylineboutique.view.Settings
import seniordeveloper.peter.skylineboutique.view.ShoppingCartPage
import seniordeveloper.peter.skylineboutique.view.TrackOrder
import seniordeveloper.peter.skylineboutique.view.Undefined
import seniordeveloper.peter.skylineboutique.view.UserLoginPage

@Composable
fun AppNav(context: Context, navController: NavHostController) {
    val context = LocalContext.current
    val dbHandle: ClosetDBHandler = ClosetDBHandler(context)
    NavHost(navController = navController, startDestination = Screen.Landing.route) {
        composable(Screen.Landing.route){ LandingPage(navController)}
        composable(Screen.Home.route) { Home(navController) }
        composable(Screen.Settings.route) { Settings(navController) }
        composable(Screen.About.route) { AboutApp(navController) }
//        composable(Screen.Login.route){ LoginPage(navController) }
        composable(Screen.Login.route) { UserLoginPage(context,navController) }

        composable(Screen.Cart.route) { ClothesView(navController) }
        composable(Screen.Notifications.route) { Notifications(navController) }
        composable(Screen.OrderTracker.route) { TrackOrder(navController) }
        composable(Screen.PaymentHistory.route) { PaymentHistory(navController) }
        composable(Screen.ShoppingCart.route) { ShoppingCartPage(navController) }
        composable(Screen.Undefined.route) { Undefined(navController) }
        composable(Screen.Category.route + "/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")

            if (category.isNullOrEmpty())
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
                val item = dbHandle.getClotheItem(itemId)
//                val item = _menwears.find { it.title == itemId }
                ItemDetailsPage(navController, itemId = item!!)
            } else {
                // Handle the case when the itemId is null, e.g., navigate back or show an error message
            }
        }
        composable(Screen.Sample.route) {Sample(navController) }
        composable(Screen.ViewDatabase.route) { ClosetViewDatabase(navController) }
        composable(Screen.Registration.route) { Registration(navController) }


    }
}



