package org.discusinstitute.greentaskandroid.discus.fragments.soundalarmactivity


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_sound_alarm.*
import kotlinx.android.synthetic.main.fragment_sound_alarm_landing.*
import kotlinx.android.synthetic.main.fragment_sound_alarm_landing.view.*
import kotlinx.android.synthetic.main.include_clock.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.SoundAlarmActivityBaseFragment
import org.discusinstitute.greentaskandroid.vendor.blauhaus.RenderTime
import org.discusinstitute.greentaskandroid.vendor.blauhaus.RenderTime.Companion.renderTime


class SoundAlarmLandingFragment : SoundAlarmActivityBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_sound_alarm_landing, container, false)
        view.completed_button.setOnClickListener{
            navController.navigate(R.id.action_soundAlarmLandingFragment_to_wayToGoFragment)}
        view.try_one_hour_button_small.setOnClickListener{ setAlarmForOneHour()}
        view.try_one_hour_button.setOnClickListener{ setAlarmForOneHour()}
        view.try_tonight_button_small.setOnClickListener{ setAlarmForTonight() }
        return view
    }

    private fun setAlarmForOneHour() {
        model.setAlarmForOneHourFromNow()
        val snackbar = Snackbar.make(activity!!.sound_alarm_layout, "Alarm set for one hour from now.", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK", {activity?.finish()})
        snackbar.show()

    }

    private fun setAlarmForTonight() {
        model.setAlarmToTonight()
        val snackbar = Snackbar.make(activity!!.sound_alarm_layout, "Alarm set for tonight.", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK", {activity?.finish()})
        snackbar.show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.currentAlarmTime.observe(viewLifecycleOwner, Observer { cal->
            renderTime(cal, alarm_time, alarm_am_pm)
            RenderTime.renderDay(cal, day_name)
        })

        model.currentTask.observe(viewLifecycleOwner, Observer { task ->
            activity_description.text = task?.task
            did_you_know_text.text = task?.didYouKnow
        })
    }

    private fun showTryTonight() {
        try_one_hour_button_small.visibility=View.VISIBLE
        try_tonight_button_small.visibility=View.VISIBLE
        try_one_hour_button.visibility = View.GONE
    }

    private fun hideTryTonight() {
        try_one_hour_button_small.visibility=View.GONE
        try_tonight_button_small.visibility=View.GONE
        try_one_hour_button.visibility = View.VISIBLE
    }
}
