package com.burhan.common.data.remote.model

import androidx.annotation.Keep

@Keep
data class BitCoinResponse(
    var time: Time = Time(),
    var disclaimer: String = "",
    var chartName: String = "",
    var bpi: BitCoinDTO = BitCoinDTO()
)