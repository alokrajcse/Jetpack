package com.sit.lab9

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sit.lab9.ui.theme.LAB9Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            LAB9Theme {

//                Column(modifier = Modifier.fillMaxSize()
//                    , verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally) {
//                    Button(onClick = { /*TODO*/ }) {
//
//                        Text(text = "Normal Button")
//
//                    }
//
//                    FilledTonalButton(onClick = { /*TODO*/ }) {
//
//                        Text(text = "Tonal Button")
//
//                    }
//                    OutlinedButton(onClick = { /*TODO*/ }) {
//
//                        Text(text = "Outlined Button")
//
//                    }
//
//                    ElevatedButton(onClick = { /*TODO*/ }) {
//
//                        Text(text = "Elevated Button")
//
//                    }
//                    TextButton(onClick = { /*TODO*/ }) {
//
//                        Text(text = "Text Button")
//
//                    }
//
//                    FloatingActionButton(onClick = { /*TODO*/ }) {
//                        Icon(Icons.Filled.Add,"fab")
//
//
//
//                    }
//
//                    Card(modifier = Modifier.padding(10.dp)) {
//                        Text(text = "This is a Card", Modifier.padding(10.dp))
//                    }
//
//                    Card(colors = CardDefaults.cardColors(containerColor = Color.Red),
//
//                        modifier = Modifier
//                            .padding(10.dp)
//                            .size(width = 200.dp, height = 200.dp)) {
//                        Text(text = "This is filled Card")
//                    }
//
//
//                    OutlinedCard(onClick = { /*TODO*/ },
//                        colors = CardDefaults.cardColors(containerColor = Color.Green),
//                        border = BorderStroke(5.dp, Color.Red),
//                        modifier = Modifier.padding(10.dp)
//                            .size(width = 200.dp, height = 200.dp)) {
//
//                        Text(text = "Outlined Card")
//
//                    }


//                    var sliderPosition by remember { mutableFloatStateOf(0f) }
//                    Column {
//                        Slider(
//                            value = sliderPosition,
//                            onValueChange = { sliderPosition = it }
//                        )
//                        Text(text = sliderPosition.toString())
//
//                        Slider(
//                            value = sliderPosition,
//                            onValueChange = { sliderPosition = it },
//                            colors = SliderDefaults.colors(
//                                thumbColor = Color.Green,
//                                activeTrackColor = Color.Red,
//                                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
//                            ),
//                            steps = 3,
//                            valueRange = 0f..50f
//                        )
//                        Text(text = sliderPosition.toString())
//
//                    }


                //  var check by remember { mutableFloatStateOf(true) }

//                    var checked by remember { mutableStateOf(true) }
//
//                    Switch(
//                        checked = checked,
//                        onCheckedChange = {
//                            checked = it
//                        }
//                    )
//                    Switch(
//                        checked = checked,
//                        onCheckedChange = {
//                            checked = it
//                        },
//                        thumbContent = if (checked) {
//                            {
//                                Icon(
//                                    imageVector = Icons.Filled.Check,
//                                    contentDescription = null,
//                                    modifier = Modifier.size(SwitchDefaults.IconSize),
//                                )
//                            }
//                        } else {
//                            null
//                        }
//                    )


//
//                    Text(text = "Hello")
//                    Divider(thickness = 2.dp)
//                    Text("World")
//
//
//
//
//
//                }

//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(IntrinsicSize.Min),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Text("First item in row")
//                    VerticalDivider(color = MaterialTheme.colorScheme.secondary)
//                    Text("Second item in row")
//                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {

//                    var selected by remember { mutableStateOf(false) }
//
//                    FilterChip(
//                        onClick = { selected = !selected },
//                        label = {
//                            Text("Filter chip")
//                        },
//                        selected = selected,
//                        leadingIcon = if (selected) {
//                            {
//                                Icon(
//                                    imageVector = Icons.Filled.Check,
//                                    contentDescription = "Done icon",
//                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
//                                )
//                            }
//                        } else {
//                            null
//                        },
//                    )
//
//                    AssistChip(
//                        onClick = { Log.d("Assist chip", "hello world") },
//                        label = { Text("Assist chip") },
//                        leadingIcon = {
//                            Icon(
//                                Icons.Filled.Settings,
//                                contentDescription = "Localized description",
//                                Modifier.size(AssistChipDefaults.IconSize)
//                            )
//                        }
//                    )
//
//
//                    InputChipExample(text = "Hello") {}
//

                    Text(text = "Hello")
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    Text("World")
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputChipExample(
        text: String,
        onDismiss: () -> Unit,
    ) {
        var enabled by remember { mutableStateOf(true) }
        if (!enabled) return

        InputChip(
            onClick = {
                onDismiss()
                enabled = !enabled
            },
            label = { Text(text) },
            selected = enabled,
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
        )
    }
}