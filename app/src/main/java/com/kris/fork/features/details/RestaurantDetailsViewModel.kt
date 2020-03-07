package com.kris.fork.features.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kris.fork.domain.entity.Restaurant
import com.kris.fork.domain.interactor.GetRestaurant

class RestaurantDetailsViewModel(
    getRestaurant: GetRestaurant
): ViewModel() {

    val restaurant = MutableLiveData<Restaurant>()

    val displayReviews = Transformations.map(restaurant) { it.averageRate != null }

    companion object {
        private val RESTAURANT_ID: Long? = null
        private val RESTAURANT_IDS = listOf(32815L, 6861L, 40370L, 16409L, 14163L)

        val restaurantId: Long
            get() = RESTAURANT_ID ?: RESTAURANT_IDS.random()
    }

    init {
        getRestaurant(viewModelScope, restaurantId) { result ->
            result.getOrNull()?.let { restaurant.value = it }
        }
    }
}