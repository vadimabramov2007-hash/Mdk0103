package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import com.example.vadimabramov.data.model.Company
import com.example.vadimabramov.data.model.User
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    fun fetchUser(userID: Int) {
        viewModelScope.launch {
            try {
                val user = RetrofitClient.userApi.getUser(userID)

                Log.d("UserViewModel: fetchUser", "" +
                        "ДО -----> Идентификатор -> ${user.id}\n" +
                        "Фамилия -> ${user.lastName}\n" +
                        "Название компании -> ${user.company.name}\n" +
                        "Должность -> ${user.company.title}\n" +
                        "")

                val newUser = user.copy(
                    firstName = "Олег",
                    lastName = "Павлов",
                    company = Company(
                        name = "Интел",
                        title = "Менеджер по продажам"
                    )
                )

                val response = RetrofitClient.userApi.updateUser(userID, newUser)

                Log.d("UserViewModel: fetchUser", "" +
                        "ДО -----> Идентификатор -> ${user.id}\n" +
                        "Фамилия -> ${user.lastName}\n" +
                        "Название компании -> ${user.company.name}\n" +
                        "Должность -> ${user.company.title}\n" +
                        "")

            } catch (ex: Exception) {
                Log.e("UserViewModel: fetchUser", "Ошибка при обновлении пользователя", ex)
            }
        }
    }
}
