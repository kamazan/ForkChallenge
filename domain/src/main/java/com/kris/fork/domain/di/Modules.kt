package com.kris.fork.domain.di

import com.kris.fork.domain.interactor.GetRestaurant
import org.koin.dsl.module

val interactorModule = module {
    factory { GetRestaurant(get()) }
}