package com.burhan.common.domain.model

import com.burhan.common.data.remote.model.BitCoinDTO

data class BitCoinPrice(val price: String) {
    companion object
}

fun BitCoinPrice.Companion.fromDTO(dto: BitCoinDTO) =
    BitCoinPrice(price = "${dto.USD.rate} ${dto.USD.code} - ${dto.EUR.rate} ${dto.EUR.code} - ${dto.GBP.rate} ${dto.GBP.code}")