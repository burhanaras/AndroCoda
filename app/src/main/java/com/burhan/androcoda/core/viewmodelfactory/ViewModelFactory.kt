package com.burhan.androcoda.core.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.burhan.androcoda.app.AndroCodaApp
import com.burhan.androcoda.ui.MainViewModel
import com.burhan.androcoda.ui.dashboard.DashboardViewModel
import com.burhan.androcoda.ui.home.HomeViewModel
import com.burhan.androcoda.ui.notifications.NotificationsViewModel
import com.burhan.common.data.repository.IRepository
import com.burhan.common.domain.usecase.DownloadBitcoinPriceUseCase
import com.burhan.common.domain.usecase.SaveBitCoinPriceUseCase

class ViewModelFactory(private val repository: IRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) -> {
                    MainViewModel(AndroCodaApp.instance)
                }
                isAssignableFrom(HomeViewModel::class.java) -> {
                    HomeViewModel(
                        DownloadBitcoinPriceUseCase(
                            repository,
                            SaveBitCoinPriceUseCase(repository)
                        )
                    )
                }
                isAssignableFrom(DashboardViewModel::class.java) -> {
                    DashboardViewModel()
                }
                isAssignableFrom(NotificationsViewModel::class.java) -> {
                    NotificationsViewModel()
                }
                else -> throw IllegalStateException("You have to define ${modelClass.name} class in ViewModelFactory")
            }
        } as T
}