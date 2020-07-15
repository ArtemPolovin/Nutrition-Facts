package com.example.nutritionfacts.ui.groceryFoodAnalysis

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutritionfacts.App
import com.example.nutritionfacts.R
import com.example.nutritionfacts.ui.viewStates.GroceryFoodViewState
import kotlinx.android.synthetic.main.fragment_grocery_food_analysis.*
import javax.inject.Inject


class GroceryFoodAnalysisFragment : Fragment() {

    @Inject
    lateinit var groceryFoodFactory: GroceryFoodFactory
    private lateinit var groceryFoodViewModel: GroceryFoodAnalysisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grocery_food_analysis, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity?.applicationContext as App).groceryFoodAnalysisComponent.injectGroceryFoodFragment(
            this
        )

        groceryFoodViewModel = ViewModelProvider(
            this,
            groceryFoodFactory
        ).get(GroceryFoodAnalysisViewModel::class.java)

        context.let {
            rv_grocery_food.layoutManager =
                LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
        }

        btn_submit_grocery_food_analysis.setOnClickListener {
            groceryFoodViewModel.enteredIngredient(edit_text_grocery_food_input.text.toString())
            setupGroceryFoodData()
        }
    }

    private fun setupGroceryFoodData() {
        groceryFoodViewModel.groceryFoodData.observe(viewLifecycleOwner, Observer {
            when (it) {
                GroceryFoodViewState.LOADING -> {
                    grocery_food_progressbar.visibility = View.VISIBLE

                }
                GroceryFoodViewState.ERROR -> {
                    grocery_food_progressbar.visibility = View.GONE
                    rv_grocery_food.visibility = View.GONE
                    grocery_food_error_text.visibility = View.VISIBLE

                }
                is GroceryFoodViewState.GroceryFoodDataLoaded -> {
                    grocery_food_progressbar.visibility = View.GONE
                    grocery_food_error_text.visibility = View.GONE
                    rv_grocery_food.visibility = View.VISIBLE
                    rv_grocery_food.adapter = GroceryFoodAdapter(it.groceryFoodDataList)
                }
            }
        })
    }

}
