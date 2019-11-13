package org.discusinstitute.greentaskandroid.discus.receivers

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.*
import org.discusinstitute.greentaskandroid.discus.data.Model
import org.discusinstitute.greentaskandroid.vendor.blauhaus.buildBigTextNotification
import org.discusinstitute.greentaskandroid.vendor.blauhaus.notify
import kotlin.random.Random

class NotificationPublisher:BroadcastReceiver() {

    val TAG = "NOTIFICATION_PUBLISHER"

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            val model = Model(context)
            val task = model.getTasks()?.shuffled()?.first()
            val tid = task?.action_id
            val shortText = task?.action_text
            val title = task?.action_name
            if (tid != null && shortText != null && title != null) {
                var pendingIntent = IndexActivity.getPendingIntent(context, tid)
                val notification = buildBigTextNotification(
                    context,
                    pendingIntent,
                    channelID,
                    R.drawable.ic_discuslogo_green,
                    null,
                    "GreenTask Daily!",
                    title,
                    shortText)
                notify(context, notification, Random.nextInt() )
            }
        }
    }

    companion object {
        fun getIntent(context:Context) : Intent {
            return Intent(context, NotificationPublisher::class.java)
        }

        fun getPendingIntent(context:Context) : PendingIntent {
            return PendingIntent.getBroadcast(
                context,
                0,
                getIntent(
                    context
                ),
                PendingIntent.FLAG_UPDATE_CURRENT
            )

        }
    }
}