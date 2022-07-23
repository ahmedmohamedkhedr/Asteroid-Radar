package com.fudex.project2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fudex.project2.data.entities.EntityModel
import com.fudex.project2.utils.Constants

@Dao
interface AppDao {
    @Query("SELECT * FROM ${Constants.TABLE_NAME} ORDER BY Date(date)")
    suspend fun getAllData(): MutableList<EntityModel>

    @Insert
    suspend fun insertAll(data: MutableList<EntityModel>)

    @Query("DELETE FROM ${Constants.TABLE_NAME} WHERE Date(date) < Date()")
    suspend fun deleteAll()
}