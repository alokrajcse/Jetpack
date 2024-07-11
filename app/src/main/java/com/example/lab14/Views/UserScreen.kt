package com.example.lab14.Views

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lab14.Data.Product
import com.example.lab14.Data.User
import com.example.lab14.R


import com.example.lab14.ViewModel.ProductViewModel
import com.example.lab14.ViewModel.UserViewModel

@Composable
fun UserScreen(userVM: UserViewModel) {

    val users by userVM.product.observeAsState(emptyList())

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.teal_700)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "User List",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }


        LazyColumn {
            items(users){
                UserItem(user = it)

            }
        }
    }


}

@Composable
fun UserItem(user: User){

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Card(modifier = Modifier.padding(10.dp)) {

            Column( modifier = Modifier.padding(10.dp)) {





                Row(modifier = Modifier.padding(5.dp)) {


                    Text(text = "ID:", modifier = Modifier
                        .padding(10.dp)
                        , fontWeight = FontWeight.Bold)
                    Text(text = user.id.toString(), modifier = Modifier.weight(1f)
                        .padding(10.dp)
                        .width(150.dp), fontWeight = FontWeight.Bold)

                }
                Row(modifier = Modifier.padding(5.dp)) {

                    Text(text = "Email:", modifier = Modifier
                        .padding(10.dp)
                        , fontWeight = FontWeight.Bold)
                    Text(text = user.email.toString(), modifier = Modifier.weight(1f)
                        .padding(10.dp)
                        .width(150.dp), fontWeight = FontWeight.Bold)

                }
                Row(modifier = Modifier.padding(5.dp)) {

                    Text(text = "Username:", modifier = Modifier
                        .padding(10.dp)
                        , fontWeight = FontWeight.Bold)
                    Text(text = user.username.toString(), modifier = Modifier.weight(1f)
                        .padding(10.dp)
                        .width(150.dp), fontWeight = FontWeight.Bold)

                }

                Row(modifier = Modifier.padding(5.dp)) {

                    Text(text = "Name:", modifier = Modifier
                        .padding(10.dp)
                        , fontWeight = FontWeight.Bold)
                    Text(text = user.name.firstname+" "+user.name.lastname, modifier = Modifier.weight(1f)
                        .padding(10.dp)
                        .width(150.dp), fontWeight = FontWeight.Bold)

                }
                Row(modifier = Modifier.padding(5.dp)) {

                    Text(text = "Phone:", modifier = Modifier
                        .padding(10.dp)
                        , fontWeight = FontWeight.Bold)
                    Text(text = user.phone.toString(), modifier = Modifier.weight(1f)
                        .padding(10.dp)
                        .width(150.dp), fontWeight = FontWeight.Bold)

                }


            }

        }

    }
}



