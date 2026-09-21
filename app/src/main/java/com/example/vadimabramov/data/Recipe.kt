package com.example.vadimabramov.data

data class Recipe(
    val id: Int? = null,
    val name: String,
    val ingredients: List<String>,
    val difficulty: String,
    val caloriesPerServing: Int
)
