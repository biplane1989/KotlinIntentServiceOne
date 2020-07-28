package com.example.kotlinintentserviceone

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import java.lang.Exception

class MyService : IntentService(MyService::class.java.canonicalName) {

    private var handler = Handler()

    companion object {
        private val TAG = MyService::class.java.canonicalName
        const val CODE = "Orange"
        const val CASHBACK_INFO = "cashbach_info"
    }

    override fun onHandleIntent(intent: Intent?) {
        val maxCount = intent?.getIntExtra(CODE, -1)
        val intent: Intent = Intent(this, MainActivity.Recever::class.java)
        intent.putExtra(CODE, "orange")
        try {
            Thread.sleep(5000)
            sendBroadcast(intent)
            Log.d(TAG, "Sleep")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreate() {
        super.onCreate()
        handler.post {
            Log.d(TAG, "start")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "stop")
    }

}