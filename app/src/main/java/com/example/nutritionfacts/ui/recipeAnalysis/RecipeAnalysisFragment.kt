package com.example.nutritionfacts.ui.recipeAnalysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutritionfacts.R
import com.example.nutritionfacts.databinding.FragmentRecipeAnalysisBindingImpl
import kotlinx.android.synthetic.main.fragment_recipe_analysis.*


class RecipeAnalysisFragment : Fragment(){

    private val recipeLineList = mutableListOf<String>()
    private lateinit var adapter: AdapterRecipeAnalysis

    private lateinit var recipeAnalysisBinding: FragmentRecipeAnalysisBindingImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recipeAnalysisBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_recipe_analysis,
            container,
            false

        )
        return recipeAnalysisBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            findNavController().navigate(R.id.action_nav_recipe_analysis_to_nav_food_text_analysis2,null)
        }

        adapter = AdapterRecipeAnalysis(recipeLineList)
        context.let {
            val linearLayoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
            linearLayoutManager.stackFromEnd = true
            rv_recipe_analysis.layoutManager = linearLayoutManager
            rv_recipe_analysis.adapter = adapter
            if (recipeLineList.size > 0) {
                rv_recipe_analysis.scrollToPosition(recipeLineList.size - 1)
            }
        }

        btn_submit_recipe_analysis.setOnClickListener {  }

        text_add_line.setOnClickListener {
            recipeLineList.add("")
        adapter.notifyDataSetChanged()}
    }

}
