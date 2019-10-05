package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_settings_alarm.*
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getHour
import org.discusinstitute.greentaskandroid.vendor.blauhaus.getMinute
import org.discusinstitute.greentaskandroid.vendor.blauhaus.setTime
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment
import kotlinx.android.synthetic.main.fragment_settings_alarm.view.*
import org.discusinstitute.greentaskandroid.R

class SettingsAlarmFragment : IndexActivityBaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_alarm, container, false)

        view.select_sound_and_display.setOnClickListener{
            navController.navigate(R.id.action_settingsAlarmFragment_to_pickSoundFragment)
        }

        view.alarm_time_picker.setOnTimeChangedListener(object: TimePicker.OnTimeChangedListener {
            override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
                model.setCurrentAlarmTime(getHour(alarm_time_picker), getMinute(alarm_time_picker))
            }
        })

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.currentAlarmTime.observe(viewLifecycleOwner, Observer { cal ->
            cal?.let {setTime(alarm_time_picker, cal)}
        })
    }
}
