package com.example.vadimabramov.data.service

import com.example.vadimabramov.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipesInterface {
    @POST("recipes/add")
    suspend fun  addRecipe(@Body recipe: Recipe): Recipe
}