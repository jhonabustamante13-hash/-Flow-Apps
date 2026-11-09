package com.eventflow.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventFlowApp()
        }
    }
}

@Composable
fun EventFlowApp() {
    var selected by remember { mutableIntStateOf(0) }

    val background = Color(0xFF080D19)
    val glass = Color(0xFF18243A)
    val accent = Color(0xFF79C7FF)

    MaterialTheme(colorScheme = darkColorScheme()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
                .padding(20.dp)
        ) {
            Text(
                "EVENTFLOW",
                color = accent,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            Text(
                "Organiza tus momentos.",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = glass)
            ) {
                Column(Modifier.padding(22.dp)) {
                    Text("TU ESPACIO DE EVENTOS", color = accent)
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Todo bajo control.",
                        color = Color.White,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Planea, organiza y disfruta.",
                        color = Color.LightGray
                    )
                }
            }

            Spacer(Modifier.height(22.dp))

            Text("Tus herramientas", color = Color.White, fontSize = 20.sp)

            Spacer(Modifier.height(12.dp))

            val sections = listOf(
                "📅  Mis eventos",
                "👥  Invitados",
                "💰  Presupuesto",
                "🛍️  Compras",
                "✓  Preparativos"
            )

            sections.forEachIndexed { index, name ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selected == index) {
                            Color(0xFF25466A)
                        } else glass
                    ),
                    onClick = { selected = index }
                ) {
                    Text(
                        name,
                        color = Color.White,
                        modifier = Modifier.padding(18.dp),
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                "EVENTFLOW • LIQUID GLASS",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
