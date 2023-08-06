package com.example.charlie.ui.kreator_profile.layanan.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.data.model.RateCard
import com.example.charlie.databinding.ItemRateCardBinding

class RateCardViewHolder(val binding: ItemRateCardBinding):ViewHolder(binding.root){
    fun bind(
        model: RateCard,
        listener: RateCardAdapter.RateCardItemListener
    ){
        binding.apply {
            tvTitleRateCard.text = model.title
            tvDurasi.text = model.duration.toString()
            tvRp.text = model.price.toString()

            cvRateCard.setOnClickListener {
                listener.onItemClicked(model)
            }
        }
    }
}