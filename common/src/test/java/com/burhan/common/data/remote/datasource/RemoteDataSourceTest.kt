package com.burhan.common.data.remote.datasource

import com.burhan.common.data.remote.api.ApiService
import com.burhan.common.data.remote.dummy.DummyData
import com.burhan.common.data.remote.model.BitCoinResponse
import com.burhan.common.data.repository.Result
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class RemoteDataSourceTest {

    // Class under test
    private lateinit var remoteDataSource: IRemoteDataSource


    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun downloadBitCoinPrice() = runBlockingTest {
        // Given: an apiService that returns
        val api = mock<ApiService> {
            onBlocking { downloadBitCoinPriceAsync() } doReturn
                    Response.success(DummyData.dummyBitCoinResponse()).toDeferred()
        }
        remoteDataSource = RemoteDataSource(api)

        // When: call downloadBitcoinResponse
        val result = remoteDataSource.downloadBitCoinPrice()

        // Then: Result must be success
        assertTrue(result is Result.Success)
    }

    @Test
    fun downloadBitCoinPrice_should_fail_when_apiService_fails() = runBlockingTest {
        // Given: an apiService that returns

        val api = mock<ApiService> {
            onBlocking { downloadBitCoinPriceAsync() } doReturn
                    Response.error<BitCoinResponse>(
                        500,
                        ResponseBody.Companion.create("application/json".toMediaType(), "")
                    ).toDeferred()
        }
        remoteDataSource = RemoteDataSource(api)

        // When: call downloadBitcoinResponse
        val result = remoteDataSource.downloadBitCoinPrice()

        // Then: Result must be success
        assertTrue(result is Result.Error)
    }
}

fun <T> T.toDeferred() = GlobalScope.async { this@toDeferred }