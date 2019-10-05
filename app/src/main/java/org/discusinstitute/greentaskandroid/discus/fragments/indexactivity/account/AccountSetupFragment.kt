package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.account

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult
import kotlinx.android.synthetic.main.fragment_account_setup.*
import kotlinx.android.synthetic.main.fragment_account_setup.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.vendor.blauhaus.testPassword
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment
import org.discusinstitute.greentaskandroid.discus.userAttributes
import org.discusinstitute.greentaskandroid.discus.userPool

class AccountSetupFragment : IndexActivityBaseFragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val TAG = "ACCOUNT_SETUP_FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  =inflater.inflate(R.layout.fragment_account_setup, container, false)
        view.submit_sign_up.setOnClickListener{ view ->
            listener?.hideSoftKeyboard()
            signUp()
        }
        return view
    }

    fun validate(): Boolean {
         val valid = !(TextUtils.isEmpty(username.text) ||
                TextUtils.isEmpty(password.text) ||
                 TextUtils.isEmpty(email.text))
        if (!valid) {
            listener?.showSnackbar("All fields are required")
        }
        return valid
    }

    fun testPassword():Boolean {
        var msg = testPassword(password.text.toString())
        if (msg.isNullOrEmpty()) {
            return true
        } else {
            listener?.showSnackbar(msg)
            return false
        }
    }


    val signupCallback = object: SignUpHandler {
        override fun onSuccess(user: CognitoUser?, signUpResult: SignUpResult?) {
            //TODO signup callback
            listener?.hideProgressBar()
            Toast.makeText(activity, "Successfull Signup", Toast.LENGTH_LONG).show()
        }

        override fun onFailure(exception: java.lang.Exception?) {
            listener?.hideProgressBar()
            listener?.showSnackbar(exception?.message ?: exception.toString())
            Log.d(TAG, "Unsuccesfull Signup: ${exception}")
        }
    }

    fun signUp () {

        if (validate() && testPassword()) {
            listener?.showProgressBar()
            userPool(getActivity()!!).signUpInBackground(
                username.text.toString(),
                password.text.toString(),
                userAttributes(username.text.toString(), email.text.toString(), password.text.toString()),
                null,
                signupCallback)
        }
    }
}