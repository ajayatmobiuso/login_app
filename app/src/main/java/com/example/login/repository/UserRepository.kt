package com.example.login.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.login.database.User
import com.example.login.database.UserDatabase
import com.example.login.database.UserDatabaseDAO

class UserRepository(application: Application) {

    private var userDatabaseDAO: UserDatabaseDAO


    init {
        val db = UserDatabase.getInstance(application)
        userDatabaseDAO = db.userDao()
    }

    val readAllUsers: LiveData<List<User>> = userDatabaseDAO.getAll()

    suspend fun addUser(user: User) {
        userDatabaseDAO.insert(user = user)
    }

}