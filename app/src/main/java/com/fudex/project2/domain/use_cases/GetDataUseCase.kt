package com.fudex.project2.domain.use_cases

import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import com.fudex.project2.domain.models.DataModel
import com.fudex.project2.utils.Utils
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val dbRepository: DbRepository
) {
    suspend operator fun invoke(): MutableList<DataModel> {
        val data = dbRepository.getAllData().map { it.toDataModel() }.toMutableList()
        return data.ifEmpty {
            remoteRepository.getData().nearEarthObjects?.get(Utils.getCurrentDate())?.map {
                it.toDataModel()
            }?.toMutableList() ?: mutableListOf()
        }
    }

}