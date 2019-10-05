package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class CompletedTasksFragment : IndexActivityBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed_tasks, container, false)
    }
}
