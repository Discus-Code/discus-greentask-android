package org.discusinstitute.greentaskandroid.discus.receivers

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import org.discusinstitute.greentaskandroid.discus.activities.SoundAlarmActivity

class NotificationPublisher:BroadcastReceiver() {

    val TAG = "NOTIFICATION_PUBLISHER"

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive")

        startAlarmActivity(context!!)
    }

    private fun startAlarmActivity(context:Context) {
        val i  = Intent(context, SoundAlarmActivity::class.java)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(i)
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