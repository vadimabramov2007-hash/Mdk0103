package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import com.example.vadimabramov.data.model.AuthRequest
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    fun login(authRequest: AuthRequest) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authAPI.authentication(authRequest)
                Log.d("AuthViewModel", "Token: ${authUser.token}")
                Log.d("AuthViewModel", "User: ${authUser.record}")

                val token = authUser.token
                if (!token.isNullOrEmpty()) {
                    val recipe = RetrofitClient.recipesAPI.getRecipes(token)
                    Log.d("AuthViewModel", "items:")
                    for (item in recipe.items) {
                        Log.d("AuthViewModel", "  ${item.name}, ${item.difficulty}")
                    }
                    Log.d(
                        "AuthViewModel",
                        "page: ${recipe.page}\n" +
                                "perPage: ${recipe.perPage}\n" +
                                "totalItems: ${recipe.totalItems}\n" +
                                "totalPages: ${recipe.totalPages}"
                    )
                }
            } catch (ex: Exception) {
                Log.e("AuthViewModel", ex.message, ex)
            }
        }
    }
}