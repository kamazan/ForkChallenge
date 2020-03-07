package com.kris.fork.data.retrofit.mapper

import com.kris.fork.data.retrofit.model.RestaurantData
import com.kris.fork.data.retrofit.model.RestaurantResponse
import com.kris.fork.domain.entity.*
import com.kris.fork.domain.mapper.Mapper
import java.util.*

object RestaurantResponseMapper : Mapper<RestaurantResponse, Restaurant> {
    override fun map(obj: RestaurantResponse): Restaurant {
        return obj.data.run {
            val currency = Currency.getInstance(currency_code)
            Restaurant(
                name = name,
                diaporamaPictures = pics_diaporama.map { Picture(it.label, it.url) },
                speciality = speciality,
                cardPrice = card_price,
                chefName = chef_name,
                isAffiliate = is_published_affiliate == 1,
                averageRate = avg_rate,
                rateCount = rate_count,
                tripAdvisorAverageRate = trip_advisor_avg_rating,
                tripAdvisorRateCount = trip_advisor_review_count,
                currency = currency,
                menu = createMenu(currency),
                tagHolders = restaurant_tags.map { entry ->
                    TagHolder(
                        entry.value.category_name,
                        entry.value.tag_list.map { it.value.run {
                            Tag(
                                name = tag_name,
                                isVisible = is_displayed_search && is_deleted == 0
                            )
                        } }
                    )
                }
            )
        }
    }

    private fun RestaurantData.createMenu(currency: Currency): Menu {
        return Menu(
            starters = listOfNotNull(
                createDish(card_start_1, price_card_start_1, currency),
                createDish(card_start_2, price_card_start_2, currency),
                createDish(card_start_3, price_card_start_3, currency)
            ),
            mains = listOfNotNull(
                createDish(card_main_1, price_card_main_1, currency),
                createDish(card_main_2, price_card_main_2, currency),
                createDish(card_main_3, price_card_main_3, currency)
            ),
            desserts = listOfNotNull(
                createDish(card_dessert_1, price_card_dessert_1, currency),
                createDish(card_dessert_2, price_card_dessert_2, currency),
                createDish(card_dessert_3, price_card_dessert_3, currency)
            )
        )
    }

    private fun createDish(name: String?, price: Double?, currency: Currency): Dish? {
        return name?.run {
            Dish(this, price, currency)
        }
    }
}