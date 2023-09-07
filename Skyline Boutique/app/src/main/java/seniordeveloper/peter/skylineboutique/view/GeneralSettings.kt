package seniordeveloper.peter.skylineboutique.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun GeneralSettings(navController:NavHostController){
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
        NavigationBar {
            Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Theme")
                Spacer(Modifier.width(5.dp))
                Switch(checked = false, onCheckedChange = {},
                    colors = SwitchDefaults.colors(Color.Green,Color.Green,1.0F,Color.Green,Color.Gray,0.0F,Color.Gray),
                    enabled = true)
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettings(){
    GeneralSettings(navController = rememberNavController())
}