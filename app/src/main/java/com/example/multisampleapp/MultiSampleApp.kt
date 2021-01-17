package com.example.multisampleapp

import android.app.Application
import com.example.multisampleapp.db.AppDatabase

class MultiSampleApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.getInstance(applicationContext)
    }
}