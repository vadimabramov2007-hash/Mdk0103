package com.example.vadimabramov.data.service

import com.example.vadimabramov.data.model.ProductsRespone
import retrofit2.http.GET

interface ProductInteface {
    @GET("products")
    suspend fun getAllProducts(): ProductsRespone
}