package com.example.nutritionfacts.ui.recipeAnalysis

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionfacts.R

class AdapterRecipeAnalysis(private val mRecipeLineList: MutableList<String>) :
    RecyclerView.Adapter<AdapterRecipeAnalysis.RecipeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_recipe_line, parent, false)
        return RecipeViewHolder(view, MyCustomEditTextListener(mRecipeLineList))
    }

    override fun getItemCount(): Int {
        return mRecipeLineList.count()
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.myCustomEditTextListener.updatePosition(position)
        holder.editTextRecipeLine.setText(mRecipeLineList[position])

        holder.imageCloseLine.setOnClickListener {
            removeLine(position)
        }
    }

    class RecipeViewHolder(itemView: View, val myCustomEditTextListener: MyCustomEditTextListener) :
        RecyclerView.ViewHolder(itemView) {
        val editTextRecipeLine: EditText =
            itemView.findViewById(R.id.editText_input_recipe_line)
        val imageCloseLine: ImageButton = itemView.findViewById(R.id.image_close)

        init {
            editTextRecipeLine.addTextChangedListener(myCustomEditTextListener)
        }
    }

    class MyCustomEditTextListener(private val recipeLineList: MutableList<String>) : TextWatcher {
        private var position = 0

        fun updatePosition(index: Int) {
            position = index
        }

        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            recipeLineList[position] = s.toString()
        }

    }

    private fun removeLine(position: Int) {
        mRecipeLineList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mRecipeLineList.size)
    }

}

