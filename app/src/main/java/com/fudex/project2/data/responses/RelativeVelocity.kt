package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class RelativeVelocity(
    @SerializedName("kilometers_per_second") var kilometersPerSecond: String? = null,
    @SerializedName("kilometers_per_hour") var kilometersPerHour: String? = null,
    @SerializedName("miles_per_hour") var milesPerHour: String? = null
)