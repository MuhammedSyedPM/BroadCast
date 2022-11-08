package com.technowave.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.technowave.broadcastexample.MainActivity.Companion.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.lang.Exception

class MyReceiver: BroadcastReceiver() {
    private val scope = CoroutineScope(SupervisorJob())
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "Received event")

        val pendingResult: PendingResult = goAsync()
        scope.launch(Dispatchers.Default) {
            try {

            } catch (e : Exception) {

            } finally {
                pendingResult.finish()
            }
        }
    }
}