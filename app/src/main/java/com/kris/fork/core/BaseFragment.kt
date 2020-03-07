package com.kris.fork.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract val layoutId: Int



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }
}

abstract class BaseDataBindingFragment<ViewModel : androidx.lifecycle.ViewModel, DataBinding : ViewDataBinding> :
    BaseFragment() {

    abstract val viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<DataBinding>(
            inflater,
            layoutId,
            container,
            false
        ).apply {
            onCreateViewDataBinding(this)
        }.root
    }

    open fun onCreateViewDataBinding(dataBinding: DataBinding) {
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(com.kris.fork.BR.viewModel, viewModel)
    }

}