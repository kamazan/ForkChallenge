package com.kris.fork.domain.interactor

import com.kris.fork.domain.entity.Restaurant
import com.kris.fork.domain.interactor.core.BaseInteractor
import com.kris.fork.domain.repository.RestaurantRepository

class GetRestaurant(
    private val restaurantRepository: RestaurantRepository
): BaseInteractor<Restaurant, Long>() {
    override fun run(params: Long): Restaurant = restaurantRepository.getRestaurant(params)
}