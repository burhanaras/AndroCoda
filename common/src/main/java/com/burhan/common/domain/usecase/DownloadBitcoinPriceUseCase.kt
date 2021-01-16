package com.burhan.common.domain.usecase

import com.burhan.common.data.repository.IRepository
import com.burhan.common.data.repository.Result
import com.burhan.common.domain.model.BitCoinPrice
import com.burhan.common.domain.model.fromDTO
import com.burhan.common.domain.model.toEntity

class DownloadBitcoinPriceUseCase(
    private val repository: IRepository,
    private val saveBitCoinPriceUseCase: SaveBitCoinPriceUseCase
) {

    suspend fun download(): Result<BitCoinPrice> {
        return when (val result = repository.downloadBitCoinPrice()) {
            is Result.Success -> {
                saveBitCoinPriceUseCase.save(BitCoinPrice.toEntity(result.data))
                Result.Success(BitCoinPrice.fromDTO(result.data))
            }
            is Result.Error -> {
                result
            }
        }
    }
}