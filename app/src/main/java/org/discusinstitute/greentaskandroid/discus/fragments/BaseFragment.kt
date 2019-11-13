package org.discusinstitute.greentaskandroid.discus.fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import org.discusinstitute.greentaskandroid.vendor.blauhaus.BHSound
import org.discusinstitute.greentaskandroid.discus.data.Model

open class BaseFragment : Fragment() {

    lateinit var model: Model
    lateinit var navController: NavController
    var listener: FragmentInteractionListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model = Model(context!!)
        navController = findNavController()
    }


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
        fun navigateHome()
        fun navigateSettings()
        fun getTid():Int

    }





}