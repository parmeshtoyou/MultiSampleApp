package com.example.multisampleapp.model

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.multisampleapp.repository.SomeRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SimpleModel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr){

    @Inject
    lateinit var repository: SomeRepository

    fun getData() = repository.loadData().toString()

}