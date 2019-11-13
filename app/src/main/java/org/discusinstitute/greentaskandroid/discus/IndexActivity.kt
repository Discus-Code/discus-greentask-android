package org.discusinstitute.greentaskandroid.discus

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.beust.klaxon.Klaxon
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.widget_loading_progress_bar.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.data.Model
import org.discusinstitute.greentaskandroid.discus.data.Task
import org.discusinstitute.greentaskandroid.discus.fragments.BaseFragment
import org.discusinstitute.greentaskandroid.discus.receivers.NotificationPublisher
import org.discusinstitute.greentaskandroid.vendor.blauhaus.createNotificationChannel
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getCalendar
import org.discusinstitute.greentaskandroid.vendor.blauhaus.setAlarm


class IndexActivity : AppCompatActivity(),
    BaseFragment.FragmentInteractionListener {
    val TAG = "INDEX_ACTIVITY"
    lateinit var navController: NavController
    lateinit var model: Model
    var screen = LAUNCH_SCREEN
    var _tid = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "index activity oncreate")
        setContentView(R.layout.activity_index)

        createNotificationChannel(this, channelName, channelDescription, channelID)

        model = Model(this)
        navController = findNavController(R.id.nav_host_fragment)

        if(intent.hasExtra(SCREEN_EXTRA)) {
            Log.d(TAG, "have screen extra")
            screen = intent.getStringExtra(SCREEN_EXTRA)
        }
        if (intent.hasExtra(TASK_ID_EXTRA)) {
            Log.d(TAG, "have taskid extra")
            _tid = intent.getIntExtra(TASK_ID_EXTRA, 1)
        }

        when(screen) {
            LAUNCH_SCREEN -> {
                Log.d(TAG, "navigating to launch screen")
                navController.navigate(R.id.action_global_homeFragment)
            }
            DETAIL_SCREEN -> {
                Log.d(TAG, "navigating to detail screen")
                navController.navigate(R.id.action_global_detailFragment)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "indexactivity onresume")
        var pendingIntent = NotificationPublisher.pendingIntent(this)
        var alarmTime = model.getAlarmTime()
        setAlarm(this, alarmTime, pendingIntent)
    }


    override fun showProgressBar() {
        loadingProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        loadingProgressBar.visibility = View.GONE
    }

    override fun showSnackbar(message: String) {
        Snackbar.make(loadingProgressBar, message, Snackbar.LENGTH_INDEFINITE)
            .show();
    }

    override fun hideSoftKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm!!.hideSoftInputFromWindow(main_layout.getWindowToken(), 0)
    }

    override fun navigateHome() {
        navController.navigate(R.id.action_global_homeFragment)
    }

    override fun navigateSettings() {
        navController.navigate(R.id.action_homeFragment_to_settingsAlarmFragment)
    }

    override fun getTid():Int {
        return _tid
    }

    companion object {
        val TASK_ID_EXTRA = "taskid"
        val SCREEN_EXTRA = "screen"
        val PENDING_INTENT_REQUEST_CODE = 0
        val DETAIL_SCREEN="detail"
        val LAUNCH_SCREEN="launch"

        fun getPendingIntent(context:Context, taskId:Int = 1, screen:String="detail"):PendingIntent {
            val intent = Intent(context, IndexActivity::class.java)
            intent.putExtra(TASK_ID_EXTRA, taskId)
            intent.putExtra(SCREEN_EXTRA, screen)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            return PendingIntent.getActivity(context,
                PENDING_INTENT_REQUEST_CODE,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

}
