package org.discusinstitute.greentaskandroid.discus.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.*
import org.discusinstitute.greentaskandroid.discus.defaultAlarmTime
import org.discusinstitute.greentaskandroid.discus.defaultSounds
import org.discusinstitute.greentaskandroid.discus.defaultWallpapers
import java.util.*

val currentSoundId = "currentSoundId"
val currentWallpaperId = "currentWallpaperId"
val currentAlarmTime = "currentAlarmTime"
val currentTaskId = "currentTaskId"
val userFirstName = "userFirstName"
val loggedIn = "logged_in"
val isFirstRun = "first_run"
val TAG = "Repository"

class Repository(val appDao: AppDao, val mock: MockData) {

    //TODO
    fun refreshSounds() {
        /*
            if profileData(soundUpdate) < TimeUnit.DAYS.toMillis(1) {
                appDao.insertSounds(webservice.getSounds())
                setProfileData(soundUpdate, System.currentTimeMillis)
            }
         */

        GlobalScope.launch {
            appDao.insertSounds(mock.sounds)
        }
    }

    //TODO
    fun refreshWallpapers() {
        GlobalScope.launch {
            appDao.insertWallpapers(mock.wallpapers)
        }
    }

    //TODO
    fun refreshTasks() {
        GlobalScope.launch {
            appDao.insertTasks(mock.tasks)
            pickRandomTask()
        }
    }

    //TODO
    fun refreshCompletedTasks() {
        insertCompletedTasks(mock.completedTasks)
    }


    //TODO
    fun refreshUserAttributes() {
        // todo reseactivate alarm from api user profile with calls to set/cancel alarm
    }

    companion object {
        @Volatile private var instance: Repository? = null

        fun getInstance(context:Context) =
            instance
                ?: synchronized(this) {
                instance
                    ?: Repository(
                        AppDatabase.getInstance(
                            context
                        ).appDao(), MockData()
                    )
                    .also { instance = it }
            }
    }
}
