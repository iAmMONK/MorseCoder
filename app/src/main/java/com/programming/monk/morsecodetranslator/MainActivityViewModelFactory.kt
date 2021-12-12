package com.programming.monk.morsecodetranslator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.programming.monk.morsecodetranslator.operations.MorseCoder

class MainActivityViewModelFactory: ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = MainActivityViewModel(MorseCoder()) as T
}