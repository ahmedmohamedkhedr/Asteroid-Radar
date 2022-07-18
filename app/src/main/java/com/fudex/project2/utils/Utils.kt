package com.fudex.project2.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun getCurrentDate(): String {
        return SimpleDateFormat("yyyy-MM-dd").format(Date())
    }
}