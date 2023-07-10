package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.viewmodels.ClotheViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCartPage(navController: NavHostController) {
    val vm = ClotheViewModel()
    Column {
                TopAppBar(
                    title = { Text(text = "Shopping Cart", color = colorResource(id = R.color.white)) },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    backgroundColor = colorResource( R.color.statusBar),
                    contentColor = colorResource(R.color.white),

                )
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
            if (vm.cartItems.isEmpty()) {
                Text(text = "Your cart is empty.")
                Image(painter = painterResource(id = R.drawable.nocart), contentDescription = null)
            } else {
                LazyColumn {
                    items(vm.cartItems) { item ->
                        Text(text = item.title)
                    }
                }
            }

        }

    }


}
