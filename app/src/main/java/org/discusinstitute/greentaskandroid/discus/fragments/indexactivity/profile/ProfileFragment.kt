package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.profile
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class ProfileFragment : IndexActivityBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(
            R.layout.fragment_profile,
            container,
            false)

        // prevent bfuc, see signedIn.observe below
        view.root_layout.visibility = View.GONE
        view.signout_btn.setOnClickListener{ navController.navigate(
            R.id.action_profileFragment_to_confirmLogoutFragment) }

        view.view_completed.setOnClickListener{navController.navigate(
            R.id.action_profileFragment_to_completedTasksFragment)}
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model.signedIn.observe(viewLifecycleOwner, Observer { loggedIn ->
            if (!loggedIn) {
                listener?.navigateSignIn()
                root_layout.visibility = View.GONE
            } else {
                root_layout.visibility = View.VISIBLE
            }
        })

        model.getUserFirstName().observe(viewLifecycleOwner, Observer{
            name -> username.text = name
        })

        model.completedTaskCount.observe(viewLifecycleOwner, Observer {
            count -> n_completed.text = count.toString()
        })
    }

}
