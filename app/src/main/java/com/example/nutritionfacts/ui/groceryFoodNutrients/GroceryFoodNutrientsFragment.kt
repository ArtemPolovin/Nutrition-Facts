package com.example.nutritionfacts.ui.groceryFoodNutrients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nutritionfacts.R
import com.example.nutritionfacts.ui.models.GroceryFood
import kotlinx.android.synthetic.main.fragment_grocery_food_nutrients.*

class GroceryFoodNutrientsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grocery_food_nutrients, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val result = arguments?.getSerializable("key") as GroceryFood

        imageButton_close_fragment.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }


}
