package org.discusinstitute.greentaskandroid.vendor.blauhaus

import android.media.MediaPlayer
import android.os.CountDownTimer

class BHSound(val mediaPlayer:MediaPlayer) {
    val TAG = "BHSound"

    fun stopMediaPlayerAfterTime(seconds: Int) {
        val timer = object: CountDownTimer(seconds * 1000L, 1000L) {
            override fun onFinish() {
                stopMediaPlayer()
            }
            override fun onTick(millisUntilFinished: Long) {}
        }
    }

    fun stopMediaPlayer() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }

    fun playFromUrl(url:String, secondsOfAudio:Int? = null) {
        stopMediaPlayer()
        mediaPlayer.reset()
        mediaPlayer.setDataSource(url)
        mediaPlayer.prepare()
        mediaPlayer.start()
        secondsOfAudio?.also {
           // stopMediaPlayerAfterTime(it)
        }
    }

    fun releaseMediaPlayer() {
        mediaPlayer.release()
    }
}
