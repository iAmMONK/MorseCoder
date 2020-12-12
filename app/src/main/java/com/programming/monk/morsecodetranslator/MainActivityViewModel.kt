package com.programming.monk.morsecodetranslator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programming.monk.morsecodetranslator.operations.MorseCoder
import kotlinx.coroutines.launch

class MainActivityViewModel(private val coder: MorseCoder): ViewModel() {

    val output: LiveData<String> get() = _output

    private val _output: MutableLiveData<String> = MutableLiveData()

    fun onInputTextChanged(text: String) {
        viewModelScope.launch {
            _output.value = coder.codeToMorse(text)
        }
    }
}