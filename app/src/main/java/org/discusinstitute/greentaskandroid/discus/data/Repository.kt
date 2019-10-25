package org.discusinstitute.greentaskandroid.discus.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

class Repository(val appDatabase: AppDatabase) {
    val appDao = appDatabase.appDao()
    val mock = MockData()

    //region Sounds

    fun getSounds(): LiveData<List<Sound>>  {
        refreshSounds()
        return Transformations.map(appDao.getSounds()) {
            defaultSounds + it
        }
    }

    fun getCurrentSound(): LiveData<Sound> {
        return Transformations.switchMap(getCurrentSoundId()){
            if (it != null) {
                getSound(it)
            } else {
                MutableLiveData<Sound>()
                    .apply {
                        value = defaultSounds[0]
                    }
            }
        }
    }

    fun setCurrentSoundId(id: String) {
        GlobalScope.launch {
            appDao.setProfileData(ProfileData(currentSoundId, id))
        }
    }

    //TODO Fetch /sounds
    private fun refreshSounds() {
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

    private fun getSound(id:String) : LiveData<Sound> {
        return Transformations.map(appDao.getSound(id)) { soundFromDB ->
            if (soundFromDB == null) {
                var s = defaultSounds.filter{sound -> sound.id == id}.firstOrNull()
                if (s != null) {
                    s
                } else {
                    defaultSounds[0]
                }
            } else {
                soundFromDB
            }
        }
    }

    private fun getCurrentSoundId(): LiveData<String?> {
        return Transformations.map(appDao.getProfileData(currentSoundId)){ it?.getString()}
    }

    //endregion



    //region Wallpapers
    fun getWallpapers(): LiveData<List<Wallpaper>> {
        refreshWallpapers()
        return Transformations.map(appDao.getWallpapers()) {
            defaultWallpapers + it
        }
    }

    fun getWallpaper(id: String) : LiveData<Wallpaper> {
        return Transformations.map(appDao.getWallpaper(id)) { wallpaperFromDB ->
            if (wallpaperFromDB == null) {
                var s = defaultWallpapers.filter{wallpaper -> wallpaper.id == id}.firstOrNull()
                if (s != null) {
                    s
                } else {
                    defaultWallpapers[0]
                }
            } else {
                wallpaperFromDB
            }
        }
    }

    //TODO webservice call
    private fun refreshWallpapers() {
        GlobalScope.launch {
            appDao.insertWallpapers(mock.wallpapers)
        }
    }

    fun getCurrentWallpaperId(): LiveData<String?> {
        return Transformations.map(appDao.getProfileData(currentWallpaperId)){it?.getString()}
    }

    fun getCurrentWallpaper(): LiveData<Wallpaper> {
        return Transformations.switchMap(getCurrentWallpaperId()){
            if (it != null) {
                getWallpaper(it)
            } else {
                var ld = MutableLiveData<Wallpaper>()
                ld.value = defaultWallpapers[0]
                ld
            }
        }
    }

    fun setCurrentWallpaperId(id: String) {
        GlobalScope.launch {
            appDao.setProfileData(ProfileData.createString(currentWallpaperId, id))
        }
    }
    //endregion

    //region Alarms
    fun getCurrentAlarmTime():LiveData<Calendar> {
        return Transformations.map(appDao.getProfileData(currentAlarmTime)){
            val calendar = it?.getCalendar()
            if (calendar == null) {
               defaultAlarmTime
            } else {
               calendar
            }
        }
    }


    fun setCurrentAlarmTime(calendar:Calendar) {
        GlobalScope.launch {
            appDao.setProfileData(
                ProfileData.createCalendar(currentAlarmTime, calendar)
            )
        }
    }

    suspend fun getCurrentAlarmTimeS(): ProfileData? = appDao.getProfileDataS(currentAlarmTime)


    //endregion



    //region Tasks

    fun pickRandomTask() {
        GlobalScope.launch {
            val tasks = appDao.getTasksS()
            if (tasks.isNotEmpty()) {
                setCurrentTaskId(tasks.shuffled().first().id)
            }
        }
    }


    // todo make this non-nullable with hardcoded first task same as above
    //  so if webservice call fails initially there is still data.
    fun getCurrentTask(): LiveData<SustainabilityTask?> {
        return Transformations.switchMap(getCurrentTaskId()){
            if (it != null) {
                getTask(it)
            } else {
                var ld = MutableLiveData<SustainabilityTask?>()
                ld.value = null
                ld
            }
        }
    }

    private fun getTasks(): LiveData<List<SustainabilityTask>> {
        refreshTasks()
        return appDao.getTasks()
    }

    //TODO webservice call
    private fun refreshTasks() {
        GlobalScope.launch {
            appDao.insertTasks(mock.tasks)
            pickRandomTask()
        }
    }

    private fun getTask(id:String) : LiveData<SustainabilityTask?> {
        return appDao.getTask(id)
    }

    private fun getCurrentTaskId(): LiveData<String?> {
        return Transformations.map(appDao.getProfileData(currentTaskId)){ it?.getString()}
    }

    private fun setCurrentTaskId(id: String) {
        GlobalScope.launch {
            appDao.setProfileData(ProfileData.createString(currentTaskId, id))
        }
    }
    //endregion



    //region Completed Tasks
    private fun getCompletedTasks(): LiveData<List<CompletedSustainabilityTask>> {
        refreshCompletedTasks()
        return appDao.getCompletedTasks()
    }

    fun addCompletedtaskById(id: String)  {
        GlobalScope.launch {
            appDao.insertCompletedTask(CompletedSustainabilityTask(id, Calendar.getInstance()))
        }
    }

    private fun removeCompletedTaskById(id: String) {
        GlobalScope.launch {
            appDao.removeCompletedTask(id)
        }
    }

    fun insertCompletedTasks(tasks: List<CompletedSustainabilityTask>) {
        GlobalScope.launch {
            appDao.insertCompletedTasks(tasks)
        }
    }

    //TODO webservices call
    private fun refreshCompletedTasks() {
        insertCompletedTasks(mock.completedTasks)
    }

    fun getCompletedTaskCount(): LiveData<Int> {
        return Transformations.map(getCompletedTasks()){
            it.size
        }
    }

    //endregion



    //region User
    fun setUserFirstName(name: String) {
        GlobalScope.launch {
            appDao.setProfileData(ProfileData.createString(userFirstName, name))
        }
    }

    fun getUserFirstName(): LiveData<String?> {
        return Transformations.map(appDao.getProfileData(userFirstName)){ it?.getString()}
    }

    fun signOut() {
        GlobalScope.launch{
            appDao.clearProfileData()
        }
    }

    fun signIn() {
        GlobalScope.launch{
            appDao.setProfileData(ProfileData.createBoolean(loggedIn, true))
            refreshSounds()
            refreshTasks()
            refreshWallpapers()
            refreshUserAttributes()
        }
    }

    //TODO - we have probably logged out and obliterated user profile data.
    // we now need to refresh from api
    fun refreshUserAttributes() {
        // todo reseactivate alarm from api user profile with calls to set/cancel alarm
    }

    fun isSignedIn():LiveData<Boolean> {
        return Transformations.map(appDao.getProfileData(loggedIn)){
            val loggedIn = it?.getBoolean()
            if (loggedIn == null) {
                false
            } else {
                 loggedIn
            }
        }
    }

    fun firstRun():LiveData<Boolean> {
        return Transformations.map(appDao.getProfileData(isFirstRun), {
            val isFirstRun = it?.getBoolean()
            if (isFirstRun != null) {
                isFirstRun
            } else {
                true
            }
        })
    }

    fun didFirstRun() {
        GlobalScope.launch {
            appDao.setProfileData(ProfileData.createBoolean(isFirstRun, true))
        }
    }

    suspend fun getProfileDataS(entry:String):ProfileData? {
        return appDao.getProfileDataS(entry)
    }

    //endregion



    companion object {
        @Volatile private var instance: Repository? = null

        fun getInstance(context:Context) =
            instance ?: synchronized(this) {
                instance
                    ?: Repository(AppDatabase.getInstance(context))
                    .also { instance = it }
            }
    }
}
