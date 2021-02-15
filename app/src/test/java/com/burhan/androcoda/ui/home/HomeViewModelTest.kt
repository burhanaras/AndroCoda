package com.burhan.androcoda.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.burhan.androcoda.MainCoroutineRule
import com.burhan.androcoda.getOrAwaitValueTest
import com.burhan.common.data.remote.dummy.DummyData
import com.burhan.common.data.repository.IRepository
import com.burhan.common.data.repository.Result
import com.burhan.common.domain.model.BitCoinPrice
import com.burhan.common.domain.model.fromDTO
import com.burhan.common.domain.usecase.DownloadBitcoinPriceUseCase
import com.burhan.common.domain.usecase.SaveBitCoinPriceUseCase
import com.nhaarman.mockitokotlin2.any
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import java.lang.Exception

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Class under test
    private lateinit var viewModel: HomeViewModel

    private lateinit var repository: IRepository
    private lateinit var downloadBitcoinPriceUseCase: DownloadBitcoinPriceUseCase
    private lateinit var saveBitCoinPriceUseCase: SaveBitCoinPriceUseCase


    @Before
    fun setUp() {
        repository = Mockito.mock(IRepository::class.java)
        saveBitCoinPriceUseCase = SaveBitCoinPriceUseCase(repository)
        downloadBitcoinPriceUseCase =
            DownloadBitcoinPriceUseCase(repository, saveBitCoinPriceUseCase)

        viewModel = HomeViewModel(downloadBitcoinPriceUseCase)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `viewModel's bitCoinPrice liveData must be a price string when loadData is called `() =
        runBlockingTest {

            // Given: that we have a repository that returns successful data
            Mockito.`when`(repository.downloadBitCoinPrice())
                .thenReturn(Result.Success(DummyData.dummyBitCoinPrice()))

            Mockito.`when`(repository.saveBitCoinPrice(any()))
                .thenReturn(Unit)

            // When: loadData() is triggered
            viewModel.loadData()

            // Then: be sure that bitCoinPrice liveData is a valid string
            val actual = viewModel.bitCoinPrice.getOrAwaitValueTest()
            val expected = "38,471.0783 USD - 31,702.7076 EUR - 28,158.1364 GBP"
            assertEquals(expected, actual)

        }

    @Test
    fun `viewModel's bitCoinPrice liveData must be an exception message when useCase returns an error`() =
        runBlockingTest {
            // Given: that we have a repository that returns an exception
            val exception = Exception("This is the exception message.")
            Mockito.`when`(repository.downloadBitCoinPrice())
                .thenReturn(Result.Error(exception))

            // When: loadData() is triggered
            viewModel.loadData()

            // Then:
            val actual = viewModel.bitCoinPrice.getOrAwaitValueTest()
            val expected = exception.message
            assertEquals(expected, actual)
        }

}