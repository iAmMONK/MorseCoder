package com.programming.monk.morsecodetranslator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programming.monk.morsecodetranslator.operations.MorseCoder
import kotlinx.coroutines.launch

class MainActivityViewModel(private val coder: MorseCoder) : ViewModel() {

    val output: LiveData<String> get() = _output
    val outputHasSpacing: LiveData<Boolean> get() = _outputHasSpacing

    private val _output: MutableLiveData<String> = MutableLiveData()
    private val _outputHasSpacing: MutableLiveData<Boolean> = MutableLiveData(true)

    private var mode = true // true = encode, false = decode

    fun onInputTextChanged(text: String) {
        createOutput(text)
    }

    fun onModeSwitched(text: String) {
        mode = !mode
        createOutput(text)
        _outputHasSpacing.value = mode
    }

    private fun createOutput(text: String) {
        viewModelScope.launch {
            _output.value = if (mode) coder.encode(text) else coder.decode(text)
        }
    }
}