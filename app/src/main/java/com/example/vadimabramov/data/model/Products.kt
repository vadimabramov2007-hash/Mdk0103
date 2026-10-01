package com.example.vadimabramov.data.model

data class Products(
    val id: Int,
    val isDeleted: Boolean = false,
    val deletedOn: String
)
