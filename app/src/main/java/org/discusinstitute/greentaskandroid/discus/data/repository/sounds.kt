package org.discusinstitute.greentaskandroid.discus.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.ProfileData
import org.discusinstitute.greentaskandroid.discus.data.Sound
import org.discusinstitute.greentaskandroid.discus.defaultSounds

fun Repository.getSounds(): LiveData<List<Sound>> {
    refreshSounds()
    return Transformations.map(appDao.getSounds()) {
        defaultSounds + it
    }
}

fun Repository.getCurrentSound(): LiveData<Sound> {
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

fun Repository.setCurrentSoundId(id: String) {
    GlobalScope.launch {
        appDao.setProfileData(
            ProfileData(
                currentSoundId,
                id
            )
        )
    }
}

fun Repository.getSound(id:String) : LiveData<Sound> {
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

fun Repository.getCurrentSoundId(): LiveData<String?> {
    return Transformations.map(appDao.getProfileData(currentSoundId)){ it?.getString()}
}
