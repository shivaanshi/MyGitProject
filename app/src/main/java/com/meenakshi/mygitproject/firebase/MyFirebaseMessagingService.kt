package com.meenakshi.mygitproject.firebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.meenakshi.mygitproject.R

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun getStartCommandIntent(p0: Intent?): Intent {
        println("Remote Message Received: getStartCommandIntent $p0")
        return super.getStartCommandIntent(p0)
    }

    override fun handleIntentOnMainThread(p0: Intent?): Boolean {
        println("Remote Message Received: handleIntentOnMainThread $p0")
        return super.handleIntentOnMainThread(p0)
    }

    override fun handleIntent(p0: Intent?) {
        super.handleIntent(p0)
        println("Remote Message Received: handleIntent ${p0?.extras?.get("gcm.notification.android_channel_id")}")
    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        println("Remote Message Received: onMessageReceived ${p0.notification?.channelId}")
        createNotification(p0.notification?.channelId!!, p0.notification!!.title!!, p0.notification!!.body!!
        )
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }

    override fun onMessageSent(p0: String) {
        super.onMessageSent(p0)
        println("Remote Message Received: $p0")
    }

    override fun onSendError(p0: String, p1: Exception) {
        super.onSendError(p0, p1)
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    private fun createNotificationChannel(channelId: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val attributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(channelId, "demo_channel", importance)
            mChannel.description = channelId
            mChannel.setShowBadge(true)
            mChannel.enableLights(true)
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200)
            mChannel.lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
            mChannel.lightColor = ContextCompat.getColor(this, R.color.teal_200)
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

    fun createNotification(channelId: String, title: String, description: String) {
        val groupBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setGroupSummary(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setChannelId(channelId)
            .setShowWhen(true)
            .setWhen(System.currentTimeMillis())
            .setLights(Color.CYAN, 1000, 1000)
            .setVibrate(longArrayOf(100, 200))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentTitle(title)
            .setContentText(description)
            .setStyle(NotificationCompat.BigTextStyle().setBigContentTitle(title))
        val notificationS = getNotificationSound(channelId)
        if (notificationS != null) {
            groupBuilder.setSound(notificationS)
        }
        groupBuilder.setChannelId(channelId)

        val groupNotification = groupBuilder.build()
        groupNotification.flags = groupNotification.flags or Notification.FLAG_AUTO_CANCEL
        getNotificationManager().notify(
            123,
            groupNotification
        )
    }

}