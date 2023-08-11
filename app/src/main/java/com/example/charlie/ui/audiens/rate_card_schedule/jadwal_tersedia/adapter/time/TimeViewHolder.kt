package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.R
import com.example.charlie.databinding.ItemDayBinding
import com.example.charlie.databinding.ItemTimeBinding

class TimeViewHolder(val binding : ItemTimeBinding):ViewHolder(binding.root){
    fun bind(
        model: TimeItemModel,
        listener:TimeAdapter.TimeListener
    ){
        binding.apply {
            tvTime.text = model.time
            itemView.isSelected = model.isSelected
            Log.d("View Holder", "Id= ${model.id} Time= ${model.time} isSelected= ${model.isSelected}")
            tvTime.setOnClickListener {
                listener.onItemClicked(model)
            }
        }
    }
}