package com.fudex.project2.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun getStartDate(): String {
        return SimpleDateFormat("yyyy-MM-dd").format(Date())
    }

    fun getEndDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, +7)
        val nextWeekDateDate = calendar.time
        return SimpleDateFormat("yyyy-MM-dd").format(nextWeekDateDate)
    }
}