package com.example.multisampleapp.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GalleryViewModel(private val someValue: Int) : ViewModel() {

    private val _text = MutableStateFlow("Loading")
    val text: StateFlow<String> = _text

    fun setSomeValue(name: String) {
        viewModelScope.launch {
            _text.emit("$name and $someValue")
        }
    }
}