package com.example.multisampleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multisampleapp.model.Note
import com.example.multisampleapp.repo.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel: ViewModel() {
    private var mutableNotesLiveData = MutableLiveData<List<Note>>()

    val notesLiveData: LiveData<List<Note>>
        get() = mutableNotesLiveData

    fun getNotesList() {
        viewModelScope.launch(Dispatchers.IO) {
            mutableNotesLiveData.postValue(NotesRepository.getNotesList())
        }
    }
}