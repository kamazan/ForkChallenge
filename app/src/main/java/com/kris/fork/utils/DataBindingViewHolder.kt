package com.kris.fork.utils


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.kris.fork.BR

open class DataBindingViewHolder<T>(protected val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
    open fun bind(item: T) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}