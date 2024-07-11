package com.example.lab14.Data

data class Product(
    val id: Int,
    val title: String,
    val price:Double,
    val category: String,
    val image: String,
    val rating: Rating
)
data class Rating(
    val rate: Double,
    val count: Int
)


