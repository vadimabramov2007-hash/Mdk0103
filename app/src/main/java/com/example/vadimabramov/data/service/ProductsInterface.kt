package com.example.vadimabramov.data.service

import com.example.vadimabramov.data.model.Products
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ProductsInterface {
    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") productId: Int): Products
}