package com.example.multisampleapp.dao

import androidx.room.*
import com.example.multisampleapp.model.Note

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAll(): List<Note>

    @Query("SELECT * FROM notes where id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<Note>

    @Query("SELECT * FROM notes where id=(:noteId)")
    fun findNoteById(noteId: Int): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg note: Note)

    @Delete
    fun delete(user: Note)
}