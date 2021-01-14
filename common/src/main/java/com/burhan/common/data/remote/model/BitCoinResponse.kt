package com.burhan.common.data.remote.model

data class BitCoinResponse(
    var time: Time = Time(),
    var disclaimer: String = "",
    var chartName: String = "",
    var bpi: Bpi = Bpi()
)