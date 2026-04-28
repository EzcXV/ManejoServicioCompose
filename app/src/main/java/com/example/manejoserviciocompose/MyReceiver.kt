package com.example.manejoserviciocompose

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val i = Intent(context, ElServicio::class.java)
        val action = intent.getStringExtra("ACTION")

        when (action) {
            "SONIDO" -> {
                Toast.makeText(context, "BroadcastReceiver - Inicio reproducción sonido", Toast.LENGTH_SHORT).show()
                i.putExtra(MainActivity.MYDEFAULTSTRING_ID, context.getString(R.string.key1))
                context.startService(i)
            }
            "CANCION" -> {
                Toast.makeText(context, "BroadcastReceiver - Inicio reproducción canción", Toast.LENGTH_SHORT).show()
                i.putExtra(MainActivity.MYDEFAULTSTRING_ID, context.getString(R.string.key2))
                context.startService(i)
            }
            "DETENER" -> {
                Toast.makeText(context, "BroadcastReceiver - Detencion reproduccion", Toast.LENGTH_SHORT).show()
                context.stopService(i)
            }
        }
    }
}
