package com.burhan.androcoda.core.extension

import androidx.fragment.app.Fragment
import com.burhan.androcoda.app.AndroCodaApp
import com.burhan.androcoda.core.viewmodelfactory.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as AndroCodaApp).repository
    return ViewModelFactory(repository)
}