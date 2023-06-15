package com.example.refeicoes.data.model

import com.google.gson.annotations.SerializedName

data class CategoryApiResponse(
    @SerializedName("categories") val categories: List<Category>
)