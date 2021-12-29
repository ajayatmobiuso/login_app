package com.example.login

import UserRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.login.database.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository = UserRepository(application = application)
    private val usersList: MutableLiveData<ArrayList<User>> by lazy {
        MutableLiveData<ArrayList<User>>()
    }

    fun fetchUsers(): LiveData<List<User>> {
        return userRepository.readAllUsers
    }

    fun insertCustomer(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user = user)
        }

    }


}