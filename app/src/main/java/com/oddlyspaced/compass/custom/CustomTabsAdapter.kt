package com.oddlyspaced.compass.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutTabBinding

class CustomTabsAdapter(private val items: MutableList<String>): RecyclerView.Adapter<CustomTabsAdapter.TabViewHolder>() {

    var active = 0
        set(value) {
            field = value
        }

    inner class TabViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = LayoutTabBinding.bind(itemView)
        val card = binding.cvCustomTab
        val text = binding.txCustomTab
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        return TabViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_tab, parent, false))
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        holder.text.text = items[position]
        holder.itemView.context.let { context ->
            when(position) {
                active -> {
                    holder.card.setCardBackgroundColor(context.getColor(R.color.accent))
                    holder.text.setTextColor(context.getColor(R.color.text_light))
                }
                else -> {
                    // inactive
                    holder.card.setCardBackgroundColor(context.getColor(R.color.background))
                    holder.text.setTextColor(context.getColor(R.color.text_dark))

                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

}