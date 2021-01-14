package com.burhan.common.data.remote.model

data class BitCoinDTO(
    var USD: Exchange = Exchange(),
    var GBP: Exchange = Exchange(),
    var EUR: Exchange = Exchange()
)