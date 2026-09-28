package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import com.example.vadimabramov.data.model.User
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun fetchUser(userID: Int){
        viewModelScope.launch{
            try {
                val getUser = RetrofitClient.userApi.getUser(userID)
                val userCompany = getUser.company
                Log.d("UserViewModel: fetchUser",
                    "ДО -----> Идентификатор -> ${getUser.id}\n"+
                            "Имя -> ${getUser.firstName}\n" +
                            "Фамилия -> ${getUser.lastName}\n" +
                            "Название компании -> ${userCompany.name}\n" +
                            "Должность -> ${userCompany.title}\n")
            } catch (ex: Exception){
                Log.e("UserViewModel: fetchUser", ex.message.toString()) }
        }
    }


    fun updateUser(userID: Int, user: User){
        viewModelScope.launch {
            try {
                val response = RetrofitClient.userApi.updateUser(userID,user)
                val userCompany = response.company
                Log.d("UserViewModel: fetchUser",
                    "ПОСЛЕ -----> Идентификатор -> ${response.id}\n"+
                            "Имя -> ${response.firstName}\n" +
                            "Фамилия -> ${response.lastName}\n" +
                            "Название компании -> ${userCompany.name}\n" +
                            "Должность -> ${userCompany.title}\n")
            } catch (ex: Exception){
                Log.e("UserViewModel: fetchUser", ex.message.toString()) }
        }
    }
}
