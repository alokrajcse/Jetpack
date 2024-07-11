package com.example.lab14.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab14.API.RetrofitClient
import com.example.lab14.Data.Product
import com.example.lab14.Data.User
//import com.example.lab14.Product
//import com.example.lab14.ProductRepository
import com.example.lab14.Repository.ProductRepository
import com.example.lab14.Repository.UserRepository
//import com.example.lab14.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(){

    private val _user= MutableLiveData<List<User>>()
    val product: LiveData<List<User>> =_user

    private val repository= UserRepository(RetrofitClient.apiService)

    init {
        fetchUsers()
    }

    fun fetchUsers(){

        viewModelScope.launch {

            try {
                val productList=repository.getProducts()
                _user.postValue(productList)
                println("api called")
            }
            catch (e: Exception)
            {


            }

        }
    }

}
