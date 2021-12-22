package com.example.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "user_fullName")
    val userFullName: String,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "user_password")
    var password: String,

)
