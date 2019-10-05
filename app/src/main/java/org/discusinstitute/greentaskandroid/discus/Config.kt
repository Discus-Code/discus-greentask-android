package org.discusinstitute.greentaskandroid.discus

import org.discusinstitute.greentaskandroid.discus.data.Sound
import org.discusinstitute.greentaskandroid.discus.data.SustainabilityTask
import org.discusinstitute.greentaskandroid.discus.data.Wallpaper
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar

val defaultAlarmHour = 12
val defaultAlarmMinute = 0
val defaultAlarmTime = getCalendar(defaultAlarmHour, 0)

val defaultSounds = listOf( Sound(
    "default_party_time",
    "https://elasticbeanstalk-us-east-1-562744294382.s3.amazonaws.com/484267__inspectorj__party-pack-horn-coil-01-long-01.wav",
    "Party Time",
    3
)
)
val defaultWallpapers = listOf(  Wallpaper(
    "xyz1",
    "https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg",
    "Tree 1",
    0
)
)
val defaultTasks = listOf( SustainabilityTask(
    "default_task_1",
    "This is a sustainability task. It is #1 and comes from the defaults.",
    "Did you know that sustainability tasks are usually green?"
)
)