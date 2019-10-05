package org.discusinstitute.greentaskandroid.discus.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "wallpaper")
data class Wallpaper(
    @PrimaryKey
    val id:String,
    val url: String,
    val name: String,
    val minPointsToUnlock: Int,
    var isCurrent:Boolean = false)

@Entity (tableName = "sound")
data class Sound(
    @PrimaryKey
    val id:String,
    val url:String,
    val name: String,
    val minPointsToUnlock: Int,
    var isCurrent:Boolean = false)

@Entity (tableName = "sustainabilityTask")
data class SustainabilityTask(
    @PrimaryKey
    val id:String,
    val task:String,
    val didYouKnow: String
)

@Entity (tableName = "completedTasks")
data class CompletedSustainabilityTask(
    val id: String,
    @PrimaryKey
    val timestampCompleted: Calendar
)

@Entity (tableName = "profile")
data class ProfileData(
    @PrimaryKey
    val entry: String,
    var value: String
) {

    fun getBoolean(): Boolean? {
        if (value == null) {
            return null
        } else {
            return value == "1"
        }
    }

    fun getCalendar(): Calendar? {
        if (value == null) {
            return null
        }
        var millis = value.toLong()
        return org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar(millis)
    }

    fun getString():String? {
        return value
    }

    fun getInt(): Int? {
        return value?.toInt()
    }

    companion object {
        fun createBoolean(entry: String, value:Boolean):ProfileData {
            return if (value) ProfileData(entry, "1") else ProfileData(entry, "0")
        }

        fun createCalendar(entry: String, value: Calendar): ProfileData {
            return ProfileData(entry, value.timeInMillis.toString())
        }

        fun createString (entry: String, value:String) = ProfileData(entry, value)

        fun createInt (entry: String, value: Int) = ProfileData(entry, value.toString())
    }
}

