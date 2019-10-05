package org.discusinstitute.greentaskandroid.discus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.discus.data.AppViewModel
import org.discusinstitute.greentaskandroid.discus.data.Wallpaper

class WallpaperAdapter(val model: AppViewModel, val context: Fragment, private var dataset: List<Wallpaper>) :
    RecyclerView.Adapter<WallpaperAdapter.MyViewHolder>() {
    private var currentWallpaper: Wallpaper? = null


    class MyViewHolder(val view: ImageView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WallpaperAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_wallpaper, parent, false) as ImageView
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val wallpaper = dataset.get(position)
        val view = holder.view as ImageView

        view.setOnClickListener{v -> onRvItemClick(position)}

        Glide
            .with(context)
            .load(wallpaper.url)
            .centerInside()
            .placeholder(R.drawable.ic_settings_black_24dp)
            .into(holder.view as ImageView)

        if (wallpaper.id == currentWallpaper?.id) {
            view.setBackgroundColor(ContextCompat.getColor(holder.view.context, R.color.colorHighlighted))
        } else {
            view.setBackgroundColor(ContextCompat.getColor(holder.view.context, R.color.stepDownFromHighlighted))
        }
    }

    override fun getItemCount() = dataset.size

    public fun setItems(items: List<Wallpaper>) {
        dataset = items
        notifyDataSetChanged()
    }

    private fun onRvItemClick(pos: Int) {
        val wallpaper = dataset.get(pos)
        model.setCurrentWallpaperId(wallpaper.id)
    }

    fun setCurrentWallpaper(wallpaper: Wallpaper) {
        currentWallpaper = wallpaper
        notifyDataSetChanged()
    }
}
