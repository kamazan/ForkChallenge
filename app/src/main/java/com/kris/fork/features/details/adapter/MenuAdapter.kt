package com.kris.fork.features.details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kris.fork.R
import com.kris.fork.domain.entity.Dish
import com.kris.fork.utils.DataBindingAdapter

class MenuAdapter : DataBindingAdapter<Dish>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int = R.layout.layout_row_dish

    class DiffCallback : DiffUtil.ItemCallback<Dish>() {
        override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean =
            areItemsTheSame(oldItem, newItem)

        override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean = oldItem == newItem
    }
}