package com.test.foodapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.foodapp.models.FoodRecipe
import com.test.foodapp.util.Constant.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe,
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}