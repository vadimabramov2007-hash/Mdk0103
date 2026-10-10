package com.example.vadimabramov.data.service

import com.example.vadimabramov.data.model.AuthRequest
import com.example.vadimabramov.data.model.AuthResponses
import com.example.vadimabramov.data.model.Recipe
import com.example.vadimabramov.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthInterface {
    @POST("users/auth-with-password")
    suspend fun authentication(@Body authRequest: AuthRequest): AuthResponses
}