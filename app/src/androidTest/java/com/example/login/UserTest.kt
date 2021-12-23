package com.example.login

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserTest {

    private lateinit var userDatabaseDAO: UserDatabaseDAO
    private lateinit var db: UserDatabase

    @Before
    fun createDb() {
        val context =               InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        userDatabaseDAO = db.userDao()
    }



    @Test
    @Throws(Exception::class)
    fun insertAndGetTodo() = runBlocking {
        val todoItem = User(userId = 1, userFullName = "Dummy Item", userName = "item", password = "1234")
        userDatabaseDAO.insert(todoItem)
//        val oneItem = userDatabaseDAO.getById(1)
//        assertEquals(oneItem?.itemId, 1)
    }
}