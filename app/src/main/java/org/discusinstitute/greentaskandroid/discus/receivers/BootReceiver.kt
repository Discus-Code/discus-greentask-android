package org.discusinstitute.greentaskandroid.discus.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.Model
import org.discusinstitute.greentaskandroid.vendor.blauhaus.cancelAlarm
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar
import org.discusinstitute.greentaskandroid.vendor.blauhaus.setAlarm

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            Log.d("YAKATORI", "boot received")
            GlobalScope.launch{
                val model = Model(context)
                cancelAlarm(
                    context,
                    NotificationPublisher.pendingIntent(
                        context
                    )
                )
                setAlarm(
                    context,
                    model.getAlarmTime(),
                    NotificationPublisher.pendingIntent(
                        context
                    )
                )
                }
            }
        }
    }
