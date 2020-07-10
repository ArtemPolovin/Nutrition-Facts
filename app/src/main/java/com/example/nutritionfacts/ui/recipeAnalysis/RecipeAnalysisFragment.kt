package com.example.nutritionfacts.ui.recipeAnalysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutritionfacts.App
import com.example.nutritionfacts.R
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.databinding.FragmentRecipeAnalysisBindingImpl
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import kotlinx.android.synthetic.main.fragment_recipe_analysis.*
import javax.inject.Inject


class RecipeAnalysisFragment : Fragment() {

    private val recipeLineList = mutableListOf("")
    private lateinit var adapter: AdapterRecipeAnalysis

    private lateinit var recipeAnalysisBinding: FragmentRecipeAnalysisBindingImpl

    @Inject
    lateinit var recipeAnalysisFactory: RecipeAnalysisFactory
    private lateinit var recipeAnalysisViewModel: RecipeAnalysisViewModel

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

        (activity?.applicationContext as App).recipeAnalysisComponent.injectRecipeAnalysisFragment(
            this
        )

        recipeAnalysisViewModel =
            ViewModelProvider(this, recipeAnalysisFactory).get(RecipeAnalysisViewModel::class.java)


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

        setupRecipeAnalysis()

        btn_submit_recipe_analysis.setOnClickListener {
            recipeAnalysisViewModel.enteredRecipe(RecipeAnalysisPojo(recipeLineList))
        }

        text_add_line.setOnClickListener {
            recipeLineList.add("")
            val lastIndex = recipeLineList.size - 1
            adapter.notifyItemInserted(lastIndex)
            rv_recipe_analysis.smoothScrollToPosition(lastIndex)
        }
    }

    private fun setupRecipeAnalysis() {
        recipeAnalysisViewModel.recipeAnalysisViewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                FoodAnalysisViewState.Loading -> {
                    progressbar_recipe_analysis.visibility = View.VISIBLE
                }
                FoodAnalysisViewState.Error -> {
                    progressbar_recipe_analysis.visibility = View.GONE
                    recipe_analysis_table.visibility = View.GONE
                    recipe_analysis_erro.visibility = View.VISIBLE
                    recipe_input_text_info.visibility = View.GONE

                }
                is FoodAnalysisViewState.FoodAnalysisLoaded -> {
                    progressbar_recipe_analysis.visibility = View.GONE
                    recipe_input_text_info.visibility = View.GONE
                    recipe_analysis_erro.visibility = View.GONE
                    recipe_analysis_table.visibility = View.VISIBLE
                    recipeAnalysisBinding.recipeAnalysis = it.foodAnalysis

                }
            }
        })
    }

}
