package com.technowave.broadcastexample

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button?>(R.id.btnClick).setOnClickListener {


        }
        findViewById<Button?>(R.id.btnRegister).setOnClickListener {
            registerReceiver()
        }
        findViewById<Button?>(R.id.btnUnRegister).setOnClickListener {
            unregisterMyReceiver()
        }

    }

    private val myReceiver = MyReceiver()
    private fun registerReceiver(){

        val filter = IntentFilter("android.intent.action.AIRPLANE_MODE")
        //val flag = ContextCompat.RECEIVER_EXPORTED
        val flag = ContextCompat.RECEIVER_NOT_EXPORTED
        ContextCompat.registerReceiver(this, myReceiver, filter, flag)
    }

    private fun unregisterMyReceiver(){
        unregisterReceiver(myReceiver)
    }

    companion object{
        const val TAG = "MYBroadcastLog"
    }
}