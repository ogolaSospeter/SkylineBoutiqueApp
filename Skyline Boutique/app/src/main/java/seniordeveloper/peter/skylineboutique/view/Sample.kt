package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.room.Room
import seniordeveloper.peter.skylineboutique.databaseHandlers.Closet
import seniordeveloper.peter.skylineboutique.databaseHandlers.ClosetDatabase


@Composable
fun Sample(navController: NavHostController) {
    val context = LocalContext.current
    Column {
        val instance = context.applicationContext?.let {
            Room.databaseBuilder(
                it,
                ClosetDatabase::class.java,
                "closet.db"
            ).build()
        }

        val myclothes = instance?.closetDao()?.getAll() ?: emptyList()

        LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
            items(myclothes) { item ->
                item?.let { closetItem ->
                    ClosetCard(clotheWear = closetItem, onClick = { /* TODO */ })
                }
            }
        })

    }
}



@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClosetCard(clotheWear: Closet, onClick:() -> Unit = { }) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    val itemCount = remember { mutableStateOf(sharedPreferences.getInt("itemCount", 0)) }
    val editor = sharedPreferences.edit()


    Card(
        modifier = Modifier
            .size(width = 165.dp, height = 160.dp)
            .clickable {
                Toast
                    .makeText(context, "${clotheWear.title} Selected.", Toast.LENGTH_SHORT)
                    .show()
                onClick.invoke()
            },
        elevation = 2.dp,
        backgroundColor = Color.Transparent,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(5.dp)
        ) {
            clotheWear.image?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier
                        .height(80.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            clotheWear.title?.let { Text(text = it, style = TextStyle(fontSize = 12.sp)) }
            Text(text = "$. ${clotheWear.price}")
            Spacer(modifier = Modifier.height(3.dp))
//            OutlinedButton(onClick = {
//                onClick.invoke()
//                itemCount.value += 1
//                editor.putInt("itemCount", itemCount.value)
//                editor.apply()
//            }, ) {
//                Text(text = "Add to Cart", style = TextStyle(fontSize = 12.sp),color = Color.Blue)
//            }
            Spacer(modifier = Modifier.height(7.dp))

//            Text(text = clotheWear.description)
        }
    }



}
