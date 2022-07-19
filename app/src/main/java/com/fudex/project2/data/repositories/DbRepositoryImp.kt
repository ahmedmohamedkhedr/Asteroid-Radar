package com.fudex.project2.data.repositories

import com.fudex.project2.data.dao.AppDao
import com.fudex.project2.data.entities.EntityModel
import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.models.DataModel

class DbRepositoryImp(private val dao: AppDao) : DbRepository {

    override suspend fun addData(data: MutableList<EntityModel>): MutableList<EntityModel> {
        dao.insertAll(data)
        return data
    }

    override suspend fun getAllData(): MutableList<EntityModel> {
        return dao.getAllData()
    }

    override suspend fun clearAll() {
        dao.deleteAll()
    }
}