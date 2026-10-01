package com.example.vadimabramov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vadimabramov.data.model.Company
import com.example.vadimabramov.data.model.Recipe
import com.example.vadimabramov.data.model.User
import com.example.vadimabramov.ui.theme.viewModel.ProductViewModel
import com.example.vadimabramov.ui.theme.viewModel.RecipesViewModel
import com.example.vadimabramov.ui.theme.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Практическая работа 1
//          val productViewModel: ProductViewModel = viewModel()
//          productViewModel.fetchProducts()
//
//
//            //Практическая работа 2
//            val recipesViewModel: RecipesViewModel = viewModel()
//            val recipe = Recipe(
//                name = "Запеченный лосось в лимонно-горчичном маринаде",
//                ingredients = listOf(
//                    "Стейк или филе лосося",
//                    "лимонный сок",
//                    "горчица дижонская",
//                    "оливковое масло",
//                    "мед",
//                    "чеснок",
//                    "соль",
//                    "свежемолотый черный перец"
//                ),
//                difficulty = "Легкая",
//                caloriesPerServing = 420
//            )
//            recipesViewModel.createRecipe(recipe)

            //Практическая работа 3
            val  userViewModel: UserViewModel = viewModel()
            userViewModel.fetchUser(89)
            }
        }
    }


