package org.discusinstitute.greentaskandroid.vendor.blauhaus

import android.app.Activity
import android.app.AlarmManager
import android.app.KeyguardManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.view.WindowManager
import android.widget.TextView
import android.widget.TimePicker
import java.util.*


fun getCalendar(hour: Int = 14 /*2pm*/, minute:Int = 0, dontSetPastAlarms:Boolean=true):Calendar {
    var newCal = Calendar.getInstance().apply {
        timeInMillis = System.currentTimeMillis()
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
    }

    if (dontSetPastAlarms) {
        if (newCal.timeInMillis < System.currentTimeMillis()) {
            newCal.set(Calendar.HOUR_OF_DAY, hour + 24)
        }
        return newCal
    } else {
        return newCal
    }
}

fun getCalendar(timeInMillis: Long):Calendar {
    return Calendar.getInstance().apply {
        this.timeInMillis = timeInMillis
    }
}

fun setAlarm(context:Context, calendar: Calendar, alarmIntent:PendingIntent) {
    val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmMgr?.setInexactRepeating(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        AlarmManager.INTERVAL_DAY,
        alarmIntent
    )
}

fun cancelAlarm(context:Context, pendingIntent:PendingIntent) {
    val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmMgr?.cancel(pendingIntent)
}

fun showThroughLockScreen(activity: Activity) {
    if (Build.VERSION.SDK_INT >= 27) {
        activity.setShowWhenLocked(true)
        activity.setTurnScreenOn(true)
        val keyguardManager = activity.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        keyguardManager.requestDismissKeyguard(activity, null)
    } else if (Build.VERSION.SDK_INT >= 26) {
        val keyguardManager = activity.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        keyguardManager.requestDismissKeyguard(activity, null)
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
            (WindowManager.LayoutParams.FLAG_FULLSCREEN or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON))
    } else {
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN or
                   WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
            (WindowManager.LayoutParams.FLAG_FULLSCREEN or
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON))
    }
}

fun getHour(timePicker: TimePicker): Int{
    if (Build.VERSION.SDK_INT >= 23) {
        return timePicker.getHour()
    } else {
        return timePicker.getCurrentHour()
    }
}
fun getMinute(timePicker: TimePicker): Int{
    if (Build.VERSION.SDK_INT >= 23) {
        return timePicker.getMinute()
    } else {
        return timePicker.getCurrentMinute()
    }
}

fun setHour(timePicker:TimePicker, hour:Int) {
    if (Build.VERSION.SDK_INT >= 23) {
        timePicker.hour = hour
    } else {
        timePicker.setCurrentHour(hour)
    }
}

fun setMinute(timePicker:TimePicker, minute: Int) {
    if (Build.VERSION.SDK_INT >= 23) {
        timePicker.minute = minute
    } else {
        timePicker.setCurrentMinute(minute)
    }
}

fun setTime(timePicker:TimePicker, cal: Calendar) {
    setHour(timePicker, cal.get(Calendar.HOUR_OF_DAY))
    setMinute(timePicker, cal.get(Calendar.MINUTE))
}


class RenderTime {
    companion object {
        fun hourString(cal:Calendar) :String {
            var hour = cal.get(Calendar.HOUR_OF_DAY) % 12
            if (hour == 0) {
                hour = 12
            }
            return hour.toString()
        }

        fun minuteString(cal: Calendar):String {
            var minute = cal.get(Calendar.MINUTE)
            var minuteString = ""
            if (minute < 10) {
                return "0${minute}"
            } else {
                return minute.toString()
            }
        }

        fun hourMinuteString(cal:Calendar):String {
            return "${hourString(cal)}:${minuteString(cal)}"
        }

        fun amPMString(cal:Calendar):String {
            if (cal.get(Calendar.AM_PM) == Calendar.AM) {
                return "AM"
            } else {
                return "PM"
            }
        }

        fun renderTime(cal:Calendar) : String{
            return hourMinuteString(cal) + amPMString(cal)
        }

        fun renderTime(cal: Calendar?, timeView: TextView, ampmView: TextView) {
            if (cal == null) {
                timeView.text = "--:--"
                ampmView.text = "PM"
            } else {
                timeView.text = hourMinuteString(cal)
                ampmView.text = amPMString(cal)

            }
        }

        fun convertCalendarDayOrdinalToEnglishString(cal: Calendar): String {
            var dotw = cal.get(Calendar.DAY_OF_WEEK)
            var day = ""
            when (dotw) {
                Calendar.MONDAY -> day = "Monday"
                Calendar.TUESDAY -> day = "Tuesday"
                Calendar.WEDNESDAY -> day = "Wednesday"
                Calendar.THURSDAY -> day = "Thursday"
                Calendar.FRIDAY -> day = "Friday"
                Calendar.SATURDAY -> day = "Saturday"
                Calendar.SUNDAY -> day = "Sunday"
            }
            return day
        }

        fun renderDay(cal:Calendar?, dayView: TextView) {
            if (cal == null) {
                dayView.text = ""
            } else {
                dayView.text = convertCalendarDayOrdinalToEnglishString(cal)
            }
        }
    }


}
