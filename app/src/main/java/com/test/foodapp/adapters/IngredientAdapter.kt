package com.test.foodapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.test.foodapp.R
import com.test.foodapp.databinding.IngredientRowLayoutBinding
import com.test.foodapp.models.ExtendedIngredient
import com.test.foodapp.util.Constant.Companion.BASE_IMAGE_URL
import com.test.foodapp.util.RecipesDiffUtils
import java.util.*

class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.MyViewHolder>() {

    private var ingredientsList = emptyList<ExtendedIngredient>()

    class MyViewHolder(val binding: IngredientRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(IngredientRowLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.ingredientImageView.load(BASE_IMAGE_URL + ingredientsList[position].image) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }
        holder.binding.ingredientName.text =
            ingredientsList[position].name.capitalize(Locale.ROOT)
        holder.binding.ingredientAmount.text = ingredientsList[position].amount.toString()
        holder.binding.ingredientUnit.text = ingredientsList[position].unit
        holder.binding.ingredientConsistency.text = ingredientsList[position].consistency
        holder.binding.ingredientOriginal.text = ingredientsList[position].original

    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }

    fun setData(newIngredients: List<ExtendedIngredient>) {
        val ingredeintDiffUtils = RecipesDiffUtils(ingredientsList, newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(ingredeintDiffUtils)
        ingredientsList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)

    }


}