package com.sit.lab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sit.lab8.ui.theme.LAB8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
          
            //Text(text = "Sample Text")
//            Row {
//                Text(text = " this")
//                Text(text = " is")
//                Text(text = " a")
//                Text(text = " row")
//                Text(text = " text")
//            }
//            Column {
//                Text(text = " this")
//                Text(text = " is")
//                Text(text = " a")
//                Text(text = " column")
//                Text(text = " text")
//            }

//
//            Row(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Gray)
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .weight(1f)
//                        .fillMaxSize()
//                        .background(Color.Yellow)
//                ) {
//                    Text(text = " this")
//                    Text(text = " is")
//                    Text(text = " a")
//                    Text(text = " column")
//                    Text(text = " 1")
//                    Text(text = "with")
//                    Text(text = " modifier")
//                }
//
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .weight(1f)
//                        .fillMaxSize()
//                        .background(Color.Blue)
//                ) {
//                    Text(text = " this")
//                    Text(text = " is")
//                    Text(text = " a")
//                    Text(text = " column")
//                    Text(text = " 2")
//                    Text(text = "with")
//                    Text(text = " modifier")
//                }
//            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                Box (modifier = Modifier
                    .background(Color.Green)

                    .size(220.dp)
                    .padding(10.dp)
                ){


                    Text(text = "Box 1")
                    Box(modifier = Modifier
                        .background(Color.Magenta)
                        .size(110.dp))
                    {
                        Text(text = "Box 2", color = Color.White)
                    }
                }





            }




        }
    }
}

