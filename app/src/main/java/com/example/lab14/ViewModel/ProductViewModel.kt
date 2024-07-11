package com.example.lab14.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab14.API.RetrofitClient
import com.example.lab14.Data.Product
//import com.example.lab14.Product
//import com.example.lab14.ProductRepository
import com.example.lab14.Repository.ProductRepository
//import com.example.lab14.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel(){

    private val _products= MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>> =_products

    private val repository= ProductRepository(RetrofitClient.apiService)

    init {
        fetchProduct()
    }

    fun fetchProduct(){

        viewModelScope.launch {

            try {
                val productList=repository.getProducts()
                _products.postValue(productList)
                println("api called")
            }
            catch (e: Exception)
            {


            }

        }
    }

}
