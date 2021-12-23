package com.example.login

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDatabaseDAO
    companion object {
        var dbInstance: UserDatabase? = null
        private var INSTANCE: UserDatabaseDAO? = null
        fun getInstance(context: Context): UserDatabase {
            val tempInstance = dbInstance
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java,"users").build()
                dbInstance = instance
                return instance
            }

        }
//        fun getInstance(context: Context): UserDatabaseDAO? {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        UserDatabase::class.java,
//                        "users"
//                    ).fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
    }
}