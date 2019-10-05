package org.discusinstitute.greentaskandroid.discus.fragments

import android.content.Context

open class IndexActivityBaseFragment: BaseFragment() {
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
        fun showProgressBar()
        fun hideProgressBar()
        fun showSnackbar(message:String)
        fun hideSoftKeyboard()
        fun navigateHome(firstRun:Boolean=false)
        fun navigateProfile()
        fun navigateSettings()
        fun navigateAbout()
        fun navigateSignIn()
    }
}