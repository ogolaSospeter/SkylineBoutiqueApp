package seniordeveloper.peter.skylineboutique.models.constants

import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import seniordeveloper.peter.skylineboutique.R

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
            fontWeight = FontWeight.Medium,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontStyle = FontStyle(5)
        ),
        color = colorResource(id = R.color.statusBar)
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

@Composable
fun ActionButton(name:Int,route:String,wid:Int, navController: NavHostController){
    OutlinedButton(
        onClick = { navController.navigate(route)},
        modifier = Modifier.width(wid.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        androidx.compose.material3.Text(
            text = AnnotatedString(stringResource(name)),
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun Space(spaced:Int){
    Spacer(modifier = Modifier.height(spaced.dp))

}

@Composable
fun AlertBox(title:String, message: String, color: Color,icon: ImageVector, dialogue:Boolean, accept:String){
    AlertDialog(
        onDismissRequest = {  !dialogue },
        confirmButton = {
            OutlinedButton(onClick = {

                !dialogue }) {
                androidx.compose.material3.Text(text = accept)
            }
        },
        title = { androidx.compose.material3.Text(text = title) },
        text = { androidx.compose.material3.Text(message) },
        icon = { Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(40.dp)) }
    )
}

@Composable
fun matchEmail(mail:String):Boolean{
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    return mail.trim().matches(emailPattern.toRegex())
}




