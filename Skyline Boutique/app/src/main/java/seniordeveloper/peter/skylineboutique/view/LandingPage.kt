package seniordeveloper.peter.skylineboutique.view

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylineboutique.R
import seniordeveloper.peter.skylineboutique.models.constants.Space

//The boutique landing page


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingPage(navController:NavHostController) {
    LandPagesAnimated(navController = navController)
//    LogoLand(navController = navController)
    }



@Composable
fun LogoLand(navController: NavHostController){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.statusBar))) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Space(spaced = 5)
        Text(
            text = "Skyline Boutique",
            fontSize = 22.sp,
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily.SansSerif,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
//        OutlinedButton(
//            onClick = { navController.navigate(Screen.Login.route) },
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Text(
//                "Get Started",
//                fontSize = 18.sp,
//                color = colorResource(id = R.color.statusBar)
//            )
//        }
    }
}
@Composable
fun LogoImage(navController: NavHostController){
    Column (verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.l2),
                contentDescription = "progress",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Fit
            )
        }
        Space(spaced = 5)

        Text(
            text = "Welcome to Skyline Boutique . This is your one stop shop for all your fashion needs.\n" +
                    "We have a wide range of products ranging from clothes to shoes and bags. \n" +
                    "Welcome and purchase with us.",

            fontSize = 14.sp,
            color = colorResource(id = R.color.statusBar),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(start = 20.dp, end = 20.dp),
            fontFamily = FontFamily.SansSerif,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
        Space(spaced = 70)
//        OutlinedButton(
//            onClick = { navController.navigate(Screen.Login.route) },
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Text(
//                "Get Started",
//                fontSize = 22.sp,
//                color = colorResource(id = R.color.statusBar)
//            )
//        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandPagesAnimated(navController: NavHostController) {
    val pageCount = 3
    val pagerState = rememberPagerState(pageCount = {pageCount})
    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(
        state = pagerState
    ) { page ->
        val currentPage = pagerState.currentPage
        if (page == 0) {
            LogoLand(navController = navController)
        }
        else if (page == 1) {
            LogoImage(navController = navController)
        }
        else{
            UserLoginPage(context = LocalContext.current,navController = navController)
        }

        // Automatically transition to the next page after 30 seconds
        if (currentPage == page) {
            coroutineScope.launch(context = coroutineScope.coroutineContext, block = {
                delay(3500) // 30 seconds
                pagerState.animateScrollToPage(page + 1)
            }, start = CoroutineStart.DEFAULT
            )
        }
    }

    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) {
                    if (iteration == 0) colorResource(id = R.color.white)
                    else
                    colorResource(id = R.color.statusBar)
                }
                else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(20.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewLandingPage() {
    LandingPage(navController = rememberNavController())
}