package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time

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
    ){
        binding.apply {
            tvTime.text = model.time
            if (model.isSelected) {
                tvTime.setBackgroundResource(R.drawable.button_purple)
                tvTime.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            } else {
                tvTime.setBackgroundResource(R.drawable.btn_jam_outline)
                tvTime.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            }
            tvTime.setOnClickListener {
                model.isSelected = !model.isSelected
                Toast.makeText(binding.root.context, "${model.isSelected}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}