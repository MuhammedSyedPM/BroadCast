package com.technowave.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.technowave.broadcastexample.MainActivity.Companion.TAG

class MyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "Received event")
    }
}