package com.example.login.database

import com.example.login.repository.UserRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.login.database.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository = UserRepository(application = application)
   

    fun fetchUsers(): LiveData<List<User>> {
        return userRepository.readAllUsers
    }

    fun insertCustomer(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user = user)
        }

    }


}