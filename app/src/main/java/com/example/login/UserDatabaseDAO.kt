package com.example.login

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDatabaseDAO {
    @Insert
    fun insert(user:User)

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<User>>
}