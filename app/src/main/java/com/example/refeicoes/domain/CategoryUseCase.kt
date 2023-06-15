package com.example.refeicoes.domain

import com.example.refeicoes.data.Repository
import com.example.refeicoes.data.model.Category
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Category> =
        repository.getCategories()
}