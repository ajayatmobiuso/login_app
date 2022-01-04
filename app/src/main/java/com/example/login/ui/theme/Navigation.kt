
import Welcome
import com.example.login.ui.theme.UserViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.Registration

import com.example.login.ui.theme.screens.Login
import com.example.login.ui.theme.screens.Screen
import com.example.login.ui.theme.screens.Home

@Composable
fun Navigation(userViewModel: UserViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(route = Screen.Welcome.route) {
            Welcome(navController = navController)
        }
        composable(route = Screen.Login.route) {
            Login(navController = navController)
        }
        composable(route = Screen.Registration.route) {
            Registration(navController = navController, context = LocalContext.current)
        }
        composable(route = Screen.Home.route){
            Home(userViewModel = userViewModel, navController = navController)
        }
    }
}