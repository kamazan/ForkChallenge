package com.kris.fork.domain.repository

import com.kris.fork.domain.entity.Restaurant

interface RestaurantRepository {
    fun getRestaurant(restaurantId: Long): Restaurant
}