package com.example.refeicoes.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.refeicoes.ui.detail.DetailActivity
import com.example.refeicoes.ui.theme.MealRecipesTheme
import com.example.refeicoes.ui.theme.WotWBlue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealRecipesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = WotWBlue
                ) {
                    CategoryList(categoryList = viewModel.categoryList, context = this) {
                        val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                            putExtra(DetailActivity.DETAIL_CATEGORY, it)
                        }
                        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                        startActivity(intent)
                    }
                    viewModel.getCategories()

                }
            }
        }
    }
}