package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import com.example.vadimabramov.data.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class RecipeViewModel(private val tokenManager: TokenManager) : ViewModel() {

    fun fetch() {
        viewModelScope.launch {
            val token = tokenManager.tokenFlow().first()
            try {
                if (!token.isNullOrEmpty()) {
                    val recipe = RetrofitClient.recipesAPI.getRecipes(token)
                    val items = recipe.items
                    if (items != null) {
                        for (item in items) {
                            Log.d(
                                "RecipeViewModel",
                                "id: ${item.id}\n" +
                                        "name: ${item.name}\n" +
                                        "completed: ${item.difficulty}\n" +
                                        "created: ${item.created}\n" +
                                        "updated: ${item.updated}",
                            )
                        }
                    }
                    Log.d(
                        "RecipeViewModel",
                        "page: ${recipe.page}\n" +
                                "perPage: ${recipe.perPage}\n" +
                                "totalItems: ${recipe.totalItems}\n" +
                                "totalPages: ${recipe.totalPages}",
                    )
                }
            } catch (ex: Exception) {
                Log.e("TodoViewModel", ex.message ?: "", ex)
            }
        }
    }
}