package com.oddlyspaced.compass.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutTagBinding

class CustomTagsAdapter(private val items: Array<String>): RecyclerView.Adapter<CustomTagsAdapter.TagViewHolder>() {

    inner class TagViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = LayoutTagBinding.bind(itemView)
        val text = binding.txCustomTag
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_tag, parent, false))
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.text.text = items[position]
    }

    override fun getItemCount(): Int = items.size

}