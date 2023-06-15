package com.example.refeicoes.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.refeicoes.data.model.Category
import com.example.refeicoes.domain.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
) : ViewModel() {
    var categoryList: List<Category> by mutableStateOf(listOf())
    fun getCategories() {
        viewModelScope.launch {
            categoryList = categoryUseCase.invoke()
        }
    }
}