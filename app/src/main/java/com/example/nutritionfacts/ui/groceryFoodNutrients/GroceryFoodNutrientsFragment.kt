package com.example.nutritionfacts.ui.groceryFoodNutrients

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.App
import com.example.nutritionfacts.R
import com.example.domain.repositories.pojo.GroceryFoodPojo
import com.example.domain.repositories.pojo.Ingredient
import com.example.nutritionfacts.databinding.FragmentGroceryFoodNutrientsBinding
import com.example.domain.models.GroceryFood
import com.example.nutritionfacts.ui.viewStates.GroceryFoodNutrientsViewState
import kotlinx.android.synthetic.main.fragment_grocery_food_nutrients.*
import javax.inject.Inject

class GroceryFoodNutrientsFragment : Fragment() {

    @Inject
    lateinit var groceryFoodNutrientsFactoryFactory: GroceryFoodNutrientsFactory
   private lateinit var groceryFoodNutrientsViewModel: GroceryFoodNutrientsViewModel
   private lateinit var groceryFoodNutrientsBinding: FragmentGroceryFoodNutrientsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        groceryFoodNutrientsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_grocery_food_nutrients,
            container,
            false
        )
        return groceryFoodNutrientsBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity?.applicationContext as App).appComponent.inject(
            this
        )

        groceryFoodNutrientsViewModel =
            ViewModelProvider(this, groceryFoodNutrientsFactoryFactory).get(
                GroceryFoodNutrientsViewModel::class.java
            )

        val groceryFood = arguments?.getSerializable("key") as GroceryFood
        groceryFoodNutrientsViewModel.getGroceryFoodPojo(
            GroceryFoodPojo(listOf(Ingredient(1, groceryFood.measureURI, groceryFood.foodId)))
        )

        setupGroceryFoodNutrients()

        imageButton_close_fragment.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }

    private fun setupGroceryFoodNutrients() {
        groceryFoodNutrientsViewModel.groceryFoodNutrients.observe(viewLifecycleOwner, Observer {
            when (it) {
                GroceryFoodNutrientsViewState.Loading -> {
                    grocery_food_nutrients_progressbar.visibility = View.VISIBLE
                }
                GroceryFoodNutrientsViewState.Error -> {
                    grocery_food_nutrients_relativelayout.setBackgroundColor(Color.GRAY)
                    grocery_food_nutrients_progressbar.visibility = View.GONE
                    grocery_food_nutrients_table.visibility = View.GONE
                    grocery_food_nutrients_error_text.visibility = View.VISIBLE
                }
                is GroceryFoodNutrientsViewState.GroceryFoodLoaded -> {
                    grocery_food_nutrients_error_text.visibility = View.GONE
                    grocery_food_nutrients_progressbar.visibility = View.GONE
                    grocery_food_nutrients_table.visibility = View.VISIBLE
                    groceryFoodNutrientsBinding.groceryFoodAnalysis = it.groceryFoodNutrients
                }

            }
        })
    }


}
