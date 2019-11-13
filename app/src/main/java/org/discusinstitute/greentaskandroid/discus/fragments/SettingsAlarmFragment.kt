package org.discusinstitute.greentaskandroid.discus.fragments

import android.app.Notification
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_settings_alarm.*
import kotlinx.android.synthetic.main.fragment_settings_alarm.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.calendarPref
import org.discusinstitute.greentaskandroid.discus.receivers.NotificationPublisher
import org.discusinstitute.greentaskandroid.vendor.blauhaus.*

class SettingsAlarmFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_alarm, container, false)

        view.alarm_time_picker.setOnTimeChangedListener(object: TimePicker.OnTimeChangedListener {
            override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
                val calendar = getCalendar(getHour(alarm_time_picker), getMinute(alarm_time_picker))
                model.saveAlarmTime(calendar)
                setAlarm(activity!!, calendar, NotificationPublisher.pendingIntent(activity!!))
            }
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setTime(alarm_time_picker, getCalendarPref(activity!!, getCalendar(), calendarPref))
    }
}

