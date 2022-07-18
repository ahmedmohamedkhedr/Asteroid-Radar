package com.fudex.project2.data.responses

import com.fudex.project2.data.entities.EntityModel
import com.fudex.project2.domain.models.DataModel
import com.google.gson.annotations.SerializedName


data class DayResponse(
    @SerializedName("links")
    var links: Links? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("neo_reference_id")
    var neoReferenceId: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("nasa_jpl_url")
    var nasaJplUrl: String? = null,
    @SerializedName("absolute_magnitude_h")
    var absoluteMagnitudeH: Double? = null,
    @SerializedName("estimated_diameter")
    var estimatedDiameter: EstimatedDiameter? = null,
    @SerializedName("is_potentially_hazardous_asteroid")
    var isPotentiallyHazardousAsteroid: Boolean? = null,
    @SerializedName("close_approach_data")
    var closeApproachData: ArrayList<CloseApproachData> = arrayListOf(),
    @SerializedName("is_sentry_object")
    var isSentryObject: Boolean? = null
) {
    fun toDataModel() = DataModel(
        id = id ?: "",
        name = name ?: "",
        date = closeApproachData.firstOrNull()?.closeApproachDate ?: "",
        absoluteMagnitude = absoluteMagnitudeH ?: 0.0,
        estimatedDiameterMax = estimatedDiameter?.kilometers?.estimatedDiameterMax ?: 0.0,
        isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid ?: false,
        kilometersPerSecond = closeApproachData.firstOrNull()?.relativeVelocity?.kilometersPerSecond
            ?: "",
        astronomical = closeApproachData.firstOrNull()?.missDistance?.astronomical ?: ""
    )

    fun toEntityModel() = EntityModel(
        name = name ?: "",
        date = closeApproachData.firstOrNull()?.closeApproachDate ?: "",
        absoluteMagnitude = absoluteMagnitudeH ?: 0.0,
        estimatedDiameterMax = estimatedDiameter?.kilometers?.estimatedDiameterMax ?: 0.0,
        isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid ?: false,
        kilometersPerSecond = closeApproachData.firstOrNull()?.relativeVelocity?.kilometersPerSecond
            ?: "",
        astronomical = closeApproachData.firstOrNull()?.missDistance?.astronomical ?: ""
    )
}