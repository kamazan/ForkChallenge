package com.kris.fork.data.retrofit.model

data class RestaurantTagList(
    val category_name: String,
    val tag_list: Map<String, RestaurantTag>
)