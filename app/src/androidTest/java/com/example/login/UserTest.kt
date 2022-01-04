package com.example.login

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.login.data.local.UserDatabase
import com.example.login.data.local.UserDAO
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserTest {

    private lateinit var userDAO: UserDAO
    private lateinit var db: UserDatabase

    @Before
    fun createDb() {
        val context =               InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        userDAO = db.userDao()
    }



    @Test
    @Throws(Exception::class)
    fun insertAndGetTodo() = runBlocking {
//        val todoItem = com.example.login.data.model.User(userId = 1, firstName = "Dummy Item", lastName = "item", contactNumber = "1234")
//        userDatabaseDAO.insert(todoItem)
//        val oneItem = userDatabaseDAO.getById(1)
//        assertEquals(oneItem?.itemId, 1)
    }
}