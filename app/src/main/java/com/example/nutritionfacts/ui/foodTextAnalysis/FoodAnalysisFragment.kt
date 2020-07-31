package com.example.nutritionfacts.ui.foodTextAnalysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.App
import com.example.nutritionfacts.R
import com.example.nutritionfacts.databinding.FragmentFoodTextAnalysisBinding
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import kotlinx.android.synthetic.main.fragment_food_text_analysis.*
import javax.inject.Inject

class FoodAnalysisFragment : Fragment() {

    @Inject
    lateinit var foodAnalysisFactory: FoodAnalysisFactory
    private lateinit var foodAnalysisViewModel: FoodAnalysisViewModel
    private lateinit var foodAnalysisBinding: FragmentFoodTextAnalysisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foodAnalysisBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_food_text_analysis, container, false)

        return  foodAnalysisBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.show()

        (activity?.applicationContext as App).appComponent.inject(
            this
        )

        foodAnalysisViewModel =
            ViewModelProvider(this, foodAnalysisFactory).get(FoodAnalysisViewModel::class.java)

        setupFoodAnalysis()

        btn_submit_food_analysis.setOnClickListener {
            foodAnalysisViewModel.getFoodAnalysis(edit_text_input_field.text.toString())
            setupFoodAnalysis()
        }
    }

    private fun setupFoodAnalysis() {
        foodAnalysisViewModel.foodAnalysisViewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                FoodAnalysisViewState.Loading -> {
                    food_analysis_progressbar.visibility = View.VISIBLE
                }
                FoodAnalysisViewState.Error -> {
                    food_analysis_progressbar.visibility = View.GONE
                    food_analysis_table.visibility = View.GONE
                    input_text_info.visibility = View.GONE
                    text_food_analysis_erro.visibility = View.VISIBLE
                }
                is FoodAnalysisViewState.FoodAnalysisLoaded -> {
                    food_analysis_progressbar.visibility = View.GONE
                    input_text_info.visibility = View.GONE
                    text_food_analysis_erro.visibility = View.GONE
                    food_analysis_table.visibility = View.VISIBLE
                    foodAnalysisBinding.foodTextAnalysis = it.foodAnalysis
                }
            }
        })
    }

}
