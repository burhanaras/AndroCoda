package com.burhan.common.domain.usecase

import com.burhan.common.data.remote.dummy.DummyData
import com.burhan.common.data.repository.IRepository
import com.burhan.common.data.repository.Result
import com.nhaarman.mockitokotlin2.any
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import java.net.ConnectException

@ExperimentalCoroutinesApi
class DownloadBitcoinPriceUseCaseTest {

    // Class under test
    private lateinit var downloadBitcoinPriceUseCase: DownloadBitcoinPriceUseCase

    private lateinit var saveBitCoinPriceUseCase: SaveBitCoinPriceUseCase
    private lateinit var repository: IRepository

    @Before
    fun setUp() {
        repository = Mockito.mock(IRepository::class.java)
        saveBitCoinPriceUseCase = SaveBitCoinPriceUseCase(repository)

        downloadBitcoinPriceUseCase = DownloadBitcoinPriceUseCase(
            repository = repository,
            saveBitCoinPriceUseCase = saveBitCoinPriceUseCase,
            appData = AndroCodaApp.instance.appData
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun download_should_return_bitcoin_price() = runBlockingTest {
        // Given: that we have a repository that returns dummy bitcoin price
        Mockito.`when`(repository.downloadBitCoinPrice())
            .thenReturn(Result.Success(DummyData.dummyBitCoinPrice()))

        Mockito.`when`(repository.saveBitCoinPrice(any()))
            .thenReturn(Unit)

        // When: get bitcoin price
        val result = downloadBitcoinPriceUseCase.download()

        // Then: result must be equal to dummy bitcoin price
        assertTrue(result is Result.Success)

        val dummy = DummyData.dummyBitCoinPrice()
        val expected =
            "${dummy.USD.rate} ${dummy.USD.code} - ${dummy.EUR.rate} ${dummy.EUR.code} - ${dummy.GBP.rate} ${dummy.GBP.code}"
        val actual = (result as Result.Success).data.price
        assertEquals(expected, actual)
    }

    @Test
    fun download_should_return_error_when_there_is_no_network() = runBlockingTest {
        // Given: we have a repository with no network
        Mockito.`when`(repository.downloadBitCoinPrice())
            .thenReturn(Result.Error(ConnectException()))

        // When: get bitcoin price
        val result = downloadBitcoinPriceUseCase.download()

        // Then: result must be Error and result data should be ConnectException
        assertTrue(result is Result.Error)
        assertTrue((result as Result.Error).exception is ConnectException)
    }

}