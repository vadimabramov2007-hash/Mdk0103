package com.example.vadimabramov.data

import com.example.vadimabramov.data.service.ProductInteface
import com.example.vadimabramov.data.service.ProductsInterface
import com.example.vadimabramov.data.service.RecipesInterface
import com.example.vadimabramov.data.service.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val appProxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(appProxy)
        .build()

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productsApi: ProductInteface = retrofit.create(ProductInteface::class.java)
    val recipeApi: RecipesInterface = retrofit.create(RecipesInterface::class.java)
    val userApi: UserInterface = retrofit.create(UserInterface::class.java)
    val productApi: ProductsInterface = retrofit.create(ProductsInterface::class.java)
}