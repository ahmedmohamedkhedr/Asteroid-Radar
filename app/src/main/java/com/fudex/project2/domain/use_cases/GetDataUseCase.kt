package com.fudex.project2.domain.use_cases

import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import com.fudex.project2.domain.models.DataModel
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val dbRepository: DbRepository
) {
    suspend operator fun invoke(): MutableList<DataModel> {
        val data = dbRepository.getAllData().map { it.toDataModel() }.toMutableList()

        if (data.isEmpty()) {
            remoteRepository.getData().nearEarthObjects?.values?.forEach { list ->
                data.addAll(dbRepository.addData(list.map { it.toEntityModel() }.toMutableList())
                    .map { it.toDataModel() }.toMutableList()
                )
            }
        }
        return data
    }
}