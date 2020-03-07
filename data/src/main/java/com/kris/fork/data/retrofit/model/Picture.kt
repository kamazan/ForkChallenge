package com.kris.fork.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("612x344") val url: String,
    val label: String
)