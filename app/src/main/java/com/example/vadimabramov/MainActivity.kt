package com.example.vadimabramov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vadimabramov.data.Recipe
import com.example.vadimabramov.services.ProductViewModel
import com.example.vadimabramov.services.RecipesViewModel
import com.example.vadimabramov.ui.theme.VadimAbramovTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Практическая работа 1
          val productViewModel: ProductViewModel = viewModel()
          productViewModel.fetchProducts()


            //Практическая работа 2
            val recipesViewModel: RecipesViewModel = viewModel()
            val recipe = Recipe(
                name = "Запеченный лосось в лимонно-горчичном маринаде",
                ingredients = listOf(
                    "Стейк или филе лосося",
                    "лимонный сок",
                    "горчица дижонская",
                    "оливковое масло",
                    "мед",
                    "чеснок",
                    "соль",
                    "свежемолотый черный перец"
                ),
                difficulty = "Легкая",
                caloriesPerServing = 420
            )
            recipesViewModel.createRecipe(recipe)
            }
        }
    }


