package com.kris.fork.data.di

import com.kris.fork.data.repository.RestaurantRepositoryImpl
import com.kris.fork.data.retrofit.RetrofitClient
import com.kris.fork.data.retrofit.mapper.RestaurantResponseMapper
import com.kris.fork.data.retrofit.service.RestaurantService
import com.kris.fork.data.retrofit.store.RetrofitRestaurantStore
import com.kris.fork.data.store.RestaurantStore
import com.kris.fork.domain.repository.RestaurantRepository
import org.koin.dsl.module

val apiModule = module {
    single { RetrofitClient(get()) }
}

val repositoryModule = module {
    factory<RestaurantRepository> { RestaurantRepositoryImpl(get()) }
}

val storeModule = module {
    factory<RestaurantStore> {
        RetrofitRestaurantStore(
            get<RetrofitClient>().getService(RestaurantService::class.java),
            RestaurantResponseMapper
        )
    }
}