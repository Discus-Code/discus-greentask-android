package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.account


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class SignInFragment : IndexActivityBaseFragment() {
    val TAG = "SignInFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        view.username.addTextChangedListener(areOurTextFieldsNull)
        view.password.addTextChangedListener(areOurTextFieldsNull)

        view.username_signin_button.setOnClickListener{v -> doDummySignin()}

        //TODO signin with google/facebook.

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.signedIn.observe(viewLifecycleOwner, Observer {
            loggedIn -> if (loggedIn) {
                listener?.navigateHome()
            } else {
                Log.d(TAG, "not logged in")

            }
        })
    }

    fun doDummySignin() {
        model.setUserFirstName("Sam")
        model.signIn()
    }

    var areOurTextFieldsNull = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            username_signin_button.isEnabled = (password.text.isNotEmpty() && username.text.isNotEmpty()) }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
}
