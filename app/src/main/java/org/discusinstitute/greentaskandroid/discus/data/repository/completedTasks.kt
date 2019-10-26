package org.discusinstitute.greentaskandroid.discus.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.discus.data.CompletedSustainabilityTask
import java.util.*

fun Repository.getCompletedTasks(): LiveData<List<CompletedSustainabilityTask>> {
    refreshCompletedTasks()
    return appDao.getCompletedTasks()
}

fun Repository.addCompletedtaskById(id: String)  {
    GlobalScope.launch {
        appDao.insertCompletedTask(
            CompletedSustainabilityTask(
                id,
                Calendar.getInstance()
            )
        )
    }
}

fun Repository.removeCompletedTaskById(id: String) {
    GlobalScope.launch {
        appDao.removeCompletedTask(id)
    }
}

fun Repository.insertCompletedTasks(tasks: List<CompletedSustainabilityTask>) {
    GlobalScope.launch {
        appDao.insertCompletedTasks(tasks)
    }
}


fun Repository.getCompletedTaskCount(): LiveData<Int> {
    return Transformations.map(getCompletedTasks()){
        it.size
    }
}