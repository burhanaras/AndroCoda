package com.burhan.androcoda.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burhan.common.data.repository.Result
import com.burhan.common.domain.usecase.DownloadBitcoinPriceUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val downloadBitcoinPriceUseCase: DownloadBitcoinPriceUseCase
) : ViewModel() {

    internal val bitCoinPrice: MutableLiveData<String> = MutableLiveData()

    fun loadData() {
        viewModelScope.launch {
            when (val result = downloadBitcoinPriceUseCase.download()) {
                is Result.Success -> {
                    bitCoinPrice.postValue(result.data.price)
                }
                is Result.Error -> {
                    bitCoinPrice.postValue(result.exception.message)
                }
            }
        }
    }
}