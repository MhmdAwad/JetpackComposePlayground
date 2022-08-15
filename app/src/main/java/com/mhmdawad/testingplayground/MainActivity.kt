package com.mhmdawad.testingplayground

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhmdawad.testingplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth()
                    .height(400.dp)
                    .border(10.dp, Color.Red)
                    .padding(8.dp)
                    .border(10.dp, Color.White)
                    .padding(8.dp)
                    .border(10.dp, Color.Black)
                    .padding(15.dp)
            ) {
                Text(text = "EGYPT", color = Color.White,
                    modifier = Modifier.offset(10.dp, 0.dp))
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(text = "IS")
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(text = "ALWAYS")
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(text = "RIGHT")

            }
        }
    }
}
