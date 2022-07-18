package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class Links (
  @SerializedName("self") var self : String? = null
)