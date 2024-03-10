package com.example.referencia

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.referencia.ui.theme.ReferenciaTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReferenciaTheme {
                // Defina o plano de fundo com gradiente na atividade
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "splash_screen"
                    ) {
                        composable("splash_screen") {
                            Splashscreen(navController = navController)
                        }
                        composable("home_screen") {
                            HomeApp()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Splashscreen(navController: NavController) {
    Box( modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF01224D), // Cor inicial
                    Color(0xFF012758),
                    Color(0xFF02316F),
                    Color(0xFF012758),
                    Color(0xFF01224D),
                    // Cor final
                )
            )
        )){
        Row(modifier = Modifier.align(Alignment.TopEnd)) {
            Column {
                Box(
                    modifier = Modifier
                        .offset(x = 65.dp, y = -70.dp)
                        .rotate(26f)
                        .size(360.dp, 350.dp)
                        .background(Color(0xFF16E078)),
                )

            }

        }
        Row(modifier = Modifier.align(Alignment.Center)) {
            Column {
                Row {
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = "App name",
                        fontSize = 24.sp,
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.Bold,
                    )
                }
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    LogoApp(circleSize = 50.dp, squareSize = 10.dp)

                }
            }
        }
        Row(modifier = Modifier.align(Alignment.BottomStart)) {
            Column {
                Box(
                    modifier = Modifier
                        .offset(x = -40.dp, y = 130.dp)
                        .rotate(44f)
                        .size(320.dp, 320.dp)
                        .background(Color(0xFF052B87)),
                )

            }

        }

    }
    LaunchedEffect(true) {
        delay(2000) // Ajuste conforme necessário
        navController.navigate("home_screen")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewlog() {
//    Splashscreen()


}


@Composable
fun LogoApp(circleSize: Dp, squareSize: Dp) {
    Box(
        modifier = Modifier
            .size(circleSize)
            .shadow(10.dp, shape = MaterialTheme.shapes.extraLarge)
            .clip(CircleShape)
            .border(2.dp, Color.White, shape = CircleShape)
            .background(Color(0xFF01224D)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF01224D))
        ) {
            // Conteúdo da coluna (se houver algum)
        }
        Row(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .rotate(45f)
                        .size(squareSize)
                        .background(Color(0xFF052B87)),
                )
            }
            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .rotate(45f)
                        .size(squareSize)
                        .background(Color(0xFFFFFFFF)),
                )
            }
            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .rotate(45f)
                        .size(squareSize)
                        .background(Color(0xFF16E078)),
                )
            }
        }
    }
}

