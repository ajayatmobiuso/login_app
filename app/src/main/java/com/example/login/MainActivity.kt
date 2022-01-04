package com.example.login

import Navigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.login.ui.theme.LoginTheme
import com.example.login.ui.theme.UserViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                Navigation(userViewModel = userViewModel)
            }
        }
    }
}
