import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController, sharedPreferences: SharedPreferences) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var nationalCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = birthDate,
            onValueChange = { birthDate = it },
            label = { Text("Birth Date") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nationalCode,
            onValueChange = { nationalCode = it },
            label = { Text("National Code") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                with(sharedPreferences.edit()) {
                    putString("firstName", firstName)
                    putString("lastName", lastName)
                    putString("birthDate", birthDate)
                    putString("nationalCode", nationalCode)
                    putBoolean("isLoggedIn", true)
                    apply()
                }

                navController.navigate("profile_screen")
            }
        ) {
            Icon(Icons.Default.Send, contentDescription = "Submit")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Submit")
        }
    }
}
