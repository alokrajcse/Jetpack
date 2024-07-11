package com.example.lab14.Repository

import com.example.lab14.API.ApiService
import com.example.lab14.Data.Product


class ProductRepository(private val apiService: ApiService)
{
    suspend fun getProducts(): List<Product>{
        return apiService.getProducts()
    }
}