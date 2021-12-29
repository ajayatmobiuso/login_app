package com.example.login.utils

sealed class Screen(
    val route: String
) {

    object  WelcomeScreen : Screen("splashScreen")
    object  LoginScreen : Screen("loginScreen")
    object  RegisterScreen : Screen("registerScreen")
    object  UserScreen : Screen("userScreen")

}