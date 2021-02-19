package com.test.foodapp.ui.fragments.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.test.foodapp.databinding.FragmentInstructionBinding
import com.test.foodapp.models.Result
import com.test.foodapp.util.Constant


class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)
        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constant.RECIPE_RESULT_KEY)
        binding.instructionsWebView.webViewClient = object : WebViewClient() {}
        val webviewURL = myBundle!!.sourceUrl
        binding.instructionsWebView.loadUrl(webviewURL)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}