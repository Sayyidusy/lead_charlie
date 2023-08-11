package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.day

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charlie.databinding.ItemDayBinding

class DayAdapter(private val listener:DayListener):ListAdapter<DayItemModel, DayViewHolder>(DayDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(getItem(position),listener)
    }

    interface DayListener {
        fun onItemClicked(data: DayItemModel)
    }
}