package com.test.foodapp.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.test.foodapp.R
import com.test.foodapp.databinding.FragmentOverviewBinding
import com.test.foodapp.models.Result
import com.test.foodapp.util.Constant.Companion.RECIPE_RESULT_KEY
import org.jsoup.Jsoup

class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        myBundle?.let { bundle ->
            binding.mainImageView.load(bundle.image)
            binding.titleTextView.text = bundle.title
            binding.likesTextView.text = bundle.aggregateLikes.toString()
            binding.timeTextView.text = bundle.readyInMinutes.toString()
            bundle.summary.let {
                val summary = Jsoup.parse(it).text()
                binding.summaryTextView.text = summary
            }
        }



        if (myBundle?.vegetarian == true) {
            binding.vegetarianImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.vegetarianTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.vegan == true) {
            binding.veganImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.veganTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.glutenFree == true) {
            binding.glutenFreeImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.glutenFreeTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.dairyFree == true) {
            binding.dairyFreeImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.dairyFreeTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.veryHealthy == true) {
            binding.healthyImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.healthyTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.cheap == true) {
            binding.cheapImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.cheapTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}