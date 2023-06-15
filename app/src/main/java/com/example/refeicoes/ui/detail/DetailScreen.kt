package com.example.refeicoes.ui.detail

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.refeicoes.data.model.Category
import com.example.refeicoes.ui.theme.MealRecipesTheme
import com.example.refeicoes.ui.theme.WotWLightBlue

@Composable
fun CategoryItem(category: Category, context: Context) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight(),
        color = WotWLightBlue,
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight()
        ) {

            Text(
                text = category.str,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .padding(25.dp)
            )
            Image(
                painter = rememberAsyncImagePainter(
                    model = category.strThumb,
                    imageLoader = ImageLoader.Builder(context).crossfade(true).build()
                ),
                contentDescription = category.str,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            )
            Text(
                text = category.strDescription,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .padding(25.dp)
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealRecipesTheme {
        val category = Category(
            "2",
            "Beef",
            "https://www.themealdb.com/images/category/beef.png",
            "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]"
        )

        CategoryItem(category = category, LocalContext.current)

    }
}