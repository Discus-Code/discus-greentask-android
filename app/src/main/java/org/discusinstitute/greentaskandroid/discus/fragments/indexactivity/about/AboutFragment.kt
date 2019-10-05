package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.about

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_about.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.activities.SoundAlarmActivity
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

val SUPPRESS_ALARM_FOR_DEBUGGING = "supress_alarm_for_debugging"

class AboutFragment : IndexActivityBaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        view.action_privacy_policy.setOnClickListener {
            findNavController().navigate(R.id.action_aboutFragment_to_privacyPolicyFragment)
        }

        view.secret_dot.setOnClickListener{
            var intent = Intent(activity, SoundAlarmActivity::class.java)
            intent.putExtra(SUPPRESS_ALARM_FOR_DEBUGGING, true)
            startActivity(intent)
        }

        view.secret_dot2.setOnClickListener{
            var intent = Intent(activity, SoundAlarmActivity::class.java)
             startActivity(intent)
        }

        return view
    }



}
