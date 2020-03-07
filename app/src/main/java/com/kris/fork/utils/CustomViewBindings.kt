package com.kris.fork.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visible")
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("url", "centerCrop", requireAll = false)
fun ImageView.setUrl(url: String?, centerCrop: Boolean = false) {
    val builder = Glide.with(this)
        .load(url)

    if (centerCrop) { builder.centerCrop() }

    builder.into(this)
}