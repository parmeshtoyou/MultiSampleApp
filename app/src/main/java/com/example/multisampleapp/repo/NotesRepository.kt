package com.example.multisampleapp.repo

import com.example.multisampleapp.db.AppDatabase

object NotesRepository {
    fun getNotesList() = AppDatabase.getDatabase()?.notesDao()?.getAll()
}