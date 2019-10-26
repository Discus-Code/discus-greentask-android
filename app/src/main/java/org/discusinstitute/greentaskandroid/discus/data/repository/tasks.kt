package org.discusinstitute.greentaskandroid.discus.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.ProfileData
import org.discusinstitute.greentaskandroid.discus.data.SustainabilityTask


// todo make this non-nullable with hardcoded first task same as above
//  so if webservice call fails initially there is still data.
fun Repository.getCurrentTask(): LiveData<SustainabilityTask?> {
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

fun Repository.getTasks(): LiveData<List<SustainabilityTask>> {
    refreshTasks()
    return appDao.getTasks()
}

fun Repository.pickRandomTask() {
    GlobalScope.launch {
        val tasks = appDao.getTasksS()
        if (tasks.isNotEmpty()) {
            setCurrentTaskId(tasks.shuffled().first().id)
        }
    }
}



fun Repository.getTask(id:String) : LiveData<SustainabilityTask?> {
    return appDao.getTask(id)
}

fun Repository.getCurrentTaskId(): LiveData<String?> {
    return Transformations.map(appDao.getProfileData(currentTaskId)){ it?.getString()}
}

fun Repository.setCurrentTaskId(id: String) {
    GlobalScope.launch {
        appDao.setProfileData(
            ProfileData.createString(
                currentTaskId,
                id
            )
        )
    }
}
