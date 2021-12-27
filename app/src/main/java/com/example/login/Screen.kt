package com.example.login

sealed class Screen(
    val route: String
) {

    object  SplashScreen : Screen("splashScreen")
    object  LoginScreen : Screen("loginScreen")
    object  RegisterScreen : Screen("registerScreen")

}