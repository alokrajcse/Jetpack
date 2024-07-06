package com.sit.lab10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sit.lab10.ui.theme.LAB10Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB10Theme {
                var text by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("This is a text field") }
                    )
                    StyledTextField()
                    SimpleOutlinedTextFieldSample()
                    BrushTextField()
                    PasswordTextField()
                    BottomSheetExample()
                }
            }
        }
    }
}

@Composable
fun StyledTextField() {
    var value by remember { mutableStateOf("Hello\nWorld\nInvisible") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Styled text field") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun BrushTextField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Yellow, Color.Magenta)
        )
    }
    TextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(brush = brush)
    )
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetExample(modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { contentPadding ->
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {

                Column(modifier = Modifier.height(300.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }) {
                        Text("Hide bottom sheet")
                    }
                    
                    Text(text = "I am inside Bottom Sheet")
                }
            }
        }
    }
}
