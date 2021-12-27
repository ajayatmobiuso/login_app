package com.example.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room

lateinit var userDatabaseDAO: UserDatabaseDAO

@Composable
fun RegistrationScreen(context:Context,navController: NavController) {
    val userDb : UserDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java)
        .allowMainThreadQueries()
        .build()
    Scaffold {
        Column(
            Modifier
                .verticalScroll(state = ScrollState(initial = 0))
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Title(text = stringResource(id = R.string.registration), padding = 50)
            NameField(label = stringResource(id = R.string.fullName))
            NameField(label = stringResource(id = R.string.userName))
            PasswordField(pass = stringResource(id = R.string.password))
            PasswordField(pass = stringResource(id = R.string.confirmPassword))
            RegisterButton(stringResource(id = R.string.register),) {
                userDatabaseDAO = userDb.userDao()
                val todoItem = User(
                    userId = 12,
                    userFullName = "Dummy Item",
                    userName = "item",
                    password = "1234"
                )
                userDatabaseDAO.insert(todoItem)

                val by = userDatabaseDAO.getAll().value?.get(0)
                println("user registered successfully")
                println(todoItem)
                println(by)
            }
            Text("Login", modifier = Modifier.clickable {
                println("Clicked")
                navController.navigate("loginScreen")
            })
        }
    }
}