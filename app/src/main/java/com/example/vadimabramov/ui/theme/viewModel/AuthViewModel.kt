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
                    val Recipe = RetrofitClient.recipesAPI.getRecipes(token)
                    Log.d(
                        "AuthViewModel",
                        "items: ${Recipe.items}\n" +
                                "page: ${Recipe.page}\n" +
                                "perPage: ${Recipe.perPage}\n" +
                                "totalItems: ${Recipe.totalItems}\n" +
                                "totalPages: ${Recipe.totalPages}",
                    )
                }
            } catch (ex: Exception) {
                Log.e("AuthViewModel", ex.message, ex)
            }
        }
    }
}