package com.oddlyspaced.compass.custom.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.activity.EventDetailActivity
import com.oddlyspaced.compass.databinding.ItemEventBinding
import com.oddlyspaced.compass.modal.EventItem

class EventAdapter(private val list: ArrayList<EventItem>, private val activity: Activity?): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var onClick: ((String) -> Unit)? = null
    private var onLongClick: ((String) -> Unit)? = null

    constructor(list: ArrayList<EventItem>, activity: Activity?, onClick: (String) -> Unit, onLongClick: (String) -> Unit): this(list, activity) {
        this.onClick = onClick
        this.onLongClick = onLongClick
    }

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
                val activityOptionsCompat = activity?.let { activity ->
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, holder.event.getLogoImageView(), "detailsLogo")
                }
                context.startActivity(Intent(context, EventDetailActivity::class.java), activityOptionsCompat?.toBundle())
            }
        }
        val item = list[position]
        holder.event.title = item.title
        holder.event.location = item.location
        holder.event.time = item.time
        onClick?.let {
            holder.event.onTagClicked = it
        }
        onLongClick?.let {
            holder.event.onTagLongClick = it
        }
        holder.event.tags = item.tags.toTypedArray()
//        holder.event.logo = item.img
    }

    override fun getItemCount(): Int = list.size
}