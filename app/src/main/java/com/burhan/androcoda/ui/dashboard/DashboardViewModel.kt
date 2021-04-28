package com.burhan.androcoda.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "We, developers have wasted many years looking for the best architecture; but only a few of us were lucky enough to realize that there is no perfect architecture for every kind of application. Today, we present you AndroCoda: the best architecture for Android apps"
    }
    val text: LiveData<String> = _text
}