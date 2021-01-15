package com.burhan.common.data.remote.model

import androidx.annotation.Keep

@Keep
data class BitCoinDTO(
    var USD: Exchange = Exchange(),
    var GBP: Exchange = Exchange(),
    var EUR: Exchange = Exchange()
)