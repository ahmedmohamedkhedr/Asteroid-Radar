package com.fudex.project2.domain.data_interfaces

import com.fudex.project2.data.responses.ApiResponse
import com.fudex.project2.data.responses.ImageOfDayResponse

interface RemoteRepository {
    suspend fun getData(): ApiResponse
    suspend fun getImageOfTheDay():ImageOfDayResponse
}