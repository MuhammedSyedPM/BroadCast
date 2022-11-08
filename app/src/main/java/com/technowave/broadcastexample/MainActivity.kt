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

        findViewById<Button?>(R.id.createBroadcast).setOnClickListener {
            createCustomBroadcast()
        }
        findViewById<Button?>(R.id.btnRegister).setOnClickListener {
            registerReceiver()
        }
        findViewById<Button?>(R.id.btnUnRegister).setOnClickListener {
            unregisterMyReceiver()
        }
        findViewById<Button?>(R.id.btnRegisterForCustom).setOnClickListener {
           registerForCustomBroadcast()
        }
    }

    private fun createCustomBroadcast(){
        Intent().also {
            it.action = MY_CUSTOM_EVENT
            it.putExtra("data", "I am syed")
            sendBroadcast(it)
        }
    }

    private val myCustomReceiver = MyCustomReceiver()
    private fun registerForCustomBroadcast(){
        val filter = IntentFilter(MY_CUSTOM_EVENT)
        //val flag = ContextCompat.RECEIVER_EXPORTED
        val flag = ContextCompat.RECEIVER_NOT_EXPORTED
        ContextCompat.registerReceiver(this, myCustomReceiver, filter, flag)
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
        unregisterReceiver(myCustomReceiver)
    }

    companion object{
        const val TAG = "MYBroadcastLog"
        const val MY_CUSTOM_EVENT = "com.technowave.broadcastexample.MY_CUSTOM_BROADCAST"
    }
}