package com.burhan.common.data.repository

import com.burhan.common.data.local.datasource.ILocalDataSource
import com.burhan.common.data.remote.datasource.IRemoteDataSource
import com.burhan.common.data.remote.datasource.RemoteDataSource
import com.burhan.common.data.remote.dummy.DummyData
import com.burhan.common.domain.model.BitCoinPrice
import com.burhan.common.domain.model.toEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import java.lang.Exception
import java.net.ConnectException

@ExperimentalCoroutinesApi
class RepositoryTest {

    private lateinit var remoteDataSource: IRemoteDataSource
    private lateinit var localDataSource: ILocalDataSource

    // class under test
    private lateinit var repository: IRepository

    @Before
    fun setUp() {
        remoteDataSource = Mockito.mock(IRemoteDataSource::class.java)
        localDataSource = Mockito.mock(ILocalDataSource::class.java)
        repository =
            Repository(remoteDataSource = remoteDataSource, localDataSource = localDataSource)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun downloadBitCoinPrice_should_return_bitcoin_price() = runBlockingTest {
        // Given:  a remote data source with bitcoin data
        Mockito.`when`(remoteDataSource.downloadBitCoinPrice())
            .thenReturn(Result.Success(DummyData.dummyBitCoinPrice()))

        // When:  get bitcoin price
        val result = repository.downloadBitCoinPrice()

        // Then: result must be successful and data should be equal to provided dummy data
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.USD.rate == DummyData.dummyBitCoinPrice().USD.rate)
        assertTrue(result.data.USD.rate == DummyData.dummyBitCoinPrice().USD.rate)
        assertTrue(result.data.USD.code == DummyData.dummyBitCoinPrice().USD.code)
        assertTrue(result.data.EUR.rate == DummyData.dummyBitCoinPrice().EUR.rate)
        assertTrue(result.data.EUR.code == DummyData.dummyBitCoinPrice().EUR.code)
        assertTrue(result.data.GBP.rate == DummyData.dummyBitCoinPrice().GBP.rate)
        assertTrue(result.data.GBP.code == DummyData.dummyBitCoinPrice().GBP.code)
    }

    @Test
    fun downloadBitCoinPrice_should_return_network_error_when_there_is_no_network() =
        runBlockingTest {
            // Given: a remote data source with no network
            Mockito.`when`(remoteDataSource.downloadBitCoinPrice())
                .thenReturn(Result.Error(ConnectException()))

            // When: get bitcoin price
            val result = repository.downloadBitCoinPrice()

            // Then: result must be error
            assertTrue(result is Result.Error)
            assertTrue((result as Result.Error).exception is ConnectException)
        }

    @Test
    fun saveBitCoinPrice() = runBlockingTest {
        // Given: an entity object
        val entity = BitCoinPrice.toEntity(DummyData.dummyBitCoinPrice())

        // When: call saveBitcoinPrice() method
        repository.saveBitCoinPrice(entity)

        //Then: verify, localDataSource's save() is called with same entity
        Mockito.verify(localDataSource).save(entity)

    }
}