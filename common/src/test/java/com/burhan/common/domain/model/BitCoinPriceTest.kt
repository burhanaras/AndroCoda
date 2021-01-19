package com.burhan.common.domain.model

import com.burhan.common.data.remote.dummy.DummyData
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BitCoinPriceTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun fromDTO() {
        // Given: that we have a BitcoinDTO object
        val bitCoinDTO = DummyData.dummyBitCoinPrice()
        val expected =
            "${bitCoinDTO.USD.rate} ${bitCoinDTO.USD.code} - ${bitCoinDTO.EUR.rate} ${bitCoinDTO.EUR.code} - ${bitCoinDTO.GBP.rate} ${bitCoinDTO.GBP.code}"

        // When: convert DTO to Model
        val bitCoinPrice = BitCoinPrice.fromDTO(bitCoinDTO)

        // Then: Price field must be equal
        Assert.assertEquals(expected, bitCoinPrice.price)
    }

    @Test
    fun toEntity() {
        // Given: that we have have a BitcoinDTO
        val bitCoinDTO = DummyData.dummyBitCoinPrice()

        // When: convert DTO to Entity
        val bitCoinEntity = BitCoinPrice.toEntity(bitCoinDTO)

        // Then: Ensure that fields are the same
        Assert.assertEquals(bitCoinDTO.GBP.rate, bitCoinEntity.gbpRate)
        Assert.assertEquals(bitCoinDTO.GBP.code, bitCoinEntity.gbpCode)
        Assert.assertEquals(bitCoinDTO.EUR.rate, bitCoinEntity.eurRate)
        Assert.assertEquals(bitCoinDTO.EUR.code, bitCoinEntity.eurCode)
        Assert.assertEquals(bitCoinDTO.USD.rate, bitCoinEntity.usdRate)
        Assert.assertEquals(bitCoinDTO.USD.code, bitCoinEntity.usdCode)
    }
}