package org.discusinstitute.greentaskandroid.discus.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.Repository
import org.discusinstitute.greentaskandroid.vendor.blauhaus.cancelAlarm
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar
import org.discusinstitute.greentaskandroid.vendor.blauhaus.setAlarm

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            Log.d("YAKATORI", "boot received")
            val repo = Repository.getInstance(context)
            GlobalScope.launch{
                var millis = repo.getCurrentAlarmTimeS()?.value
                if (millis != null) {
                    var calendar = getCalendar(millis.toLong())

                    cancelAlarm(
                        context,
                        NotificationPublisher.pendingIntent(
                            context
                        )
                    )
                    setAlarm(
                        context,
                        calendar,
                        NotificationPublisher.pendingIntent(
                            context
                        )
                    )
                }
            }
        }
    }
}