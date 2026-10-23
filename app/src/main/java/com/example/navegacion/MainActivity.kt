package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                NavegacionApp()
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

        // Pantalla principal
        composable("inicio") {
            PantallaPrincipal(
                onVerCatalogo = {
                    navController.navigate("catalogo")
                }
            )
        }

        // Pantalla de productos
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
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Mi Papelería",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color=Color.Blue
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Bienvenido a nuestra tienda",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = onVerCatalogo) {
            Text(text = "Ver Catálogo")
        }
    }
}

// PANTALLA DEL CATÁLOGO
@Composable
fun CatalogoProductos(
    onRegresar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Catálogo de productos",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1565C0)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Lápiz",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Precio: $8.00")
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "Libreta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Precio: $45.00")
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "Mochila",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Precio: $350.00")
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = onRegresar
        ) {
            Text("Regresar al inicio")
        }
    }
}