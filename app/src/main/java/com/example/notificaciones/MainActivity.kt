package com.example.notificaciones

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.view.View
import android.media.RingtoneManager



class MainActivity : AppCompatActivity() {
    val ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun crearNotificacion(v: View){
        val intent = Intent(this, AmpliacionNotificacion::class.java )
        intent.putExtra("ID",ID)

        val pi = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT)

        val sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notTicker ="Aviso"
        val notTexto ="Mi primera notificación"
        val notTitulo ="Titulo de la primera"

        val notificacion = NotificationCompat.Builder(this,"qq")

            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentIntent(pi)
            .setTicker(notTicker)
            .setContentTitle(notTitulo)
            .setContentText(notTexto)
          // .addAction(R.drawable.ic_launcher_foreground,notTicker,pi)
            .setVibrate(longArrayOf(0,100,10,200,10,300))
            .setSound(sonido)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager//NotificationManagerCompat

        notManager.notify(ID,notificacion.build())
    }
}
