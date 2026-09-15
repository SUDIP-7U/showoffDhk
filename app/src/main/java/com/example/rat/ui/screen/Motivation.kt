package com.example.rat.ui.screen

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlin.random.Random


val LighterPinkButton = Color(0xFFE00A54)
private const val SPIN_COST = 10
private const val JACKPOT_BONUS = 200
private val SYMBOLS = listOf("🍒", "7️⃣", "🍋", "⭐")
@Preview(showBackground = true, heightDp = 200, widthDp = 300)
@Composable
fun Demo() {
    var count by remember { mutableIntStateOf(0) }


    // Core state, held with remember
    var balance by remember { mutableIntStateOf(1000) }
    var result by remember { mutableStateOf("Press Spin to play!") }
    var isSpinning by remember { mutableStateOf(false) }
// Animate balance changes smoothly, both up and down
    val animatedBalance by animateIntAsState(
        targetValue = balance,
        animationSpec = tween(durationMillis = 600),
        label = "balanceAnimation"
    )
    Column(
        Modifier.fillMaxSize().background(Color.White).padding(12.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        Text(
            text = "$animatedBalance coins",
            color = Color(0xFF12AB18),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))



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


            onClick = {

                if (!isSpinning) {

                    if (balance < SPIN_COST) {

                        result = "Not enough coins to spin!"
                        return@OutlinedButton
                    }

                    // Deduct spin cost — animates the decrease
                    balance -= SPIN_COST

                    // Determine random outcome
                    val outcome = SYMBOLS[Random.nextDouble().let {
                        Random.nextInt(SYMBOLS.size)
                    }]

                    result = if (outcome == "7️⃣") {
                        balance += JACKPOT_BONUS // animates the increase
                        "$outcome JACKPOT! You won $JACKPOT_BONUS coins! $outcome"
                    } else {
                        "You spun $outcome. Try again!"
                    }
                }
            },
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Blue),


            colors = ButtonDefaults.buttonColors(
                containerColor = LighterPinkButton,
                contentColor = Color(0xFFEEE7E9) // deep pink/maroon text for contrast
            ),


        ) { Text("Outlined Button") }


    }
}