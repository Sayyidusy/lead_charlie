package com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.ItemSesiTerjadwalBinding

class SesiTerjadwalAdapter(private val listener: SesiTerjadwalListener) :
    ListAdapter<RequestRateCard, SesiTerjadwalViewHolder>(SesiTerjadwalDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SesiTerjadwalViewHolder {
        return SesiTerjadwalViewHolder(
            ItemSesiTerjadwalBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SesiTerjadwalViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface SesiTerjadwalListener {
        fun onItemClicked(data: RequestRateCard)
    }
}