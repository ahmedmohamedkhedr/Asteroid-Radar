package com.fudex.project2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fudex.project2.data.dao.AppDao
import com.fudex.project2.data.entities.EntityModel


@Database(entities = [EntityModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDAO(): AppDao
}