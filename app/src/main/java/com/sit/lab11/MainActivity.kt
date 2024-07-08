package com.sit.lab11

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sit.lab11.ui.theme.LAB11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            LAB11Theme {

//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "Screen1") {
//                    composable("Screen1") {
//                        Screen1(navController)
//                    }
//                    composable("Screen2") {
//                        Screen2(navController)
//
//                    }
//                    composable("Screen3") {
//                        Screen3(navController)
//                    }
//                    composable("Screen4/{data}") {
//                        Screen4(navController, it.arguments?.getString("data")!!)
//                    }

                MessageList()
                //grid()
                }
            }
        }
    }



@Composable
private fun Screen1(navController: NavHostController) {
    
    
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        
        Text(text = "Screen 1")
        Button(onClick = { navController.navigate("Screen2") }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red) ) {
            
            Text(text = "Go to Screen 2")
            
        }
        
        
    }



}

@Composable
fun Screen2(navController: NavHostController) {


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Screen 2")
        Button(onClick = { navController.navigate("Screen3") }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red) ) {

            Text(text = "Go to Screen 3")

        }


    }


}


@Composable
fun Screen3(navController: NavHostController) {


    var data by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Screen 3")
        OutlinedTextField(value = data , onValueChange = {
            data = it
        }, label = { Text(text = "Enter Data to send to Screen 4") })
        Button(onClick = { navController.navigate("Screen4/$data") }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red) ) {

            Text(text = "Go to Screen 4")

        }


    }


}



@Composable
fun Screen4(navController: NavHostController, data2: String) {


    var data by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "data received is $data2", fontSize = 32.sp)

        Button(onClick = { navController.navigate("Screen1") }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red) ) {

            Text(text = "Go to Screen 1")

        }


    }


}

@Composable
fun MessageList() {

//    Column {
//        message.forEach {
//            message->Mes
//        }
//    }
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        items(115) { index ->
            Card(modifier = Modifier.padding(15.dp)) {

                Text(text = "Item: $index",fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp), fontSize = 18.sp , color = Color.Magenta, textAlign = TextAlign.Center)

            }
        }

    }
    
}

@Preview
@Composable
private fun grid() {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(100) { index ->

            Card(modifier = Modifier.padding(15.dp)) {

                Text(text = "Item: $index",fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp), fontSize = 18.sp , color = Color.Magenta, textAlign = TextAlign.Center)

            }


        }
    }

}