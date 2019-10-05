package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.include_clock.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.vendor.blauhaus.RenderTime
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

val soundNotSetText = "not set"
class SettingsFragment : IndexActivityBaseFragment() {

    val TAG = "SETTINGS_FRAGMENT"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_settings, container, false)
        view.root_layout.visibility = View.GONE
        view.set_alarm.setOnClickListener{ view ->
                navController.navigate(
                    R.id.action_settingsFragment_to_settingsAlarmFragment)
            }

//        view.select_wallpaper.setOnClickListener{view->
//            navController.navigate(R.id.action_settingsFragment_to_pickWallpaperFragment)
//        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.currentSound.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                alarm_name.text = soundNotSetText
            } else {
                alarm_name.text = it.name
            }
        })

        model.currentAlarmTime.observe(viewLifecycleOwner, Observer {
          cal ->
                RenderTime.renderTime(cal, alarm_time, alarm_am_pm)
            })

        model.signedIn.observe(viewLifecycleOwner, Observer {
            loggedIn ->
            if(!loggedIn) {
                listener?.navigateSignIn()
                root_layout.visibility = View.GONE
            } else {
                root_layout.visibility = View.VISIBLE
            }
        })
    }
}
