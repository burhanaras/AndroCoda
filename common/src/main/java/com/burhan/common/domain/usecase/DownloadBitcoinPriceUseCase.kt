package com.burhan.common.domain.usecase

import com.burhan.common.data.repository.Result
import com.burhan.common.domain.model.BitCoinPrice

class DownloadBitcoinPriceUseCase {

    suspend fun download(): Result<BitCoinPrice> {
        val dummyPrice = BitCoinPrice("This is a dummy price")
        return Result.Success(dummyPrice)
    }
}