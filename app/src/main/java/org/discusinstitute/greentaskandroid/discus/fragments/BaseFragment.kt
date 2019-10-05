package org.discusinstitute.greentaskandroid.discus.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import org.discusinstitute.greentaskandroid.vendor.blauhaus.BHSound
import org.discusinstitute.greentaskandroid.discus.data.AppViewModel

open class BaseFragment : Fragment() {
    lateinit var model: AppViewModel
    lateinit var navController: NavController
    val soundmgr = BHSound(MediaPlayer())

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model = ViewModelProviders.of(this).get(AppViewModel::class.java)

        navController = findNavController()
    }





}