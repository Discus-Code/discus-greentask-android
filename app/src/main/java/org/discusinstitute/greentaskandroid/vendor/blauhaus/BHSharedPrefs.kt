package org.discusinstitute.greentaskandroid.vendor.blauhaus

import android.content.Context
import java.util.*

fun putInt(context:Context ,key: String, value:Int, prefName: String = "default" ) {
    val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putInt(key, value)
        commit()
    }
}

fun getInt(context:Context,  key:String, default:Int=0, prefName:String="default"):Int {
    val sharedPref = context?.getSharedPreferences(prefName, Context.MODE_PRIVATE) ?: return default
    return sharedPref.getInt(key, default)
}

fun putCalendarPref(context:Context, calendar: Calendar, key:String, prefName:String="default") {
    val sharedPref = context?.getSharedPreferences(prefName, Context.MODE_PRIVATE) ?: return
    with (sharedPref.edit()) {
        putLong(key, calendar.timeInMillis)
        commit()
    }
}

fun getCalendarPref(context:Context, default:Calendar, key:String, prefName:String="default"):Calendar {
    val sharedPref = context?.getSharedPreferences(prefName, Context.MODE_PRIVATE) ?: return default
    if (!sharedPref.contains(key)) {
        return default
    } else {
        val timeInMillis = sharedPref.getLong(key, 0)
        return getCalendar(timeInMillis)

    }
}

