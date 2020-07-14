package com.example.nutritionfacts.ui.groceryFoodAnalysis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionfacts.R
import com.example.nutritionfacts.ui.models.GroceryFood

class GroceryFoodAdapter(private val groceryFoodList: MutableList<GroceryFood>) :
    RecyclerView.Adapter<GroceryFoodAdapter.GroceryFoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryFoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_grocery_food, parent, false)
        return GroceryFoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return groceryFoodList.size
    }

    override fun onBindViewHolder(holder: GroceryFoodViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class GroceryFoodViewHolder(itemId: View) : RecyclerView.ViewHolder(itemId) {
        private val groceryFoodImage: ImageView = itemId.findViewById(R.id.image_grocery_food)
        private val groceryFoodNameText: TextView = itemId.findViewById(R.id.text_grocery_food_name)
        private val groceryFoodCapacityText: TextView =
            itemId.findViewById(R.id.grocery_food_capacity)
        private val groceryFoodCaloriesText: TextView =
            itemId.findViewById(R.id.grocery_food_calories)

    }
}
