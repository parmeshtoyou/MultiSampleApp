package com.example.multisampleapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
        @PrimaryKey @ColumnInfo(name = "id") val noteId: Int, val title: String, val description: String)
