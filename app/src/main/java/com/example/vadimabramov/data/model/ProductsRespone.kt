package com.example.vadimabramov.data.model

data class ProductsRespone(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)