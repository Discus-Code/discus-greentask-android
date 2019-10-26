package org.discusinstitute.greentaskandroid.discus.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.ProfileData
import org.discusinstitute.greentaskandroid.discus.defaultAlarmTime
import java.util.*

fun Repository.getCurrentAlarmTime(): LiveData<Calendar> {
    return Transformations.map(appDao.getProfileData(currentAlarmTime)){
        val calendar = it?.getCalendar()
        if (calendar == null) {
            defaultAlarmTime
        } else {
            calendar
        }
    }
}


fun Repository.setCurrentAlarmTime(calendar: Calendar) {
    GlobalScope.launch {
        appDao.setProfileData(
            ProfileData.createCalendar(
                currentAlarmTime,
                calendar
            )
        )
    }
}

suspend fun Repository.getCurrentAlarmTimeS(): ProfileData? = appDao.getProfileDataS(
    currentAlarmTime
)
