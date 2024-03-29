package com.fudex.project2.data.responses

import com.google.gson.annotations.SerializedName


data class CloseApproachData(
    @SerializedName("close_approach_date") var closeApproachDate: String? = null,
    @SerializedName("close_approach_date_full") var closeApproachDateFull: String? = null,
    @SerializedName("epoch_date_close_approach") var epochDateCloseApproach: Long? = null,
    @SerializedName("relative_velocity") var relativeVelocity: RelativeVelocity? = null,
    @SerializedName("miss_distance") var missDistance: MissDistance? = null,
    @SerializedName("orbiting_body") var orbitingBody: String? = null
)