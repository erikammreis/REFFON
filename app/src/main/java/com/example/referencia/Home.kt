package com.example.referencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.referencia.ui.theme.ReferenciaTheme
import org.w3c.dom.Text

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReferenciaTheme {
                // Defina o plano de fundo com gradiente na atividade
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                )
                {
                    HomeApp()
                }
            }
        }
    }
}

//sera usado na versão final
@Composable
fun NotificationIcon() {
    Box(modifier = Modifier.padding(end = 20.dp, top = 30.dp)) {
        Image(
            painter = painterResource(id = R.drawable.baseline_insert_comment_24), // Substitua R.drawable.ic_custom_vector pelo seu recurso de vetor
            contentDescription = "Ícone vetorizado",
            modifier = Modifier
                .size(48.dp) // Tamanho do ícone
                .padding(8.dp)
        )
    }
}

@Composable
fun HomeApp() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 30.dp)
                ) {

                    LogoApp(circleSize = 50.dp, squareSize = 10.dp)
                }
                //        Row(
                //            modifier = Modifier
                //                .align(Alignment.TopEnd)
                //        ) {
                //            NotificationIcon()
                //        }
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                ) {
                    PesquisaBar()
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(350.dp)
                        .height(200.dp)
                        .align(Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier
                            .width(350.dp)
                            .height(100.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconePesquisaRapida("Pintor", R.drawable.pintor)
                        IconePesquisaRapida(
                            "Encanador",
                            R.drawable.captura_de_tela_2024_03_10_125658
                        )
                    }
                    Row(
                        modifier = Modifier
                            .width(350.dp)
                            .height(100.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconePesquisaRapida("Eletricista", R.drawable.eletricista)
                        IconePesquisaRapida("Faxineira", R.drawable.faxineira)
                    }
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
            ) {
                ProfissionaisDestaque()
                ProfissionaisDestaque()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
//                    .align(Alignment.CenterHorizontally) // Ajuste para alinhar ao final da tela
                    .background(Color(0xFFA2FECF))
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) // Ajuste a margem inferior conforme necessário
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )

                    Text(
                        text = "Inicio",
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
@Composable
fun ProfissionaisDestaque(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        , verticalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Profissionais Destaque",
        color = Color(0xFF2B2B2B),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium, // Adicionando negrito
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(5.dp)
        )
        Row(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(307.dp)
            .height(87.dp)
            .align(Alignment.CenterHorizontally)
            .background(Color(0xFF012655))) {
        IconeProfissionalFoto("Nome do profissional","Profissão")
        }
        Row(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(307.dp)
            .height(87.dp)
            .align(Alignment.CenterHorizontally)
            .background(Color(0xFF012655))) {
            IconeProfissionalFoto("Nome do profissional","Profissão")
        }

    }
}

@Composable
fun IconeProfissionalFoto(nomeProfissional: String,profissao: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.CenterStart)
                .padding(start = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(10.dp, shape = MaterialTheme.shapes.extraLarge)
                    .clip(CircleShape)
                    .border(2.dp, Color.Transparent, shape = CircleShape)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF16DF78),
                                Color(0xFF0EAC5B),
                            )
                        )

                    )) {
                Image(
                    painter = painterResource(id = R.drawable.iconeprofissional),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(40.dp)
                        .height(30.dp)
                )

                    }
            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                Column {
                    Text(
                        text = nomeProfissional,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                    )

                    Text(
                        text = profissao,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        modifier = Modifier
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.estrelacheia),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.estrelacheia),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.estrelacheia),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.estrelacheia),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.estrelavazia),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun PesquisaBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(
                text = "Pesquise pelo Serviço que deseja solicitar",
                color = Color(0xFF646464),
                style = androidx.compose.ui.text.TextStyle(fontSize = 10.sp, textAlign = TextAlign.Center),
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 10.dp)
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "icone de busca",
                tint = Color(0xFF16E078)
            )
        },
        modifier = Modifier
            .shadow(10.dp, shape = MaterialTheme.shapes.extraLarge)
            .width(300.dp)
            .height(43.dp)
            .clip(RoundedCornerShape(20.dp))
            .drawBehind {
                drawRect(
                    color = Color.Gray,
                    size = Size(size.width, 50.dp.toPx()),
                    topLeft = Offset(0f, size.height - 20.dp.toPx())
                )
            }
        )
}

@Composable
fun IconePesquisaRapida(texto: String, imageResId: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(150.dp)
            .height(90.dp)
            .background(Color(0xFF9CF1C5))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )

        Text(
            text = texto,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 15.dp, bottom = 7.dp)

        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HomeApp()
}




