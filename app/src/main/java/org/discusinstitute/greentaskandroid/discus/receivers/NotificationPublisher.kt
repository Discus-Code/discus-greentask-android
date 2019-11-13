package org.discusinstitute.greentaskandroid.discus.receivers

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.LOG
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.*
import org.discusinstitute.greentaskandroid.discus.data.Model
import org.discusinstitute.greentaskandroid.vendor.blauhaus.buildBigTextNotification
import org.discusinstitute.greentaskandroid.vendor.blauhaus.createNotificationChannel
import org.discusinstitute.greentaskandroid.vendor.blauhaus.notify
import java.lang.IndexOutOfBoundsException
import kotlin.random.Random

class NotificationPublisher:BroadcastReceiver() {

    val TAG = "NOTIFICATION_PUBLISHER"

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive")

        if (context != null) {
            Log.d(TAG, "have context")
            val model = Model(context)
            val task = model.getTasks()?.shuffled()?.first()
            Log.d(TAG, task.toString())
            val tid = task?.action_id
            val shortText = task?.action_text
            val title = task?.action_name
            if (tid != null && shortText != null && title != null) {
                Log.d(TAG, "Creating notification")
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
            } else {
                Log.d(TAG, "bad task")
                Log.d(TAG, task.toString())
            }
        } else {
            Log.d(TAG, "no context")
        }
    }

    companion object {
        private val PENDING_INTENT_REQUEST_CODE = 3

        private fun intent(context:Context) : Intent {
            return Intent(context, NotificationPublisher::class.java)
        }

        fun pendingIntent(context:Context) : PendingIntent {
            return PendingIntent.getBroadcast(
                context,
                PENDING_INTENT_REQUEST_CODE,
                intent(
                    context
                ),
                PendingIntent.FLAG_UPDATE_CURRENT
            )

        }
    }
}