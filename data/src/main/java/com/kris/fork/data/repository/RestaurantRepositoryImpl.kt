package com.kris.fork.data.repository

import com.kris.fork.data.store.RestaurantStore
import com.kris.fork.domain.entity.Restaurant
import com.kris.fork.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl(
    private val store: RestaurantStore
): RestaurantRepository {
    override fun getRestaurant(restaurantId: Long): Restaurant = store.getRestaurant(restaurantId)
}