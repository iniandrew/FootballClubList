package com.andrew.footballclublist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.view.*

class FootballClubAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) : RecyclerView.Adapter<FootballClubAdapter.FootballClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballClubViewHolder {
        return FootballClubViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FootballClubViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class FootballClubViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            itemView.tv_clubName.text = items.name
            items.image?.let {
                Picasso.get().load(it).fit().into(itemView.img_club)
            }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}