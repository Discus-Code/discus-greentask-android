package org.discusinstitute.greentaskandroid.discus.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beust.klaxon.Klaxon
import org.discusinstitute.greentaskandroid.discus.calendarPref
import org.discusinstitute.greentaskandroid.discus.defaultAlarmTime
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendarPref
import org.discusinstitute.greentaskandroid.vendor.blauhaus.putCalendarPref
import org.json.JSONObject
import java.util.*

class Model( val context:Context ) {
    var cache:List<Task>? = null

    fun saveAlarmTime(calendar: Calendar) {
        putCalendarPref(context, calendar, calendarPref)
    }

    fun getAlarmTime():Calendar {
        return getCalendarPref(context, getCalendar(), calendarPref)
    }

    fun getTasks():List<Task>? {
        if (cache == null) {
            cache = Klaxon().parseArray<Task>(tasks)
        }
        return cache
    }

    fun getTask(id:Int):Task? {
        return getTasks()?.filter{t -> t.action_id == id}?.firstOrNull()
    }

}


