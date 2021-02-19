package com.test.foodapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.foodapp.models.Result
import com.test.foodapp.util.Constant.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result,
)