package org.discusinstitute.greentaskandroid.discus.fragments

import android.content.Context

open class SoundAlarmActivityBaseFragment: BaseFragment() {
    var listener: FragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement FragmentInteractionListener")
        }
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface FragmentInteractionListener {

    }
}