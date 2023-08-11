package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.day

import androidx.recyclerview.widget.DiffUtil
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time.TimeItemModel

class DayDiffUtil:DiffUtil.ItemCallback<DayItemModel>() {
    override fun areItemsTheSame(oldItem: DayItemModel, newItem: DayItemModel): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: DayItemModel, newItem: DayItemModel): Boolean {
        return false
    }

    override fun getChangePayload(oldItem: DayItemModel, newItem: DayItemModel): Any? {
        return newItem
    }
}