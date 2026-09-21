package com.example.vadimabramov.data

data class ProductsRespone(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
