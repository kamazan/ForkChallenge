package com.kris.fork.data.retrofit.service

import com.kris.fork.data.retrofit.model.RestaurantResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantService {
    companion object {
        private const val API_PATH = "api?method="

        private const val METHOD_GET_RESTAURANT_INFO = "restaurant_get_info"

        private const val RESTAURANT_ID_PARAMETER = "id_restaurant"
        private const val UNITS_PARAMETER = "units"
    }

    @GET("${API_PATH}${METHOD_GET_RESTAURANT_INFO}")
    fun getRestaurantInfo(
        @Query(RESTAURANT_ID_PARAMETER) restaurant: Long
    ): Call<RestaurantResponse>
}