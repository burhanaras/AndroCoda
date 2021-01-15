package com.burhan.common.data.remote.model

import androidx.annotation.Keep

@Keep
data class Time(
    var updated: String = "",
    var updatedISO: String = "",
    var updateduk: String = ""
)