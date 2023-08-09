package com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.ItemSesiTerjadwalBinding

class SesiTerjadwalViewHolder (val binding: ItemSesiTerjadwalBinding) :ViewHolder(binding.root){
    fun bind(
        model: RequestRateCard,
    ){
        RateCardClient().getRateCard(model.rate_card_id.toString()).addOnSuccessListener {
            val rateCard = it.toObject(RateCard::class.java)!!
            val timeEnd: String = calculateTimeEnd(model.time, rateCard.duration)
            binding.apply {
                tvTitleRateCard.text = rateCard.title
                tvDescriptionRateCard.text = rateCard.desc
                tvDate.text = model.date
                tvTimeStart.text = model.time
                tvTimeEnd.text = timeEnd
                tvPrice.text = rateCard.price.toString()
            }
        }

    }

    private fun calculateTimeEnd(timeStart: String?, duration: Int?): String {
        val timeStartArray = timeStart!!.split(".")

        val hours = timeStartArray[0].toInt()
        val minutes = timeStartArray[1].toInt()

        val timeStartInMinutes = hours * 60 + minutes
        val timeEndInMinutes = timeStartInMinutes + duration!!

        val hourEnd = timeEndInMinutes / 60
        val minuteEnd = timeEndInMinutes % 60

        return String.format("%02d.%02d", hourEnd, minuteEnd)
    }
}