package com.example.lab14.API

import com.example.lab14.Data.Product
import com.example.lab14.Data.User

import retrofit2.http.GET

interface ApiService{
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("users")
    suspend fun getUsers(): List<User>
}