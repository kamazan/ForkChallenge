package com.kris.fork.di

import com.kris.fork.features.details.RestaurantDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RestaurantDetailsViewModel(get()) }
}