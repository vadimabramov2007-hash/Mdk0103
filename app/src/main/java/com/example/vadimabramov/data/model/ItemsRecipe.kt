package com.example.vadimabramov.data.model

data class ItemsRecipe(
    val items: ListRecipe,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int,
)
