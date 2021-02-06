package com.burhan.common.domain.usecase

import com.burhan.common.data.remote.dummy.DummyData
import com.burhan.common.data.repository.IRepository
import com.burhan.common.domain.model.BitCoinPrice
import com.burhan.common.domain.model.toEntity
import com.nhaarman.mockitokotlin2.any
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class SaveBitCoinPriceUseCaseTest {

    // Class under test
    private lateinit var saveBitCoinPriceUseCase: SaveBitCoinPriceUseCase

    private lateinit var repository: IRepository

    @Before
    fun setUp() {
        repository = Mockito.mock(IRepository::class.java)
        saveBitCoinPriceUseCase = SaveBitCoinPriceUseCase(repository)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun save_should_save_bitcoin_price() = runBlockingTest {
        // Given: that we have a repository and a bitcoin price
        Mockito.`when`(repository.saveBitCoinPrice(any()))
            .thenReturn(Unit)

        // When: save bitcoin price
        val entity = BitCoinPrice.toEntity(DummyData.dummyBitCoinPrice())
        saveBitCoinPriceUseCase.save(entity)

        // Then: be sure result is success
        Mockito.verify(repository).saveBitCoinPrice(entity)
    }
}