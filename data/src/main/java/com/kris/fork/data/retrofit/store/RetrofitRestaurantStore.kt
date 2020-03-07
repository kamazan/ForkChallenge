package com.kris.fork.data.retrofit.store

import com.kris.fork.data.retrofit.model.RestaurantResponse
import com.kris.fork.data.retrofit.service.RestaurantService
import com.kris.fork.data.store.RestaurantStore
import com.kris.fork.domain.entity.Restaurant
import com.kris.fork.domain.mapper.Mapper

class RetrofitRestaurantStore(
    private val restaurantService: RestaurantService,
    private val mapper: Mapper<RestaurantResponse, Restaurant>
): RestaurantStore{
    override fun getRestaurant(restaurantId: Long): Restaurant {
        val restaurantResponse = restaurantService.getRestaurantInfo(restaurantId).execute().body()!!
        return mapper.map(restaurantResponse)
    }
}