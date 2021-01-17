package com.example.multisampleapp.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.multisampleapp.db.AppDatabase
import com.example.multisampleapp.model.Note
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class DatabaseWorker(private val context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            val database = AppDatabase.getInstance(context)
            val note = Note(1, "Test1", "This is the test description")
            database.notesDao().insertAll(note)
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}