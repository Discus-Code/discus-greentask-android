package org.discusinstitute.greentaskandroid.discus.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.widget_loading_progress_bar.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.data.AppViewModel
import org.discusinstitute.greentaskandroid.discus.defaultAlarmHour
import org.discusinstitute.greentaskandroid.discus.defaultAlarmMinute
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment


class IndexActivity : AppCompatActivity(),
    IndexActivityBaseFragment.FragmentInteractionListener {
    val TAG = "INDEX_ACTIVITY"
    lateinit var navController: NavController
    lateinit var model: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = ViewModelProviders.of(this).get(AppViewModel::class.java)
        setContentView(R.layout.activity_index)

        navController = findNavController(R.id.nav_host_fragment)

        profile_btn.setOnClickListener{ navigateProfile() }

        logo_button.setOnClickListener{ navigateHome() }

        logotype.setOnClickListener{ navigateHome() }

        home_btn.setOnClickListener{ navigateHome() }

        settings_btn.setOnClickListener{navigateSettings() }

        about_btn.setOnClickListener{navigateAbout()}

        model.isFirstRun.observe(this, Observer {
            if (it == true || it == null) {
                GlobalScope.launch {
                 onFirstRun()
                }
            } else {
                model.reEstablishAlarmFromStoredAlarmTime()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        navigateHome()
    }

    override fun showProgressBar() {
        loadingProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        loadingProgressBar.visibility = View.GONE
    }

    override fun showSnackbar(message: String) {
        Snackbar.make(loadingProgressBar, message, Snackbar.LENGTH_INDEFINITE)
            .show();
    }

    override fun hideSoftKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm!!.hideSoftInputFromWindow(main_layout.getWindowToken(), 0)
    }

    override fun navigateHome(firstRun:Boolean) {
        if(firstRun) {
            navController.navigate(R.id.action_global_homeFragmentFirstRun)
        } else {
            navController.navigate(R.id.action_global_homeFragment)
        }
        home_btn.setImageResource(R.drawable.ic_home_green_24dp)
        profile_btn.setImageResource(R.drawable.ic_person_black_24dp)
        settings_btn.setImageResource(R.drawable.ic_settings_black_24dp)
        about_btn.setImageResource(R.drawable.ic_discuslogo)
    }

    override fun navigateSettings() {
        navController.navigate(R.id.action_global_settingsFragment)
        home_btn.setImageResource(R.drawable.ic_home_black_24dp)
        profile_btn.setImageResource(R.drawable.ic_person_black_24dp)
        settings_btn.setImageResource(R.drawable.ic_settings_green_24dp)
        about_btn.setImageResource(R.drawable.ic_discuslogo)
    }

    override fun navigateProfile() {
        navController.navigate(R.id.action_global_profileFragment)
        home_btn.setImageResource(R.drawable.ic_home_black_24dp)
        profile_btn.setImageResource(R.drawable.ic_person_green_24dp)
        settings_btn.setImageResource(R.drawable.ic_settings_black_24dp)
        about_btn.setImageResource(R.drawable.ic_discuslogo)
    }

    override fun navigateAbout() {
        navController.navigate(R.id.action_global_aboutFragment)
        home_btn.setImageResource(R.drawable.ic_home_black_24dp)
        profile_btn.setImageResource(R.drawable.ic_person_black_24dp)
        settings_btn.setImageResource(R.drawable.ic_settings_black_24dp)
        about_btn.setImageResource(R.drawable.ic_discuslogo_green)
    }

    override fun navigateSignIn() {
        navController.navigate(R.id.action_global_signInFragment)
        home_btn.setImageResource(R.drawable.ic_home_black_24dp)
        profile_btn.setImageResource(R.drawable.ic_person_black_24dp)
        settings_btn.setImageResource(R.drawable.ic_settings_black_24dp)
        about_btn.setImageResource(R.drawable.ic_discuslogo)
    }

    suspend fun onFirstRun() {
        model.setCurrentAlarmTime(defaultAlarmHour,defaultAlarmMinute)
        model.didFirstRun()
    }
}
