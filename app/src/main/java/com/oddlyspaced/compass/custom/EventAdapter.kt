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
import com.oddlyspaced.compass.modal.EventItem

class EventAdapter(private val list: ArrayList<EventItem>): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemEventBinding.bind(itemView)
        val event = binding.event
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.itemView.context.let { context ->
            holder.event.setOnClickListener {
                context.startActivity(Intent(context, EventDetailActivity::class.java))
            }
        }
        val item = list[position]
        holder.event.title = item.title
        holder.event.location = item.location
        holder.event.time = item.timing
        holder.event.logo = item.img
    }

    override fun getItemCount(): Int = list.size
}