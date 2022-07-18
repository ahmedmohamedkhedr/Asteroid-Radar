package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class Feet(
    @SerializedName("estimated_diameter_min") var estimatedDiameterMin: Double? = null,
    @SerializedName("estimated_diameter_max") var estimatedDiameterMax: Double? = null
)