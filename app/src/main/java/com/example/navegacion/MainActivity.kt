package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF0F4F8) // Fondo limpio y suave
                ) {
                    NavegacionApp()
                }
            }
        }
    }
}

// CONTROL DE NAVEGACIÓN
@Composable
fun NavegacionApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") {
            PantallaPrincipal(
                onVerCatalogo = {
                    navController.navigate("catalogo")
                }
            )
        }

        composable("catalogo") {
            CatalogoProductos(
                onRegresar = {
                    navController.popBackStack()
                }
            )
        }
    }
}

// PANTALLA PRINCIPAL - FUMO SHOP
@Composable
fun PantallaPrincipal(
    onVerCatalogo: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Insignia visual estilo peluche
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(45.dp))
                .background(Color(0xFF64B5F6)), // Azul suave
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "ᗜˬᗜ",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Fumo Sanctuary",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Coleccionables y peluches directos de Gensokyo",
            fontSize = 14.sp,
            color = Color(0xFF546E7A)
        )
        Spacer(modifier = Modifier.height(40.dp))

        // Botón para ver el catálogo
        Button(
            onClick = onVerCatalogo,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Ver Colección Fumo", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

// PANTALLA DEL CATÁLOGO - LISTA VERTICAL (LazyColumn)
@Composable
fun CatalogoProductos(
    onRegresar: () -> Unit
) {
    val fumos = listOf(
        FumoItem("Cirno Fumo", "La más ⑨ de todas", 750.00, R.drawable.cirno),
        FumoItem("Reimu Hakurei Fumo", "C gran sacerdotiza", 790.00, R.drawable.reimu),
        FumoItem("Marisa Kirisame Fumo", "Robando cosas de valor", 790.00, R.drawable.marisa),
        FumoItem("Youmu Konpaku Fumo", "Mitad jardinera, mitad fumo", 820.00, R.drawable.youmu),
        FumoItem("Yuyuko Saigyouji Fumo", "Comiendo todo en el nether", 850.00, R.drawable.yuyuko),
        FumoItem("Sakuya Izayoi Fumo", "Deteniendo el tiempo con estilo", 820.00, R.drawable.sakuya),
        FumoItem("Koishi Komeiji Fumo", "Subconsciente y feliz", 850.00, R.drawable.koishi),
        FumoItem("Fumo Llavero", "Para llevarla a todos lados", 250.00, R.drawable.fumo_llavero),
        FumoItem("Remilia Scarlet Fumo", "La ama de la mansión carmesí", 890.00, R.drawable.remilia),
        FumoItem("Flandre Scarlet Fumo", "Poder destructivo en peluche", 920.00, R.drawable.flandre)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Spacer para que no quede pegado hasta arriba
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "CATÁLOGO DE FUMOS",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2),
            modifier = Modifier.padding(top = 12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Columnas con imagen, nombre, descripción y precio
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(fumos) { fumo ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            // Aqui se pinta la imagen
                            Image(
                                painter = painterResource(id = fumo.imagenResId),
                                contentDescription = fumo.nombre,
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Column {
                                // Nombre del peluche
                                Text(
                                    text = fumo.nombre,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF263238)
                                )
                                // Descripción del peluche
                                Text(
                                    text = fumo.descripcion,
                                    fontSize = 12.sp,
                                    color = Color(0xFF78909C)
                                )
                            }
                        }
                        // Texto del precio
                        Text(
                            text = "$${String.format("%.2f", fumo.precio)}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Boton para regresar a la pantalla principal
        Button(
            onClick = onRegresar,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF546E7A)),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Regresar al Inicio", fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

// Modelo de datos para los Fumos
data class FumoItem(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagenResId: Int //Se usa int porque Android Studio reconoce las imagenes por id int y no su nombre
)