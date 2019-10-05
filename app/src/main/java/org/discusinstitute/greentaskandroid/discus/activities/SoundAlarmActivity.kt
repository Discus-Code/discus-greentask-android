package org.discusinstitute.greentaskandroid.discus.activities

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.PowerManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.data.AppViewModel
import org.discusinstitute.greentaskandroid.discus.fragments.SoundAlarmActivityBaseFragment
import org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.about.SUPPRESS_ALARM_FOR_DEBUGGING
import org.discusinstitute.greentaskandroid.vendor.blauhaus.BHSound
import org.discusinstitute.greentaskandroid.vendor.blauhaus.showThroughLockScreen

class SoundAlarmActivity : AppCompatActivity(), SoundAlarmActivityBaseFragment.FragmentInteractionListener {
    private var wl: PowerManager.WakeLock? = null
    private lateinit var model: AppViewModel
    private val bhsound = BHSound(MediaPlayer())
    lateinit var navController: NavController

    private val topLevelDestinations = setOf(
        R.id.soundAlarmLandingFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_alarm)

        navController = findNavController(R.id.nav_host_fragment)

        var debug = intent.getBooleanExtra(SUPPRESS_ALARM_FOR_DEBUGGING, false)

        model = ViewModelProviders.of(this)[AppViewModel::class.java]

        configureWakeLock()

        model.currentSound.observe(this, Observer {
            sound ->
                if (!debug) {
                    sound?.let { bhsound.playFromUrl(sound.url) }
                }
        })

        //if we are coming in from a delayed-alarm we need this.
        model.reEstablishAlarmFromStoredAlarmTime()

    }

    override fun onStop() {
        super.onStop()
        wl?.release()
        bhsound.releaseMediaPlayer()
    }

    private fun configureWakeLock() {
        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "sleepDemo:wakelok_tag")
        wl?.acquire()
        showThroughLockScreen(this)
    }



}
