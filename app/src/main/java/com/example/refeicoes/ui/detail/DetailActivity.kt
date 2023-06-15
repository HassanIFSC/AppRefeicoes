package com.example.refeicoes.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.refeicoes.data.model.Category
import com.example.refeicoes.ui.theme.MealRecipesTheme
import com.example.refeicoes.ui.theme.WotWBlue
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(DETAIL_CATEGORY, Serializable::class.java) as Category
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(DETAIL_CATEGORY) as Category
        }
        setContent {
            MealRecipesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = WotWBlue
                ) {
                    CategoryItem(category = category, context = this@DetailActivity)
                }
            }
        }
    }

    companion object {
        const val DETAIL_CATEGORY = "detail_category"
    }
}