package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.ItemRequestRateCardBinding

class RequestViewHolder(val binding: ItemRequestRateCardBinding) : ViewHolder(binding.root) {
    fun bind(
        model: RequestRateCard,
    ) {
        if (model.status == "PENDING") {
            RateCardClient().getRateCard(model.rate_card_id.toString()).addOnSuccessListener {
                val rateCard: RateCard = it.toObject(RateCard::class.java)!!
                binding.apply {
                    tvTitleRateCard.text = rateCard.title
                    tvDurasi.text = rateCard.duration.toString()
                    tvPrice.text = rateCard.price.toString()
                    tvDate.text = model.date
                    tvTime.text = model.time
                }
            }
        }
    }
}