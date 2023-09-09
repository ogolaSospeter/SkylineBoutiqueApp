package seniordeveloper.peter.skylineboutique.closetModel

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import seniordeveloper.peter.skylineboutique.ui.theme.SkylineBoutiqueTheme

class ViewClothes: ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkylineBoutiqueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(backgroundColor = Color.Green,
                                title = {
                                    Text(
                                        text = "GFG",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                })
                        }) {
                        ReadDataFromDatabase(LocalContext.current)
                    }
                }
            }
        }
    }
}

@Composable
fun ReadDataFromDatabase(context: Context) {
    // on below line we are creating and initializing our array list
    lateinit var clothesList: List<ClosetData>
    clothesList = ArrayList<ClosetData>()

    val dbHandler: ClosetDBHandler = ClosetDBHandler(context);
    clothesList = dbHandler.getClosetData()!!
    LazyColumn {
        itemsIndexed(clothesList) { index, item ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = clothesList[index].title,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Clothe Category : " + clothesList[index].category,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Clothe Price : " + clothesList[index].price,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Course Description : " + clothesList[index].description,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
AsyncImage(
    model = clothesList[index].image,
    contentDescription = clothesList[index].title,
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .size(120.dp)
        .clip(MaterialTheme.shapes.medium)
    )                }

            }
        }
    }
}