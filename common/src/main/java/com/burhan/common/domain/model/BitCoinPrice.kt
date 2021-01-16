package com.burhan.common.domain.model

import com.burhan.common.data.local.entity.BitCoinEntity
import com.burhan.common.data.remote.model.BitCoinDTO

data class BitCoinPrice(val price: String) {
    companion object
}

fun BitCoinPrice.Companion.fromDTO(dto: BitCoinDTO) =
    BitCoinPrice(price = "${dto.USD.rate} ${dto.USD.code} - ${dto.EUR.rate} ${dto.EUR.code} - ${dto.GBP.rate} ${dto.GBP.code}")

fun BitCoinPrice.Companion.toEntity(dto: BitCoinDTO): BitCoinEntity =
    BitCoinEntity(
        time = System.currentTimeMillis(),
        usdRate = dto.USD.rate, usdCode = dto.USD.code,
        eurRate = dto.EUR.rate, eurCode = dto.EUR.code,
        gbpRate = dto.GBP.rate, gbpCode = dto.GBP.code
    )