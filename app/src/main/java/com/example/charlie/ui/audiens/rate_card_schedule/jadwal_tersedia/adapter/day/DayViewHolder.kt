package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.day

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.databinding.ItemDayBinding

class DayViewHolder(val binding: ItemDayBinding) : ViewHolder(binding.root) {
    fun bind(
        model: DayItemModel,
        listener: DayAdapter.DayListener
    ) {
        binding.apply {
            tvDate.text = model.date
            itemView.isSelected = model.isSelected
            tvDay.text = model.day
            clHari.setOnClickListener {
                listener.onItemClicked(model)
            }
        }
    }
}