package com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.charlie.data.model.RequestRateCard

class SesiTerjadwalDiffUtil : DiffUtil.ItemCallback<RequestRateCard>() {
    override fun areItemsTheSame(oldItem: RequestRateCard, newItem: RequestRateCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RequestRateCard, newItem: RequestRateCard): Boolean {
        return oldItem == newItem
    }
}