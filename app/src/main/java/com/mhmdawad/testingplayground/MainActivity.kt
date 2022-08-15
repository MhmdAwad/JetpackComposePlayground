package com.mhmdawad.testingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdawad.testingplayground.ui.theme.JetpackComposePlaygroundTheme
import com.mhmdawad.testingplayground.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.dog)
            val title = "Little Dog"
            val desc = "Dog Image"
            ImageCard(painter = painter, contentDescription = desc, title = title)

        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String
) {
    Card(
        modifier = Modifier.padding(10.dp).height(200.dp).fillMaxWidth(0.5f),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(painter = painter, contentDescription = contentDescription, contentScale = ContentScale.Crop)
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    startY = 300f
                )
            ))
        Box(modifier = Modifier.padding(10.dp), contentAlignment = Alignment.BottomStart) {
            Text(text = title, style = TextStyle(color = Color.White, fontSize = 14.sp))
        }
    }
}
