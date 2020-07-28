package com.example.kotlinintentserviceone

import android.app.IntentService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var isRecever: Recever

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerCashbackReceiver()

        tv_Start.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MyService::class.java)
            intent.putExtra(MyService.CODE, 100)
            this.startService(intent)
        })

        tv_Stop.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        })


    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(isRecever)
    }

    fun registerCashbackReceiver() {
        isRecever = Recever()
        val intentFillter = IntentFilter()
        intentFillter.addAction(MyService.CASHBACK_INFO)
        registerReceiver(isRecever, intentFillter)
    }


    class Recever : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let {
                val code: String = intent.getStringExtra(MyService.CODE)
                Log.d("001", "orange")
            }
        }
    }
}
