package com.test.foodapp.ui.fragments.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.foodapp.adapters.IngredientAdapter
import com.test.foodapp.databinding.FragmentIngredientBinding
import com.test.foodapp.models.Result
import com.test.foodapp.util.Constant


class IngredientsFragment : Fragment() {

    private val mAdapter: IngredientAdapter by lazy { IngredientAdapter() }

    private var _binding: FragmentIngredientBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentIngredientBinding.inflate(layoutInflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constant.RECIPE_RESULT_KEY)

        setupRecyclerView()

        myBundle?.extendedIngredients?.let { mAdapter.setData(it) }

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.ingredientRecyclerview.adapter = mAdapter
        binding.ingredientRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}