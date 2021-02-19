package com.test.foodapp.models

import com.google.gson.annotations.SerializedName
import com.test.foodapp.models.Result

data class FoodRecipe(
    @SerializedName("results")
    val results: List<Result>
)