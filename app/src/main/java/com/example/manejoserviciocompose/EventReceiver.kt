package com.example.manejoserviciocompose

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class EventReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        val servInt = Intent(context, ElServicio::class.java)

        when (action) {
            Intent.ACTION_HEADSET_PLUG -> {
                val state = intent.getIntExtra("state", -1)
                if (state == 1) {
                    Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-ON", Toast.LENGTH_SHORT).show()
                    servInt.putExtra(MainActivity.MYDEFAULTSTRING_ID, R.string.key2.toString())
                    context.startService(servInt)
                } else if (state == 0) {
                    Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-OFF", Toast.LENGTH_SHORT).show()
                    context.stopService(servInt)
                }
            }

            Intent.ACTION_POWER_CONNECTED -> {
                Toast.makeText(context, "BroadcastReceiver - POWER_CONNECTED", Toast.LENGTH_SHORT).show()
                servInt.putExtra(MainActivity.MYDEFAULTSTRING_ID, R.string.key2.toString())
                context.startService(servInt)
            }
            Intent.ACTION_POWER_DISCONNECTED -> {
                Toast.makeText(context, "BroadcastReceiver - POWER_DISCONNECTED", Toast.LENGTH_SHORT).show()
                context.stopService(servInt)
            }
        }
    }
}