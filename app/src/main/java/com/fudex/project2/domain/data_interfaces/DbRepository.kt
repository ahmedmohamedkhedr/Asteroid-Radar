package com.fudex.project2.domain.data_interfaces

import com.fudex.project2.data.entities.EntityModel

interface DbRepository {
    suspend fun swapData(data: MutableList<EntityModel>)
    suspend fun getAllData(): MutableList<EntityModel>
}