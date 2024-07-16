package com.example.lab16

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    var storedVerificationId: String? = null
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()



        setContent {




                var navController = rememberNavController()

                NavHost(navController = navController, startDestination = "myDesign") {
                    composable("myDesign") { myDesign(navController, this@MainActivity) }






            }
        }
    }

    @Preview
    @Composable
    private fun myDesign(navController: NavController, activity: ComponentActivity) {

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
                    Text(text = "Phone Verification",textAlign = TextAlign.Center, fontSize = 30.sp, modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                        color = colorResource(id = R.color.teal_700)
                    )
                    Image(painter = painterResource(id = R.drawable.phonelogin), contentDescription = "", modifier = Modifier
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
                        label = { Text(text = "Phone Number")})

                    Button(onClick = { sendOtp(text, activity ) }, modifier = Modifier.padding(5.dp),colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                        id = R.color.teal_700))) {
                        Text(text = "Send OTP")

                    }


                    OutlinedTextField(value = text2, onValueChange = { text2 = it},

                        label = { Text(text = "OTP")},
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                    )


                    Button(onClick = { signInWithOtp( text2) }, modifier = Modifier.padding(5.dp),colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                        id = R.color.teal_700))
                    ) {
                        Text(text = "Validate Number")
                    }



                }
            }


        }


    }








     fun sendOtp(phoneNumber: String, activity: ComponentActivity) {
        val auth = FirebaseAuth.getInstance()
        val options = PhoneAuthOptions.newBuilder(Firebase.auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    Log.d(TAG, "onVerificationCompleted:$credential")
                    signInWithPhoneAuthCredential(credential)
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Log.w(TAG, "onVerificationFailed", e)
                    when (e) {
                        is FirebaseAuthInvalidCredentialsException -> Log.e(TAG, "Invalid request")
                        is FirebaseTooManyRequestsException -> Log.e(TAG, "SMS quota exceeded")
                        is FirebaseAuthMissingActivityForRecaptchaException -> Log.e(TAG, "reCAPTCHA verification attempted with null Activity")
                    }
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    Log.d(TAG, "onCodeSent:$verificationId")
                    storedVerificationId = verificationId
                    resendToken = token
                    // Save verification ID and resending token so we can use them later
                }
            }).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun signInWithOtp( code: String) {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        Firebase.auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithCredential:success")
                } else {
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Log.e(TAG, "Invalid verification code")
                    }
                }
            }
    }
}


