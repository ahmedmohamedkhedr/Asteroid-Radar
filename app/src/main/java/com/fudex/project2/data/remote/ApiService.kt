package com.fudex.project2.data.remote

import com.fudex.project2.data.responses.ApiResponse
import com.fudex.project2.data.responses.ImageOfDayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("neo/rest/v1/feed")
    suspend fun getData(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String
    ): Response<ApiResponse>

    @GET("planetary/apod")
    suspend fun getImageOfTheDay(
        @Query("api_key") apiKey: String
    ): Response<ImageOfDayResponse>
}