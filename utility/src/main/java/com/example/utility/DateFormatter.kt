package com.example.utility

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun format(timestamp: Long, pattern: String = "dd MMM yyyy"): String {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

}