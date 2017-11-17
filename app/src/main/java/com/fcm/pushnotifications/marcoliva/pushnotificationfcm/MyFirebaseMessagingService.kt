package com.fcm.pushnotifications.marcoliva.pushnotificationfcm

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by ThinkSoft on 16/11/2017.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    private var TAG = "MyFirebaseMessagingService"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        Log.d(TAG, "FROM : " + remoteMessage.from)

        //Verify if the message contains data
        if (remoteMessage.data.size > 0) {
            Log.d(TAG, "Message data : " + remoteMessage.data)
        }

        //Verify if the message contains notification
        if (remoteMessage.notification != null) {
            Log.d(TAG,"Message body : "+remoteMessage.notification.body)
            sendNotification(remoteMessage.notification.body)
        }
    }

    private fun sendNotification(body: String?) {
        var intent = Intent(this,MainActivity::class.java)
        //If set, and the activity being launched is already running in the current task,
        //then instead of launching a new instance of that activity, all of the other activities
        // on top of it will be closed and this Intent will be delivered to the (now on top)
        // old activity as a new Intent.
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        var pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT/*Flag indicating that this PendingIntent can be used only once.*/)
        val notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        var notificationBuilder = NotificationCompat.Builder(this,"Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Push Notification FCM")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent)

        var notificationManager: NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0,notificationBuilder.build())
    }
}