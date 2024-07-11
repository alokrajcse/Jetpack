package com.example.lab14.Repository

import com.example.lab14.API.ApiService
import com.example.lab14.Data.Product
import com.example.lab14.Data.User

class UserRepository(private val apiService: ApiService)
{
    suspend fun getProducts(): List<User>{
        return apiService.getUsers()
    }
}