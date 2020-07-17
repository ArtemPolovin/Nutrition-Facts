package com.example.nutritionfacts.ui.groceryFoodAnalysis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionfacts.R
import com.example.nutritionfacts.databinding.CellGroceryFoodBinding
import com.example.nutritionfacts.ui.models.GroceryFood

class GroceryFoodAdapter(
    private val groceryFoodList: List<GroceryFood>,
    private val clickListener: OnClickListenerGroceryFoodItem
) : RecyclerView.Adapter<GroceryFoodAdapter.GroceryFoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryFoodViewHolder {
        val cellGroceryFood: CellGroceryFoodBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cell_grocery_food,
            parent,
            false
        )
        return GroceryFoodViewHolder(cellGroceryFood)
    }

    override fun getItemCount(): Int {
        return groceryFoodList.size
    }

    override fun onBindViewHolder(holder: GroceryFoodViewHolder, position: Int) {
        holder.bind(groceryFoodList[position])
        holder.clickItem(groceryFoodList[position], clickListener)
    }

    class GroceryFoodViewHolder(cellGroceryFood: CellGroceryFoodBinding) :
        RecyclerView.ViewHolder(cellGroceryFood.root) {

        private val groceryFoodBinding = cellGroceryFood

        fun bind(groceryFood: GroceryFood) {
            groceryFoodBinding.groceryfood = groceryFood
        }

        fun clickItem(groceryFoodItem: GroceryFood, action: OnClickListenerGroceryFoodItem) {
            itemView.setOnClickListener { action.onItemClick(groceryFoodItem) }
        }
    }

    interface OnClickListenerGroceryFoodItem {
        fun onItemClick(groceryFoodItem: GroceryFood)
    }
}
