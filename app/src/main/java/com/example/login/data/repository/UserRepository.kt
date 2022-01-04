package com.example.login.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.login.data.model.User
import com.example.login.data.local.UserDAO
import com.example.login.data.local.UserDatabase

class UserRepository(application: Application) {

    private var userDatabaseDAO: UserDAO


    init {
        val db = UserDatabase.getInstance(application)
        userDatabaseDAO = db.userDao()
    }

    val readAllUsers: LiveData<List<User>> = userDatabaseDAO.getAll()

    suspend fun addUser(user: User) {
        userDatabaseDAO.insert(user = user)
    }

}