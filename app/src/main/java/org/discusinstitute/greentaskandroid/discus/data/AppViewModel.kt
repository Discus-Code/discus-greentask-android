package org.discusinstitute.greentaskandroid.discus.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.repository.*
import org.discusinstitute.greentaskandroid.discus.receivers.NotificationPublisher
import org.discusinstitute.greentaskandroid.vendor.blauhaus.cancelAlarm
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar
import org.discusinstitute.greentaskandroid.vendor.blauhaus.setAlarm
import java.util.*

class AppViewModel(application:Application) : AndroidViewModel(application) {
    val repository = Repository.getInstance(application.applicationContext)

    //region Sounds
    fun setCurrentSoundId(id: String) = repository.setCurrentSoundId(id)
    val currentSound: LiveData<Sound> = repository.getCurrentSound()
    val sounds: LiveData<List<Sound>> = repository.getSounds()
    //endregion


    //region Wallpapers
    fun setCurrentWallpaperId(id: String) = repository.setCurrentWallpaperId(id)
    val currentWallpaper: LiveData<Wallpaper> = repository.getCurrentWallpaper()
    val wallpapers: LiveData<List<Wallpaper>> = repository.getWallpapers()
    //endregion


    //region Alarms
    fun setCurrentAlarmTime(hour: Int, minute: Int) {
        val calendar = getCalendar(hour, minute)
        repository.setCurrentAlarmTime(calendar)
        setAndroidAlarm(calendar)
    }

    var currentAlarmTime: LiveData<Calendar> = repository.getCurrentAlarmTime()

    fun setAlarmForOneHourFromNow() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.HOUR, 1)
        setAndroidAlarm(calendar)
    }

    fun setAlarmToTonight() {
        var calendar = getCalendar(19, 0)
        setAndroidAlarm(calendar)
    }

    fun reEstablishAlarmFromStoredAlarmTime() {
        GlobalScope.launch {
            val calendar = repository.getCurrentAlarmTimeS()?.getCalendar()
            if (calendar != null) {
                setAndroidAlarm(calendar)
            }
        }
    }

    //endregion


    //region User
    fun setUserFirstName(name: String) = repository.setUserFirstName(name)
    fun getUserFirstName(): LiveData<String?> = repository.getUserFirstName()
    val signedIn = repository.isSignedIn()
    fun signIn() = repository.signIn()

    fun signOut() {
        cancelAndroidAlarm()
        repository.signOut()
    }

    val isFirstRun:LiveData<Boolean> = repository.firstRun()
    fun didFirstRun() = repository.didFirstRun()

    //endregion


    //region Tasks
    val completedTaskCount:LiveData<Int> = repository.getCompletedTaskCount()
    val currentTask: LiveData<SustainabilityTask?> = repository.getCurrentTask()
    fun addCompletedTask(id: String) = repository.addCompletedtaskById(id)

    //endregion

    //region Helpers
    fun setAndroidAlarm(calendar: Calendar) {
        cancelAndroidAlarm()
        setAlarm(getApplication(), calendar, NotificationPublisher.pendingIntent(getApplication()))
    }

    fun cancelAndroidAlarm() {
        cancelAlarm(getApplication(), NotificationPublisher.pendingIntent(getApplication()))
    }
    //endregion
}


