package com.sit.layoutdesignassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sit.layoutdesignassignment.ui.theme.LayoutDesignAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        val auth = Firebase.auth

        setContent {
            LayoutDesignAssignmentTheme {


                var navController = rememberNavController()

                NavHost(navController = navController, startDestination = "myDesign") {
                    composable("myDesign") { myDesign(navController) }
                    composable("Signupscreen") { Signupscreen(navController ) }
                    // Add more destinations similarly.
                }

                //myDesign()
                //Signupscreen(navController)


            }
        }
    }
}


@Preview
@Composable
private fun myDesign(navController: NavController) {

    Column (
        Modifier
            .background(Color.White)
            .fillMaxSize()){
        Card(modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()

            , colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.lightblue))) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Signin Page",textAlign = TextAlign.Center, fontSize = 30.sp, modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                    color = colorResource(id = R.color.teal_700)
                )
                Image(painter = painterResource(id = R.drawable.signin), contentDescription = "", modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp))
            }
            Column(modifier = Modifier.padding(15.dp)) {

                Text(text = "Login", fontSize = 30.sp,  color = colorResource(id = R.color.teal_700), modifier = Modifier.padding(5.dp))


                var text by remember { mutableStateOf("") }
                var text2 by remember { mutableStateOf("") }

                OutlinedTextField(value = text, onValueChange = { text = it}, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                    label = { Text(text = "Email or Phone Number")})

                OutlinedTextField(value = text2, onValueChange = { text2 = it},

                    label = { Text(text = "Password")},
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(), trailingIcon = {Icon(
                        painter = painterResource(id = R.drawable.hide),
                        contentDescription ="", modifier = Modifier.size(20.dp)
                    )}
                )
                Text(text = "Forgot Password?", fontSize = 15.sp, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(), textAlign = TextAlign.End,
                    color = colorResource(id = R.color.teal_700))

                Button(onClick = { SignIn(text,text2) }, modifier = Modifier.padding(5.dp),colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                    id = R.color.teal_700))
                ) {
                    Text(text = "Login")
                }



            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 15.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = { navController.navigate("Signupscreen") }) {
                Text(
                    text = " Register",
                    color = colorResource(id = R.color.teal_700)
                )
                
            }

        }

    }
    

}


fun SignIn(email: String, password: String){

    val auth=Firebase.auth
    auth.signInWithEmailAndPassword(email,password)
        .addOnCompleteListener(){ task->
            if (task.isSuccessful)
            {
                println("Signin Successful")
            }
            else
            {
                println("user not found! please signup")
                println("Sign-in failed: ${task.exception?.message}")

            }
        }

}

fun SignUp(email: String, password: String)
{

    val auth=Firebase.auth

    auth.createUserWithEmailAndPassword(email,password)
        .addOnCompleteListener() { task->
            if (task.isSuccessful)
            {
                println("user created sucessfully")
            }
            else{
                println("failed to create user")
            }
        }


}

@Preview
@Composable
private fun Signupscreen(navController: NavController) {


    Column (
        Modifier
            .background(Color.White)
            .fillMaxSize()){
        Card(modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()

            , colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.lightblue))) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Signup Page",textAlign = TextAlign.Center, fontSize = 30.sp, modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                    color = colorResource(id = R.color.teal_700)
                )
                Image(painter = painterResource(id = R.drawable.signup), contentDescription = "", modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp))
            }
            Column(modifier = Modifier.padding(15.dp)) {

                Text(text = "Create your Account", fontSize = 30.sp,  color = colorResource(id = R.color.teal_700), modifier = Modifier.padding(5.dp))


                var text by remember { mutableStateOf("") }
                var text2 by remember { mutableStateOf("") }

                OutlinedTextField(value = text, onValueChange = { text = it}, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                    label = { Text(text = "Email or Phone Number")})

                OutlinedTextField(value = text2, onValueChange = { text2 = it},

                    label = { Text(text = "Password")},
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(), trailingIcon = {Icon(
                        painter = painterResource(id = R.drawable.hide),
                        contentDescription ="", modifier = Modifier.size(20.dp)
                    )}
                )


                Button(onClick = { SignUp(text,text2) }, modifier = Modifier.padding(5.dp),colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                    id = R.color.teal_700))
                ) {
                    Text(text = "SignUp")
                }



            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 15.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = { navController.navigate("myDesign") }) {
                Text(text = "Signin",fontSize = 15.sp,
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.teal_700),)
                
            }

        }

    }



}