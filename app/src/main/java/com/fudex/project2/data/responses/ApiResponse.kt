package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("links") var links: Links? = null,
    @SerializedName("element_count") var elementCount: Int? = null,
    @SerializedName("near_earth_objects") var nearEarthObjects: Map<String, ArrayList<DayResponse>>? = null
)
