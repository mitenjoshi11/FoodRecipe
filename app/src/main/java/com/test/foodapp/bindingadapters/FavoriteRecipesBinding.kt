package com.test.foodapp.bindingadapters

import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.foodapp.adapters.FavoriteRecipesAdapter
import com.test.foodapp.data.database.entities.FavoriteEntity

class FavoriteRecipesBinding {

    companion object {
        @BindingAdapter("setVisibility", "setData", requireAll = false)
        @JvmStatic
        fun setVisibility(
            view: View,
            favoriteEntity: List<FavoriteEntity>?,
            mAdapter: FavoriteRecipesAdapter?,
        ) {
            when (view) {
                is RecyclerView -> {
                    val dataCheck = favoriteEntity.isNullOrEmpty()
                    view.isInvisible = dataCheck
                    if (!dataCheck) {
                        favoriteEntity?.let { mAdapter?.setData(it) }
                    }
                }
                else -> view.isVisible = favoriteEntity.isNullOrEmpty()
            }
        }
    }
}