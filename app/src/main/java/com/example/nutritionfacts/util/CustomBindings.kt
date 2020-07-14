package com.example.nutritionfacts.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.nutritionfacts.R
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun bindingImage(image: ImageView, imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.mipmap.ic_missing_image)
        .error(R.mipmap.ic_error)
        .into(image)
}