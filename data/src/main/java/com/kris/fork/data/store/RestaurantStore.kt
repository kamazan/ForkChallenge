package com.kris.fork.data.store

import com.kris.fork.domain.entity.Restaurant

interface RestaurantStore {
    fun getRestaurant(restaurantId: Long): Restaurant
}