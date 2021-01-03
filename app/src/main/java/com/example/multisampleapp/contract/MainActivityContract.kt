package com.example.multisampleapp.contract

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.multisampleapp.MainActivity2

class MainActivityContract : ActivityResultContract<Int, String>() {

    override fun createIntent(input: Int?): Intent {
        return Intent(ACTION).apply {
            putExtra(INPUT_INT, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when(resultCode) {
            Activity.RESULT_OK -> intent?.getStringExtra(OUTPUT_STRING)
            else -> null
        }
    }

    companion object {
        const val ACTION = "com.example.multisampleapp.action.MY_ACTION"
        const val INPUT_INT = "input_int"
        const val OUTPUT_STRING = "output_string"
    }
}