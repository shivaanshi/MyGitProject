package com.meenakshi.mygitproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel("priority")
        createNotificationChannel("notification1")
        createNotificationChannel("notification2")
        createNotificationChannel("notification3")
        createNotificationChannel("notification4")
        createNotificationChannel("notification5")
        createNotificationChannel("notification6")
        createNotificationChannel("notification7")
        createNotificationChannel("notification8")
        createNotificationChannel("notification9")
        createNotificationChannel("notification10")
    }

    private fun createNotificationChannel(channelId: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val attributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(channelId, title, importance)
            mChannel.description = channelId
            mChannel.setShowBadge(true)
            mChannel.enableLights(true)
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200)
            mChannel.lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
            mChannel.lightColor = ContextCompat.getColor(this, R.color.black)
            val notificationS = getNotificationSound(channelId)
            if (notificationS != null) {
                mChannel.setSound(notificationS, attributes)
            }
            getNotificationManager().createNotificationChannel(mChannel)
        }
    }

    //method to get notificationManager
    private fun getNotificationManager(): NotificationManager {
        return getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun getNotificationSound(selectedTone: String): Uri? {
        return Uri.parse("android.resource://$packageName/raw/$selectedTone")
    }

}