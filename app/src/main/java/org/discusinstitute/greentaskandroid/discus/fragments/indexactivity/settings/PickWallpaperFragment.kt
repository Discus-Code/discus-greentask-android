package org.discusinstitute.greentaskandroid.discus.fragments.indexactivity.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_pick_wallpaper.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.adapters.WallpaperAdapter
import org.discusinstitute.greentaskandroid.discus.fragments.IndexActivityBaseFragment

class PickWallpaperFragment : IndexActivityBaseFragment() {
    lateinit var adapter: WallpaperAdapter
    private val layoutManager = GridLayoutManager(context,2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pick_wallpaper, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.also {

            adapter = WallpaperAdapter(model, this, listOf())
            val rv = wallpapers_rv as RecyclerView
            rv.adapter = adapter
            rv.layoutManager = layoutManager

        }

        model.wallpapers.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })

        model.currentWallpaper.observe(viewLifecycleOwner, Observer {
            adapter.setCurrentWallpaper(it)
        })
    }

}
