package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.ClotheData
import seniordeveloper.peter.skylineboutique.models._menwears
import seniordeveloper.peter.skylineboutique.viewmodels.ClotheViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClothesView(navController:NavHostController) {
    val vm by remember { mutableStateOf(ClotheViewModel()) }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, "BackIcon")
                    }
                },
                title = { Text("Clothes View") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }
                    ) {
                        Icon(Icons.Filled.MoreVert, null)
                    }
                },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color( R.color.statusBar),Color( R.color.statusBar),Color( R.color.white),Color( R.color.white))
                )
        },
        floatingActionButton = {
                               FloatingActionButton(onClick = {
                                   vm.addClothe(_menwears.random())
                               }) {
                                   Icon(Icons.Filled.Add, null)
                               }
        },
        content = {

            Column(modifier = Modifier.padding(16.dp)) {
                LazyColumn {
                    items(vm.clotheData) {
                        CardContent(it)

                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardContent(clothe:ClotheData){
    val vm by remember { mutableStateOf(ClotheViewModel()) }
    Card(onClick = {
        vm.deleteClothe(clothe)
    }, modifier = Modifier.padding(8.dp).height(IntrinsicSize.Max).fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center,modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = clothe.image,
                contentDescription = clothe.title,
                modifier = Modifier
//                    .height(65.dp)
                    .height(70.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
//            Image(
//                painter = painterResource(id = clothe.image),
//                contentDescription = null,
//                Modifier.size(100.dp)
//            )
            Text(clothe.title)
            Text(clothe.category)
            Text(clothe.price.toString())
            Text( clothe.description)
        }
    }

}