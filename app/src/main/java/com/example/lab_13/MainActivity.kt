package com.example.lab_13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_13.ui.theme.LAB_13Theme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContent {
            LAB_13Theme {

                val productVM : ProductViewModel by viewModels()

                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    OutlinedButton(onClick = { productVM.fetchProduct() }, colors = ButtonDefaults.buttonColors(
                        Color.Magenta
                    )) {

                        Text(text = "Click me to make api call")

                    }
                }


                }
            }
        }
    }


data class Product(val id: Int,
                   val title: String,
                   val price: Double,
                   val description: String,
                   val category: String,
                   val image: String,
                   val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)

interface ApiService{
    @GET("products")
    suspend fun getProducts(): List<Product>
}

object RetrofitClient{
    private val BASE_URL="https://fakestoreapi.com"
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

class ProductRepository(private val apiService: ApiService){

    suspend fun getProducts(): List<Product>{
        return apiService.getProducts()
    }


}


class ProductViewModel: ViewModel(){
    private val _products= MutableLiveData<List<Product>>()


    val products: LiveData<List<Product>> = _products


    private val repository=ProductRepository(RetrofitClient.apiService)

    fun fetchProduct(){

        viewModelScope.launch {
            try {
                val productList=repository.getProducts()
                _products.postValue(productList)
                println("API DATA CALLED: $productList")
            }
            catch (e: Exception){

            }
        }

    }

}


