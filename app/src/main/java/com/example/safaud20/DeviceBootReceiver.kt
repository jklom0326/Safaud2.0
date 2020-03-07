package com.example.safaud20

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.util.*

class DeviceBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("DeviceBootReceiver.onReceive() is not implemented")
        if(Objects.equals(intent.action,"android.intent.action.BOOT_COMPLETED"))
    }
}
