package com.example.refeicoes.data.network

import com.example.refeicoes.data.model.CategoryApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("{api_key}/categories.php")
    suspend fun getCategories(@Path("api_key") apiKey: String): CategoryApiResponse
}