package com.example.login.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "users"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
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