package com.example.usersignup.ui


import ProfileScreen
import SignUpScreen
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.usersignup.ui.theme.UserSignUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserSignUpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
                    val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

                    NavHost(
                        navController = navController,
                        startDestination = if (isLoggedIn) "profile_screen" else "signup_screen"
                    ) {
                        composable("signup_screen") {
                            SignUpScreen(navController,sharedPreferences)
                        }
                        composable("profile_screen") {
                            ProfileScreen(navController,sharedPreferences)
                        }
                    }
                }
            }
        }
    }
}
