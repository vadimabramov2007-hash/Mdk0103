package com.example.vadimabramov.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vadimabramov.data.RetrofitClient
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    fun deleteProductById(productId: Int) {
        viewModelScope.launch {
            try {
                val delProduct = RetrofitClient.productApi.deleteProduct(productId)
                Log.d(
                    "ProductsViewModel",
                    "${delProduct.id} ---- ${delProduct.isDeleted} ----- ${delProduct.deletedOn}"
                )
            } catch (ex: Exception) {
                Log.e("ProductsViewModel: deleteProductById", ex.message.orEmpty())
            }
        }
    }
}
