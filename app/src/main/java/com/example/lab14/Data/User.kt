package com.example.lab14.Data

data class User(
        val id: Int,
        val email: String,
        val username: String,
        val password: String,
        val phone: String,
        val name: Name
        )


data class Name(
    val firstname: String,
    val lastname: String
)
