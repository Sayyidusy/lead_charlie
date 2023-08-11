package com.example.charlie.ui.audiens.kreator_profile.layanan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charlie.data.model.RateCard
import com.example.charlie.databinding.ItemRateCardBinding

class RateCardAdapter(
    private val listener: RateCardItemListener
) : ListAdapter<RateCard, RateCardViewHolder>(RateCardDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateCardViewHolder {
        return RateCardViewHolder(
            ItemRateCardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RateCardViewHolder, position: Int) {
        holder.bind(getItem(position),listener)
    }

    interface RateCardItemListener {
        fun onItemClicked(data: RateCard)
    }
}