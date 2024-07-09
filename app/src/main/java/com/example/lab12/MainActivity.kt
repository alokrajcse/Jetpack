package com.example.lab12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.lab12.ui.theme.LAB12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContent {
            LAB12Theme {


                val viewModel: CounterViewModel by viewModels()
                //countView(counterVM = viewModel)

                //val intcontent=GenericClass(54)
                //val Stringcontent= GenericClass("hello")
                Column( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

//                    Text(text = "I am Generic : $intcontent")
//
//                    Text(text = "I am Generic : $Stringcontent")

                    GenericContent(54)
                    GenericContent("hello")



                }



                }
            }
        }
    }

@Preview
@Composable
private fun countView(counterVM: CounterViewModel) {


    val currentState = counterVM.result.value


    var temp by remember {
        mutableStateOf("")
    }
    var temp2 by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Text(text = "View Model adding two number")
        
        OutlinedTextField(
            value = temp,
            onValueChange = {
                temp = it
                
            },
            label = { Text("Enter num 1") }
        )

        OutlinedTextField(
            value = temp2,
            onValueChange = {
                temp2 = it
                
            },
            label = { Text("Enter num 2") }
        )

        Text(text = "Result value: ${currentState.num1 + currentState.num2}")
        Row {
            OutlinedButton(onClick = {

                counterVM.setNum1(temp.toIntOrNull() ?: 0)
                counterVM.setNum2(temp2.toIntOrNull() ?: 0)
                
                counterVM.addNumbers() }, colors = ButtonDefaults.buttonColors(
                Color.Magenta
            )) {
                Text(text = "Add")
            }


        }
    }
}

data class Counter(val count: Int)

data class nums(val num1: Int, val num2: Int)

class CounterViewModel : ViewModel() {
    private val _result = mutableStateOf(nums(0, 0))
    val result: State<nums> = _result

    fun setNum1(num: Int) {
        _result.value = nums(num, _result.value.num2)
    }

    fun setNum2(num: Int) {
        _result.value = nums(_result.value.num1, num)
    }

    fun addNumbers() {
        val sum = _result.value.num1 + _result.value.num2

        _result.value = nums(_result.value.num1, _result.value.num2)
    }
}


@Composable
fun <T>GenericContent(content: T) {
    Text(text = "I am Generic: $content")
}