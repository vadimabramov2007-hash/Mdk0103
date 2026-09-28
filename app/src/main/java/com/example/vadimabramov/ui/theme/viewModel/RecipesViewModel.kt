package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import com.example.vadimabramov.data.model.Recipe
import kotlinx.coroutines.launch

class RecipesViewModel: ViewModel() {
    fun createRecipe(recipe: Recipe){
        viewModelScope.launch {
            try {
                val addedRecipe = RetrofitClient.recipeApi.addRecipe(recipe)
                Log.d("createRecipe",
                    "Название - ${addedRecipe.name}\n " +
                            "Ингредиенты - ${addedRecipe.ingredients}\n " +
                            "Сложность - ${addedRecipe.difficulty}\n" +
                            "Количество калорий - ${addedRecipe.caloriesPerServing} ккал")
            } catch (ex: Exception){
                Log.e("createRecipe", ex.message.toString())
            }
        }
    }
}