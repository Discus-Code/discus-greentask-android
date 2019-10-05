package org.discusinstitute.greentaskandroid.discus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item_sound.view.*
import org.discusinstitute.greentaskandroid.R
import org.discusinstitute.greentaskandroid.vendor.blauhaus.BHSound
import org.discusinstitute.greentaskandroid.discus.data.AppViewModel
import org.discusinstitute.greentaskandroid.discus.data.Sound

class SoundsAdapter(val model: AppViewModel, val bhSound: BHSound, private var dataset: List<Sound>) :
    RecyclerView.Adapter<SoundsAdapter.MyViewHolder>() {
    private var currentSound: Sound? = null

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): SoundsAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_sound, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var sound = dataset.get(position)

        holder.view.name.text =   sound.name

        holder.view.setOnClickListener{onRvItemClick(position)}

        if (sound.id == currentSound?.id) {
            holder.view.setBackgroundColor(ContextCompat.getColor(holder.view.context, R.color.colorHighlighted))
        } else {
            holder.view.setBackgroundColor(0x00000000)
        }
    }

    override fun getItemCount() = dataset.size

    public fun setItems(items: List<Sound>) {
        dataset = items
        notifyDataSetChanged()
    }

    public fun setCurrentSound(currentSound: Sound) {
        this.currentSound = currentSound
        notifyDataSetChanged()
    }

    private fun onRvItemClick(pos: Int) {
        val sound = dataset.get(pos)
        var url = sound.url
        //bhSound.playFromUrl(url, 15)
        model.setCurrentSoundId(sound.id)
    }
}