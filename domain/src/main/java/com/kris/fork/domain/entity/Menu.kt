package com.kris.fork.domain.entity

data class Menu(
    val starters: List<Dish>,
    val mains: List<Dish>,
    val desserts: List<Dish>
) {
    val dishes: List<Dish>
        get() = starters + mains + desserts
}