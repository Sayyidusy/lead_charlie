package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charlie.databinding.ItemDayBinding
import com.example.charlie.databinding.ItemTimeBinding

class TimeAdapter():ListAdapter<TimeItemModel, TimeViewHolder>(TimeDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        return TimeViewHolder(
            ItemTimeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}