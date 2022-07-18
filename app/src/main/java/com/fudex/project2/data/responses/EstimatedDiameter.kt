package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class EstimatedDiameter(
    @SerializedName("kilometers") var kilometers: Kilometers? = null,
    @SerializedName("meters") var meters: Meters? = null,
    @SerializedName("miles") var miles: Miles? = null,
    @SerializedName("feet") var feet: Feet? = null
)