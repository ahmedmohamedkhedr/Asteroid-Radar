package com.fudex.project2.domain.models

import java.io.Serializable

data class DataModel(
    val id: String,
    val name: String,
    val date: String,
    val absoluteMagnitude: Double,
    val estimatedDiameterMax: Double,
    val isPotentiallyHazardousAsteroid: Boolean,
    val kilometersPerSecond: String,
    val astronomical: String
) : Serializable
