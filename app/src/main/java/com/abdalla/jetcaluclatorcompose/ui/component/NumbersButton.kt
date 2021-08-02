package com.abdalla.jetcaluclatorcompose.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NumbersButton(num: String, onClick: () -> Unit, modifier: Modifier,color: Color= Color(0xFF313131)) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor =color),
        shape = RoundedCornerShape(50),
        modifier = modifier
    ) {
        Text(text = num, fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}