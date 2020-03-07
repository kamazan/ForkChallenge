package com.kris.fork.features.details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kris.fork.R
import com.kris.fork.domain.entity.TagHolder
import com.kris.fork.utils.DataBindingAdapter

class TagAdapter : DataBindingAdapter<TagHolder>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int = R.layout.layout_row_tag

    class DiffCallback : DiffUtil.ItemCallback<TagHolder>() {
        override fun areContentsTheSame(oldItem: TagHolder, newItem: TagHolder): Boolean = oldItem.tags == newItem.tags

        override fun areItemsTheSame(oldItem: TagHolder, newItem: TagHolder): Boolean = oldItem.name == newItem.name
    }
}