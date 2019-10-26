package org.discusinstitute.greentaskandroid.discus.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.ProfileData

fun Repository.setUserFirstName(name: String) {
    GlobalScope.launch {
        appDao.setProfileData(
            ProfileData.createString(
                userFirstName,
                name
            )
        )
    }
}

fun Repository.getUserFirstName(): LiveData<String?> {
    return Transformations.map(appDao.getProfileData(userFirstName)){ it?.getString()}
}

fun Repository.signOut() {
    GlobalScope.launch{
        appDao.clearProfileData()
    }
}

fun Repository.signIn() {
    GlobalScope.launch{
        appDao.setProfileData(
            ProfileData.createBoolean(
                loggedIn,
                true
            )
        )
        refreshSounds()
        refreshTasks()
        refreshWallpapers()
        refreshUserAttributes()
    }
}


fun Repository.isSignedIn(): LiveData<Boolean> {
    return Transformations.map(appDao.getProfileData(loggedIn)){
        val loggedIn = it?.getBoolean()
        if (loggedIn == null) {
            false
        } else {
            loggedIn
        }
    }
}

fun Repository.firstRun(): LiveData<Boolean> {
    return Transformations.map(appDao.getProfileData(isFirstRun), {
        val isFirstRun = it?.getBoolean()
        if (isFirstRun != null) {
            isFirstRun
        } else {
            true
        }
    })
}

fun Repository.didFirstRun() {
    GlobalScope.launch {
        appDao.setProfileData(
            ProfileData.createBoolean(
                isFirstRun,
                true
            )
        )
    }
}

suspend fun Repository.getProfileDataS(entry:String): ProfileData? {
    return appDao.getProfileDataS(entry)
}
