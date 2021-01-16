package com.burhan.common.domain.usecase

import com.burhan.common.data.local.entity.BitCoinEntity
import com.burhan.common.data.repository.IRepository

class SaveBitCoinPriceUseCase(private val repository: IRepository) {

    suspend fun save(bitCoinEntity: BitCoinEntity) {
        repository.saveBitCoinPrice(bitCoinEntity)
    }
}