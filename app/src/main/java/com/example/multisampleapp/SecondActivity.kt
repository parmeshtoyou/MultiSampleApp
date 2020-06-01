package com.example.multisampleapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.multisampleapp.viewmodel.CommunicatorViewModel
import com.example.multisampleapp.viewmodel.MyViewModelFactory

class SecondActivity: AppCompatActivity() {

    lateinit var communicatorViewModel: CommunicatorViewModel
    private val viewModelFactory = MyViewModelFactory.getFactoryInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity_layout)

        communicatorViewModel = ViewModelProvider(this, viewModelFactory)[CommunicatorViewModel::class.java]
        Log.d(TAG, "onCreate:$communicatorViewModel")
    }

    fun onButtonClick(view: View) {
        //Log.d(TAG, "onButtonClick: $callBack")
        //callBack.onButtonClick()
        communicatorViewModel.setData("Parmesh")
    }

    companion object {
        private val TAG = SecondActivity::class.java.simpleName
    }

}