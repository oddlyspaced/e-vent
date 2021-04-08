package com.oddlyspaced.compass.custom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.activity.EventDetailActivity
import com.oddlyspaced.compass.databinding.ItemEventBinding

class EventAdapter(): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemEventBinding.bind(itemView)
        val event = binding.event
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.event.setOnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context, EventDetailActivity::class.java))
        }
    }

    override fun getItemCount(): Int = 5
}