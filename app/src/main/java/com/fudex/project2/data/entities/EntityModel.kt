package com.fudex.project2.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fudex.project2.domain.models.DataModel
import com.fudex.project2.utils.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class EntityModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "absoluteMagnitude")
    val absoluteMagnitude: Double,
    @ColumnInfo(name = "estimatedDiameterMax")
    val estimatedDiameterMax: Double,
    @ColumnInfo(name = "isPotentiallyHazardousAsteroid")
    val isPotentiallyHazardousAsteroid: Boolean,
    @ColumnInfo(name = "kilometersPerSecond")
    val kilometersPerSecond: String,
    @ColumnInfo(name = "astronomical")
    val astronomical: String
) {
    fun toDataModel() = DataModel(
        uid.toString(),
        name,
        date,
        absoluteMagnitude,
        estimatedDiameterMax,
        isPotentiallyHazardousAsteroid,
        kilometersPerSecond,
        astronomical
    )
}