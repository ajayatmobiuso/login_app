package com.example.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.screens.UserList
import com.example.login.utils.Screen

@Composable
fun Navigation(userViewModel: UserViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegistrationScreen(navController = navController, context = LocalContext.current)
        }
        composable(route = Screen.UserScreen.route){
            UserList(userViewModel = userViewModel, navController = navController)
        }
    }
}