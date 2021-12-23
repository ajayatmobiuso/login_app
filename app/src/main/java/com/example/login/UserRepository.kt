import androidx.lifecycle.LiveData
import com.example.login.User
import com.example.login.UserDatabaseDAO

class UserRepository(private val userDatabaseDAO: UserDatabaseDAO) {
    suspend fun addTodo(todoItem: User) {
        userDatabaseDAO.insert(todoItem)
    }

}