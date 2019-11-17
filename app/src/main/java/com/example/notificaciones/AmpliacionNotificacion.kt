package com.example.notificaciones

import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AmpliacionNotificacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ampliacion_notificacion)


    }
    fun cerrarNotificacion(v: View){
        val notManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = intent.extras.getInt("ID")
        notManager.cancel(id)
        finish()
    }
}
