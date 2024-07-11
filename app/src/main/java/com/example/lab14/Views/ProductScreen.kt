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
import com.example.lab14.R


import com.example.lab14.ViewModel.ProductViewModel

@Composable
fun ProductScreen(productVM: ProductViewModel) {

    val products by productVM.product.observeAsState(emptyList())

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.teal_700)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Shopping App",
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
            items(products){
                ProductItem(product = it)

            }
        }
    }


}

@Composable
fun ProductItem(product: Product){

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Card(modifier = Modifier.padding(10.dp)) {

            Column( modifier = Modifier.padding(10.dp)) {


                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {

                    AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        modifier = Modifier
                            .width(200.dp)
                            .height(300.dp)
                    )
                }

                Row(modifier = Modifier.padding(10.dp)) {
                    var r =product.rating.rate



                        while (r>=0){

                            rate(r)
                            r--


                    }
                    
                    Text(text = "("+product.rating.count.toString()+")", fontSize = 14.sp)

                }
                
                Text(text = product.category.toUpperCase(), modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp), fontWeight = FontWeight.Thin, fontSize = 12.sp)
                Text(text = product.title, modifier = Modifier
                    .padding(10.dp)
                    .width(350.dp), fontWeight = FontWeight.Bold,)

                Text(text = "Rs. "+product.price.toString(), modifier = Modifier
                    .padding(10.dp)
                    .width(350.dp), fontWeight = FontWeight.ExtraBold)
            }

        }

    }
}

@Composable
fun rate(a: Double) {


    if (a>=0.7) {
        Image(painterResource(id = R.drawable.star), contentDescription = "", modifier = Modifier.size(18.dp))

    }
    if (a>=0.3&&a<0.7) {
        Image(painterResource(id = R.drawable.starhalf), contentDescription = "", modifier = Modifier.size(18.dp))
    }



}

