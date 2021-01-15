package com.burhan.common.data.remote.model

import androidx.annotation.Keep

@Keep
data class Exchange(
    var code: String = "",
    var symbol: String = "",
    var rate: String = "",
    var description: String = "",
    var rate_float: Double = 0.0
)