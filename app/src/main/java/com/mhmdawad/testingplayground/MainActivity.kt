package com.mhmdawad.testingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdawad.testingplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val fontFamily = FontFamily(
                Font(R.font.merriweather_black, FontWeight.Black),
                Font(R.font.merriweather_bold, FontWeight.Bold),
                Font(R.font.merriweather_light, FontWeight.Light),
                Font(R.font.merriweather_regular, FontWeight.Normal),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
                    .padding(10.dp),
                contentAlignment = Alignment.TopCenter
            ) {

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                color = Color.Red,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                fontSize = 45.sp
                            )
                        ) {
                            append("M")
                        }
                        append("ohammed ")
                        withStyle(
                            SpanStyle(
                                color = Color.Red,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                fontSize = 45.sp
                            )
                        ) {
                            append("A")
                        }
                        append("wad")
                    },
                    color = Color.White,
                    fontSize = 40.sp,
                    fontFamily = fontFamily
                )
            }

        }
    }
}
