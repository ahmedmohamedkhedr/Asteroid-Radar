package com.fudex.project2.data.repositories

import com.fudex.project2.BuildConfig
import com.fudex.project2.data.errors.ApiError
import com.fudex.project2.data.remote.ApiService
import com.fudex.project2.data.responses.ApiResponse
import com.fudex.project2.data.responses.ImageOfDayResponse
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import com.fudex.project2.utils.Utils

class RemoteRepositoryImp(private val apiService: ApiService) : RemoteRepository {

    override suspend fun getData(): ApiResponse {
        val endDate = Utils.getEndDate()
        val response =
            apiService.getData(Utils.getStartDate(), endDate, BuildConfig.API_KEY)
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        } else {
            throw ApiError("An error happened")
        }
    }

    override suspend fun getImageOfTheDay(): ImageOfDayResponse {
        val response =
            apiService.getImageOfTheDay(BuildConfig.API_KEY)
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        } else {
            throw ApiError("An error happened")
        }
    }

}