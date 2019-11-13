package org.discusinstitute.greentaskandroid.discus.fragments

import android.graphics.Outline
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.vendor.blauhaus.RenderTime

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home, container, false)

        view.settings_button.setOnClickListener{listener?.navigateSettings()}

        view.logo.outlineProvider = object: ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline!!.setOval(0,0, view!!.getWidth(), view.getHeight())
            }
        }
        view.logo.clipToOutline = true

        return view
    }

    override fun onResume() {
        super.onResume()
        var time = model.getAlarmTime()
        var timeString = RenderTime.renderTime(time)
        var templated = getString(R.string.welcome_text, timeString)
        welcome_message.text = templated
    }
}
