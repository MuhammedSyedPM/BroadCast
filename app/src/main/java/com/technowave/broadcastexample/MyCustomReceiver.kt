package com.technowave.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.technowave.broadcastexample.MainActivity.Companion.TAG

class MyCustomReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d(TAG, "Custom event received data:${p1?.getStringExtra("data")}")
    }
}