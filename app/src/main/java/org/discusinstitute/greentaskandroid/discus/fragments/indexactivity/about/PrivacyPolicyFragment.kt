package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class PrivacyPolicyFragment : IndexActivityBaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_privacy_policy, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}