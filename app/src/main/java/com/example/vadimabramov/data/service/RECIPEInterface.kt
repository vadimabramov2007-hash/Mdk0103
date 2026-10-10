package com.example.vadimabramov.data.service

import com.example.vadimabramov.data.model.ItemsRecipe
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RECIPEInterface {
    @GET("/recipes/records")
    suspend fun getRecipes(@Header ("Autorization") token: String) : ItemsRecipe
}