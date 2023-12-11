import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController, sharedPreferences: SharedPreferences) {

    var firstName by rememberSaveable { mutableStateOf(sharedPreferences.getString("firstName", "Unknown") ?: "Unknown") }
    var lastName by rememberSaveable { mutableStateOf(sharedPreferences.getString("lastName", "Unknown") ?: "Unknown") }
    var birthDate by rememberSaveable { mutableStateOf(sharedPreferences.getString("birthDate", "Unknown") ?: "Unknown") }
    var nationalCode by rememberSaveable { mutableStateOf(sharedPreferences.getString("nationalCode", "Unknown") ?: "Unknown") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text("Profile Information")
        Spacer(modifier = Modifier.height(16.dp))
        Text("First Name: $firstName")
        Text("Last Name: $lastName")
        Text("Birth Date: $birthDate")
        Text("National Code: $nationalCode")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Navigate back to the signup screen
                navController.navigate("signup_screen") {
                    popUpTo("signup_screen") { inclusive = true }
                }
            }
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Back")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                with(sharedPreferences.edit()) {
                    putBoolean("isLoggedIn", false)
                    apply()
                }

                navController.navigate("signup_screen") {
                    popUpTo("signup_screen") { inclusive = true }
                }
            }
        ) {
            Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Logout")
        }
    }
}