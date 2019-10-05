package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home_first_run.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment
import org.discusinstitute.greentaskandroid.vendor.blauhaus.RenderTime


class HomeFragmentFirstRun : IndexActivityBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_first_run, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.signedIn.observe(viewLifecycleOwner, Observer {
                loggedIn -> if(!loggedIn) {
           listener?.navigateSignIn()
        }})

        model.currentAlarmTime.observe(viewLifecycleOwner, Observer {
            val timeString = RenderTime.hourMinuteString(it) + RenderTime.amPMString(it)
            val text = String.format(resources.getString(R.string.first_run_text), timeString)
            first_task.text = text
        })

    }

}
