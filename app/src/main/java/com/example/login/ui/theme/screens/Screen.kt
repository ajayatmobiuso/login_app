package com.example.login.ui.theme.screens

sealed class Screen(
    val route: String
) {

    object  Welcome : Screen("welcome")
    object  Login : Screen("login")
    object  Registration : Screen("registration")
    object  Home : Screen("home")

}