package com.example.vadimabramov.services

import com.example.vadimabramov.data.ProductsRespone
import retrofit2.http.GET

interface ProductInteface {
    @GET("products")
    suspend fun getAllProducts(): ProductsRespone
}