package com.mhmdawad.testingplayground

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    radius: Dp = 50.dp,
    color: Color = Color.Blue,
    strokeWidth: Dp = 6.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    val curPercentage = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = percentage) {
        curPercentage.animateTo(
            targetValue = percentage,
            animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay,
            )
        )
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(
            modifier = Modifier.size(radius * 2f)
        ) {
            drawArc(
                color = color,
                startAngle = -90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(
                    strokeWidth.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }

        Text(
            (curPercentage.value * number).toInt().toString(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}