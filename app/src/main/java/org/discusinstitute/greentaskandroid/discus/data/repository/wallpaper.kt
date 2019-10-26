package org.discusinstitute.greentaskandroid.discus.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.ProfileData
import org.discusinstitute.greentaskandroid.discus.data.Wallpaper
import org.discusinstitute.greentaskandroid.discus.defaultWallpapers

fun Repository.getWallpapers(): LiveData<List<Wallpaper>> {
    refreshWallpapers()
    return Transformations.map(appDao.getWallpapers()) {
        defaultWallpapers + it
    }
}

fun Repository.getWallpaper(id: String) : LiveData<Wallpaper> {
    return Transformations.map(appDao.getWallpaper(id)) { wallpaperFromDB ->
        if (wallpaperFromDB == null) {
            var s = defaultWallpapers.filter{ wallpaper -> wallpaper.id == id}.firstOrNull()
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

fun Repository.getCurrentWallpaperId(): LiveData<String?> {
    return Transformations.map(appDao.getProfileData(currentWallpaperId)){it?.getString()}
}

fun Repository.getCurrentWallpaper(): LiveData<Wallpaper> {
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

fun Repository.setCurrentWallpaperId(id: String) {
    GlobalScope.launch {
        appDao.setProfileData(
            ProfileData.createString(
                currentWallpaperId,
                id
            )
        )
    }
}