package com.kris.fork.domain.entity

import java.util.*

data class Restaurant(
    val name: String,
    val diaporamaPictures: List<Picture>? = null,
    val speciality: String? = null,
    val cardPrice: Int? = null,
    val chefName: String? = null,
    val isAffiliate: Boolean?,
    val averageRate: Double? = null,
    val rateCount: Int? = null,
    val tripAdvisorAverageRate: Double? = null,
    val tripAdvisorRateCount: Int? = null,
    val currency: Currency,
    val menu: Menu? = null,
    val tagHolders: List<TagHolder>? = null
) {

    companion object {
        private const val TRIP_ADVISOR_IMAGE_URL_PREFIX = "https://www.tripadvisor.com/img/cdsi/img2/ratings/traveler/"
        private const val TRIP_ADVISOR_IMAGE_URL_SUFFIX = "-MCID-5.png"
    }

    val visibleTagHolders: List<TagHolder>?
        get() {
            return tagHolders?.filter { it.tagsList.any { tag -> tag.isVisible } }
        }

    val tripAdvisorRateImageUrl: String?
        get() {
            return tripAdvisorAverageRate?.run { String.format(Locale.US, "%1$,.1f", this) }?.run {
                "${TRIP_ADVISOR_IMAGE_URL_PREFIX}${this}${TRIP_ADVISOR_IMAGE_URL_SUFFIX}"
            }
        }
}