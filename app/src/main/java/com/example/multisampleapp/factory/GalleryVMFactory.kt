package com.example.multisampleapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multisampleapp.ui.gallery.GalleryViewModel
import java.lang.IllegalArgumentException

class GalleryVMFactory(private val someValue: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(someValue = someValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}