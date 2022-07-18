package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName

data class ImageOfDayResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val hdUrl: String,
    @SerializedName("media_type")
    val media_type: String,
    @SerializedName("service_version")
    val service_version: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)