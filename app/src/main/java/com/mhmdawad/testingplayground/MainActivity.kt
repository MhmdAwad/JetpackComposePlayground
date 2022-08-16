package com.mhmdawad.testingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            var textFieldValue by remember {
                mutableStateOf("")
            }
            Scaffold(
                scaffoldState = scaffoldState,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = textFieldValue,
                        label = {
                            Text(text = "Enter your name!")
                        },
                        onValueChange = {
                            textFieldValue = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.
                                    showSnackbar("Hello $textFieldValue")
                                }
                            }) {
                            Text(text = "Click Me!")
                        }
                    }

                }
            }
        }
    }
}

