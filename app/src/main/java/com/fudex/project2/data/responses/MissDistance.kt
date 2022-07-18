package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class MissDistance(
    @SerializedName("astronomical") var astronomical: String? = null,
    @SerializedName("lunar") var lunar: String? = null,
    @SerializedName("kilometers") var kilometers: String? = null,
    @SerializedName("miles") var miles: String? = null
)