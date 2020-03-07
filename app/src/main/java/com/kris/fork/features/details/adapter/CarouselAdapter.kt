package com.kris.fork.features.details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kris.fork.R
import com.kris.fork.domain.entity.Picture
import com.kris.fork.utils.DataBindingAdapter

class CarouselAdapter: DataBindingAdapter<Picture>(DiffCallback()) {
    override fun getItemViewType(position: Int): Int = R.layout.layout_item_carousel

    class DiffCallback: DiffUtil.ItemCallback<Picture>() {
        override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean = areItemsTheSame(oldItem, newItem)
    }
}