package com.example.charlie.ui.kreator_profile.layanan.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.charlie.data.model.RateCard

class RateCardDiffUtil:DiffUtil.ItemCallback<RateCard>() {
    override fun areItemsTheSame(oldItem: RateCard, newItem: RateCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RateCard, newItem: RateCard): Boolean {
        return oldItem == newItem
    }
}