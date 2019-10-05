package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_pick_sound.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.adapters.SoundsAdapter
import org.discusinstitute.greentaskandroid.discus.data.Sound
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment


class PickSoundFragment : IndexActivityBaseFragment() {
    lateinit var adapter: SoundsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_pick_sound,
            container,
            false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val rv = sounds_rv as RecyclerView
        adapter = SoundsAdapter(model, soundmgr, listOf<Sound>())
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(context)

        model.sounds.observe(viewLifecycleOwner, Observer{sounds ->
           adapter.setItems(sounds)
        })

        model.currentSound.observe(viewLifecycleOwner, Observer { currentSound ->
            adapter.setCurrentSound(currentSound)
        })
    }
}

