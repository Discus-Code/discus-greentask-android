package org.discusinstitute.greentaskandroid.vendor.blauhaus

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

public fun createNotificationChannel(
    context: Context,
    channelName:String,
    descriptionText: String,
    channelId :String)
{
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}


public fun buildBigTextNotification(
    context:Context,
    pendingIntent: PendingIntent?,
    channelId:String,
    smallDrawable: Int,
    largeIconBitmap:Bitmap?,
    title:String,
    subject: String,
    longContentText:String): Notification
{
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(smallDrawable)
        .setLargeIcon(largeIconBitmap)
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(longContentText)
                .setBigContentTitle(title)
                .setSummaryText(subject)
        )
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()
}

public fun notify(
    context:Context,
    notification: Notification,
    notificationId: Int)
{
    with(NotificationManagerCompat.from(context)) {
        // notificationId is a unique int for each notification that you must define
        notify(notificationId, notification)
    }
}