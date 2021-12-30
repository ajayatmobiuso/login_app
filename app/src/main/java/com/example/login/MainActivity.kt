package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.login.database.UserViewModel
import com.example.login.ui.theme.LoginTheme

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
