package com.fudex.project2.domain.use_cases

import com.fudex.project2.domain.data_interfaces.RemoteRepository

class GetImageOfDayUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke() = remoteRepository.getImageOfTheDay().url
}