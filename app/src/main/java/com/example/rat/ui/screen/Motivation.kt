package com.example.rat.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rat.R

@Preview(showBackground = true, heightDp = 200, widthDp = 300)
@Composable
fun Demo() {
    var count by remember { mutableIntStateOf(0) }

    Column(
        Modifier.fillMaxSize().background(Color.White).padding(12.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Card(
            Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEC407A))
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Balance", style = MaterialTheme.typography.titleMedium, color = Color.White)
                Text("Count: $count", style = MaterialTheme.typography.headlineMedium, color = Color.White)
            }
        }

        Spacer(Modifier.height(16.dp))

        OutlinedButton(
            onClick = { count++ },
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Blue),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
        ) { Text("Outlined") }

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

