package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time

import androidx.recyclerview.widget.DiffUtil

class TimeDiffUtil:DiffUtil.ItemCallback<TimeItemModel>() {
    override fun areItemsTheSame(oldItem: TimeItemModel, newItem: TimeItemModel): Boolean {
        return oldItem.time == newItem.time
    }

    override fun areContentsTheSame(oldItem: TimeItemModel, newItem: TimeItemModel): Boolean {
        return oldItem == newItem
    }
}