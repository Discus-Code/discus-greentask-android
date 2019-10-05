package org.discusinstitute.greentaskandroid.discus.fragments.soundalarmactivity


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_way_to_go.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.SoundAlarmActivityBaseFragment


class WayToGoFragment : SoundAlarmActivityBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_way_to_go, container, false)
        view.finish_btn.setOnClickListener{ activity?.finish() }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model.currentTask.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                model.addCompletedTask(it.id)
            }
        })
    }
}
