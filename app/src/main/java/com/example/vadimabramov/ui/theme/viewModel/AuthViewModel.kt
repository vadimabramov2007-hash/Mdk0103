package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import com.example.vadimabramov.data.TokenManager
import com.example.vadimabramov.data.model.AuthRequest
import kotlinx.coroutines.launch

class AuthViewModel(
    private val tokenManager: TokenManager,
    private val todoViewModel: RecipeViewModel,
) : ViewModel() {

    fun login(authRequest: AuthRequest) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authAPI.authentication(authRequest)
                Log.d("AuthViewModel", "User: ${authUser.token} ${authUser.record}")
                Log.d("AuthViewModel", "Responses: ${authUser.token} ${authUser.record}")


                    writeToken(authUser.token)
                    todoViewModel.fetch()


                val records = RetrofitClient.recipesAPI.getRecipes(authUser.token)

                Log.d(
                    "AuthViewModel",
                    "items: ${records.items}\n" +
                            "page: ${records.page}\n" +
                            "perPage: ${records.perPage}\n" +
                            "totalItems: ${records.totalItems}\n" +
                            "totalPages: ${records.totalPages}",
                )
            } catch (ex: Exception) {
                Log.e("AuthViewModel", ex.message ?: "", ex)
            }
        }
    }

    fun writeToken(token: String) {
        viewModelScope.launch {
            tokenManager.saveToken(token)
        }
    }
}