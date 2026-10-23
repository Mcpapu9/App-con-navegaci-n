package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
                    color = Color(0xFFF8F9FA)
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

// PANTALLA PRINCIPAL
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
        Text(
            text = "Mi Papelería",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1565C0)
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Bienvenido a nuestra tienda",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onVerCatalogo,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Ver Catálogo", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// PANTALLA DEL CATÁLOGO
@Composable
fun CatalogoProductos(
    onRegresar: () -> Unit
) {
    val productos = listOf(
        Producto("Lápiz", 8.00, R.drawable.lapiz),
        Producto("Libreta", 45.00, R.drawable.libreta),
        Producto("Mochila", 350.00, R.drawable.mochila),
        Producto("Pluma", 12.50, R.drawable.pluma),
        Producto("Borrador", 5.00, R.drawable.borrador),
        Producto("Crayolas", 42.70, R.drawable.crayolas),
        Producto("Juego de Geometría", 95.00, R.drawable.juego),
        Producto("Goma", 2.50, R.drawable.goma),
        Producto("Resistol 850", 45.00, R.drawable.resistol),
        Producto("Marca Textos", 15.00, R.drawable.marcatextos)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Catálogo de Productos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1565C0)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productos) { producto ->
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
                            // Aquí cargamos la imagen directamente desde drawable
                            Image(
                                painter = painterResource(id = producto.imagenResId),
                                contentDescription = producto.nombre,
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Column {
                                Text(
                                    text = producto.nombre,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF212529)
                                )
                                Text(
                                    text = "Papelería general",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                        }

                        Text(
                            text = "$${String.format("%.2f", producto.precio)}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onRegresar,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Regresar al inicio", fontWeight = FontWeight.Bold)
        }
    }
}

data class Producto(
    val nombre: String,
    val precio: Double,
    val imagenResId: Int
)