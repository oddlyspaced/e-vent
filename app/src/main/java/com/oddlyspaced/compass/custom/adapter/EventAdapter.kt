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
        val item = list[position]

        holder.itemView.context.let { context ->
            holder.event.setOnClickListener {
                val activityOptionsCompat = activity?.let { activity ->
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, holder.event.getLogoImageView(), "detailsLogo")
                }
                val intent = Intent(context, EventDetailActivity::class.java).apply {
                    putExtra(EventDetailActivity.CLUB_LOGO, item.clubLogo)
                    putExtra(EventDetailActivity.CLUB_NAME, item.clubName)
                    putExtra(EventDetailActivity.EVENT_NAME, item.title)
                    putExtra(EventDetailActivity.EVENT_DATE, item.time)
                    putExtra(EventDetailActivity.EVENT_LOCATION, item.location)
                    putExtra(EventDetailActivity.EVENT_BANNER, item.banner)
                    putExtra(EventDetailActivity.EVENT_DESC, item.description)
                    putExtra(EventDetailActivity.REGIS_LINK, item.registrationLink)
                }
                context.startActivity(intent, activityOptionsCompat?.toBundle())
            }
        }
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
        holder.event.setEventLogo(item.clubLogo)
    }

    override fun getItemCount(): Int = list.size
}