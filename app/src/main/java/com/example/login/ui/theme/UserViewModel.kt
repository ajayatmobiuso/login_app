package com.example.login.ui.theme
import com.example.login.data.model.User
import com.example.login.data.repository.UserRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
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