package com.example.refeicoes.data

import com.example.refeicoes.data.model.Category
import com.example.refeicoes.data.network.ApiService
import com.example.refeicoes.di.NetworkConstants
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: ApiService,
) {
    suspend fun getCategories(): List<Category> {
        return api.getCategories(NetworkConstants.API_KEY).categories
    }
}