package org.discusinstitute.greentaskandroid.discus.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM wallpaper")
    fun getWallpapers(): LiveData<List<Wallpaper>>

    @Query("SELECT * FROM wallpaper where id=:id limit 1")
    fun getWallpaper(id:String): LiveData<Wallpaper?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallpapers(wallpapers: List<Wallpaper>)

    @Query("SELECT * FROM sound")
    fun getSounds(): LiveData<List<Sound>>

    @Query("SELECT * FROM sound where id=:id limit 1")
    fun getSound(id:String): LiveData<Sound?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSounds(sounds: List<Sound>)

    @Query("SELECT * FROM profile WHERE entry = :entry limit 1")
    fun getProfileData(entry: String): LiveData<ProfileData?>

    @Query("SELECT * FROM profile WHERE entry = :entry limit 1")
    suspend fun getProfileDataS(entry: String): ProfileData?

    @Query("DELETE FROM profile WHERE entry = :entry")
    fun deleteProfileData(entry: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setProfileData(data: ProfileData)

    @Query("DELETE FROM profile")
    fun clearProfileData()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTasks(tasks: List<SustainabilityTask>)

    @Query("SELECT * FROM sustainabilityTask")
    fun getTasks(): LiveData<List<SustainabilityTask>>

    @Query("SELECT * FROM sustainabilityTask")
    fun getTasksSync(): List<SustainabilityTask>

    @Query ("SELECT * FROM sustainabilityTask where id = :id")
    fun getTask(id: String): LiveData<SustainabilityTask?>

    @Query("SELECT * FROM completedTasks")
    fun getCompletedTasks(): LiveData<List<CompletedSustainabilityTask>>

    @Query("DELETE FROM completedTasks WHERE id = :id")
    fun removeCompletedTask(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletedTask(completedTask: CompletedSustainabilityTask)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletedTasks(completedTasks: List<CompletedSustainabilityTask>)

}