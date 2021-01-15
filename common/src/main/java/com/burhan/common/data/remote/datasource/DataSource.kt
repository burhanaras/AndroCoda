package com.burhan.common.data.remote.datasource

import com.burhan.common.data.remote.dummy.DummyData
import com.burhan.common.data.remote.model.BitCoinDTO
import com.burhan.common.data.repository.Result

class DataSource: IDataSource {
    override suspend fun downloadBitCoinPrice(): Result<BitCoinDTO> {
        return Result.Success(DummyData.dummyBitCoinPrice())
    }
}