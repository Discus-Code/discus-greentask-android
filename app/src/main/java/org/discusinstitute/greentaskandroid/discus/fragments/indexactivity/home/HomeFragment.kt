package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class HomeFragment : IndexActivityBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        view.root_layout.visibility = View.GONE
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.signedIn.observe(viewLifecycleOwner, Observer {
                loggedIn ->
            if(!loggedIn) {
                listener?.navigateSignIn()
                root_layout.visibility = View.GONE
            } else {
                root_layout.visibility = View.VISIBLE
            }
        })

        model.completedTaskCount.observe(viewLifecycleOwner, Observer {
            count -> if (count == 0) {
            listener?.navigateHome(true)
        }})


        model.getUserFirstName().observe(viewLifecycleOwner, Observer {
                name ->
            if (name != null) {
                hello.text = "Hello ${name}"
            }

        })

        model.completedTaskCount.observe(viewLifecycleOwner, Observer {
                n ->
            number_of_tasks.text = n.toString()
            if (n ==0) {
               good_work.visibility = View.GONE
            }
        })




    }



    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
