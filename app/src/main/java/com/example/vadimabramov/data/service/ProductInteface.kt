package com.example.vadimabramov.data.service

import com.example.vadimabramov.data.model.Products
import com.example.vadimabramov.data.model.ProductsRespone
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductInteface {
    @GET("products")
    suspend fun getAllProducts(): ProductsRespone

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") productId: Int): Products
}