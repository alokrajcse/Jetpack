package com.example.lab17

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab17.ui.theme.LAB17Theme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //enableEdgeToEdge()
        setContent {
            val userList = remember {
                mutableStateOf<List<users>>(emptyList())
            }
            LAB17Theme {


                fetchdata { users ->
                    userList.value = users
                }
                output(userList = userList)
                 //mainscreen()
            }
        }












    }
    fun addUsers(name: String, roll: String, sic: String) {

        val db = Firebase.firestore

        val user = users(name, roll)
        db.collection("users")
            .document(sic)
            .set(user)
            .addOnSuccessListener { docref->
                println("sucess")
            }
            .addOnFailureListener{docref ->
                println("not success")
            }





    }

    data class users(
        val name: String = "",
        val roll: String = ""
    )
    @Composable
    fun mainscreen(modifier: Modifier = Modifier) {

        var name by remember {
            mutableStateOf("")
        }
        var roll by remember {
            mutableStateOf("")
        }
        var sic by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(value = name, onValueChange = {
                name = it
            }, label = {
                Text(text = "Enter your name")
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            )

            OutlinedTextField(value = roll, onValueChange = {
                roll = it
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                label = {
                    Text(text = "Enter your Roll no")
                })
            OutlinedTextField(value = sic, onValueChange = {
                sic = it
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                label = {
                    Text(text = "Enter your sic")
                })

            Button(onClick = { addUsers(name,roll,sic) }) {
                Text(text = "Save Data")

            }

        }

    }



    fun fetchdata(onResult: (List<users>) -> Unit){

        val db=Firebase.firestore

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                val userList =result.map { document -> document.toObject(users::class.java) }
                onResult(userList)

            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}


@Composable
fun output(userList: MutableState<List<MainActivity.users>>, modifier: Modifier = Modifier) {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {


        items(userList.value) { user ->
            Text(text = "NAME: ${user.name}", modifier = Modifier.padding(15.dp))
            Text(text = "ROLL: ${user.roll}", modifier = Modifier.padding(15.dp))

        }


    }

}