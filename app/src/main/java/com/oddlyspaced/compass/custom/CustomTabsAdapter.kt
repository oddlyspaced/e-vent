package com.oddlyspaced.compass.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutTabBinding
import com.oddlyspaced.compass.databinding.LayoutTabInactiveBinding

class CustomTabsAdapter(private val items: MutableList<String>, private val onClickTab: (Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private companion object {
        const val TYPE_ACTIVE = 1
        const val TYPE_INACTIVE = 0
    }
    var active = 0
        set(value) {
            field = value
            onClickTab(value)
            notifyDataSetChanged()
//            items.forEachIndexed { index, _ ->
//                notifyItemChanged(index)
//            }
//            notifyItemChanged(value)
        }

    inner class ActiveTabViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = LayoutTabBinding.bind(itemView)
        val text = binding.txCustomTab
    }

    inner class InactiveTabViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = LayoutTabInactiveBinding.bind(itemView)
        val text = binding.txCustomTab
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ACTIVE -> ActiveTabViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_tab, parent, false))
            TYPE_INACTIVE -> InactiveTabViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_tab_inactive, parent, false))
            else -> throw Exception("Unidentified Tab Type!")
        }
    }

    override fun getItemViewType(position: Int): Int = if (position == active) TYPE_ACTIVE else TYPE_INACTIVE

    override fun onBindViewHolder(hol: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        hol.itemView.setOnClickListener {
            active = position
            onClickTab(position)
        }
        when(hol.itemViewType) {
            TYPE_ACTIVE -> {
                val holder = hol as ActiveTabViewHolder
                holder.text.text = item
            }
            TYPE_INACTIVE -> {
                val holder = hol as InactiveTabViewHolder
                holder.text.text = item
            }
        }
    }

    override fun getItemCount(): Int = items.size

}