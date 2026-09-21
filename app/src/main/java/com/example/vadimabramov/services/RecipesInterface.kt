package com.example.vadimabramov.services

import com.example.vadimabramov.data.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipesInterface {
    @POST("recipes/add")
    suspend fun  addRecipe(@Body recipe: Recipe): Recipe
}