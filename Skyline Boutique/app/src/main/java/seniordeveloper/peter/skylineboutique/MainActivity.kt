package seniordeveloper.peter.skylineboutique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.androidstudy.daraja.Daraja
import seniordeveloper.peter.skylineboutique.navs.AppNav
import seniordeveloper.peter.skylineboutique.navs.Screen
import seniordeveloper.peter.skylineboutique.ui.theme.SkylineBoutiqueTheme
import seniordeveloper.peter.skylineboutique.viewmodels.UserState
import seniordeveloper.peter.skylineboutique.viewmodels.UserStateViewModel


class MainActivity : ComponentActivity() {
     lateinit var daraja:Daraja
    private val userState by viewModels<UserStateViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            SkylineBoutiqueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val context = LocalContext.current
                    AppNav(context,navController = navController)                   }
            }

        }

    }

}

@Composable
fun ApplicationSwitcher(navController: NavHostController) {
    val vm = UserState.current
    if (vm.isLoggedIn) {
        navController.navigate(Screen.Home.route)
    } else {
        navController.navigate(Screen.Login.route)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}