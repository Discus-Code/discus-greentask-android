package org.discusinstitute.greentaskandroid.discus.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

import org.discusinstitute.greentaskandroid.R

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : BaseFragment() {

    var tid = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_detail, container, false)

        tid = listener?.getTid() ?: 1

        return view
    }

    override fun onResume() {
        super.onResume()
        var task = model.getTask(tid)
        action_factoid.text = task?.factoid
        action_name.text = task?.action_name
        action_text.text = task?.action_text

    }

}
