package com.burhan.common.data.remote.datasource

import com.burhan.common.data.remote.api.ApiService
import com.burhan.common.data.remote.model.BitCoinDTO
import com.burhan.common.data.repository.Result

class RemoteDataSource(private val apiService: ApiService) : IRemoteDataSource {
    override suspend fun downloadBitCoinPrice(): Result<BitCoinDTO> {
        try {
            val response = apiService.downloadBitCoinPriceAsync().await()
            when {
                response.isSuccessful -> {
                    response.body()?.let {
                        return Result.Success(it.bpi)
                    } ?: run {
                        return Result.Error(java.lang.Exception())
                    }
                }
                else -> {
                    return Result.Error(java.lang.Exception(response.errorBody().toString()))
                }
            }
        } catch (e: Exception) {
            return Result.Error(java.lang.Exception())
        }
    }
}