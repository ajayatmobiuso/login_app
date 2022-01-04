
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.ui.theme.screens.Screen
import kotlinx.coroutines.delay

@Composable
fun Welcome(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }


    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 900,
                easing = {
                    OvershootInterpolator(6f).getInterpolation(it)
                })
        )
        delay(2000L)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Welcome.route) {
                inclusive = true
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .scale(scale = scale.value)
                .fillMaxWidth(),
        )
    }
}