package com.mhmdawad.testingplayground

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mhmdawad.testingplayground.ui.theme.JetpackComposePlaygroundTheme
import kotlin.math.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JetpackComposePlaygroundTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = getString(R.string.app_name))
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    onBackPressed()
                                }) {
                                    Icon(Icons.Filled.ArrowBack, "menu")
                                }
                            }
                        )
                    },
                    content = {
                        var percent by remember {
                            mutableStateOf(0f)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .border(1.dp, Color.Green, RoundedCornerShape(10.dp))
                                    .padding(10.dp),
                            ) {
                                MusicKnob {
                                    percent = it
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                VolumeBar(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(70.dp),
                                    barCount = 10,
                                    activeBars = (10 * percent).roundToInt()
                                )
                            }
                        }
                    })
            }

        }
    }

    @Composable
    fun VolumeBar(
        modifier: Modifier,
        barCount: Int = 0,
        activeBars: Int = 0,
    ) {

        BoxWithConstraints(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            val barWidth = remember {
                constraints.maxWidth / (2f * barCount)
            }
            Canvas(
                modifier = modifier
            ) {
                for (i in 0 until barCount) {
                    drawRoundRect(
                        color = if (i in 0..activeBars) Color.Green else Color.DarkGray,
                        topLeft = Offset(i * barWidth * 2f + barWidth / 2f, 0f),
                        size = Size(barWidth, constraints.maxHeight.toFloat()),
                        cornerRadius = CornerRadius(10f)
                    )
                }
            }
        }
    }


    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun MusicKnob(
        limitingAngle: Float = 25f,
        onValueChange: (Float) -> Unit
    ) {
        var rotation by remember {
            mutableStateOf(limitingAngle)
        }
        var touchX by remember {
            mutableStateOf(0f)
        }
        var touchY by remember {
            mutableStateOf(0f)
        }
        var centerX by remember {
            mutableStateOf(0f)
        }
        var centerY by remember {
            mutableStateOf(0f)
        }

        Image(
            painter = painterResource(id = R.drawable.music_knob),
            contentDescription = "Music Knob",
            modifier = Modifier
                .size(100.dp)
                .fillMaxSize()
                .onGloballyPositioned {
                    val windowBounce = it.boundsInWindow()
                    centerX = windowBounce.size.width / 2f
                    centerY = windowBounce.size.height / 2f
                }
                .pointerInteropFilter { event ->
                    touchX = event.x
                    touchY = event.y
                    val angle = -atan2(centerX - touchX, centerY - touchY) * (180 / PI).toFloat()

                    when (event.action) {
                        MotionEvent.ACTION_DOWN,
                        MotionEvent.ACTION_MOVE -> {
                            if (angle !in -limitingAngle..limitingAngle) {
                                val fixedAngle = if (angle in -180f..-limitingAngle) {
                                    360f + angle
                                } else {
                                    angle
                                }
                                rotation = fixedAngle
                                val percent =
                                    (fixedAngle - limitingAngle) / (360f - 2 * limitingAngle)
                                onValueChange(percent)
                                true
                            } else false
                        }
                        else -> false
                    }
                }
                .rotate(rotation)
        )

    }
}