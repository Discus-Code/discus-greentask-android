package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_confirm_logout.*
import kotlinx.android.synthetic.main.fragment_confirm_logout.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class ConfirmLogoutFragment : IndexActivityBaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_confirm_logout, container, false)

        view.confirm_signout.setOnClickListener{ doDummySignOut()}
        view.cancel_signout.setOnClickListener{ navController.navigateUp() }
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.signedIn.observe(viewLifecycleOwner, Observer { signedIn ->
            if (!signedIn) { listener?.navigateSignIn() }})

        model.getUserFirstName().observe(viewLifecycleOwner, Observer{
            name -> username.text = name
        })
    }

    //todo
    fun doDummySignOut() {
        model.signOut()
    }
}
