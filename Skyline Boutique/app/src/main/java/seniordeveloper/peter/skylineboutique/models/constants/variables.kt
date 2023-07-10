package seniordeveloper.peter.skylineboutique.models.constants

import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VariableData(){
    Divider(
        modifier = Modifier
            .width(400.dp)
            .padding(end = 10.dp), color = Color.Gray
    )
}

@Composable
fun DividerDefaults() {
    Divider(
        modifier = Modifier
            .width(400.dp)
            .padding(end = 10.dp), color = Color.LightGray
    )
}

@Composable
fun ToastMessage(message:String){
    val context  = LocalContext.current
    Toast.makeText(
        context, message,
        Toast.LENGTH_LONG
    ).show()
}
@Composable
fun GlobalWidgets (text:String){
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontStyle = FontStyle(5)
        )
    )
}

@Composable
fun MyComposable(context: Context) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val editor = sharedPreferences.edit()
    editor.putString("key", "value")
    editor.apply()

    val value = sharedPreferences.getString("key", "default value")

    // Rest of your composable code...
}




