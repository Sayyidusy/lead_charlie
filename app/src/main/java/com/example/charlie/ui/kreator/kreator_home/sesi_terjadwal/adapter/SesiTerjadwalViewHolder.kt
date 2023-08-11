package com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.ItemSesiTerjadwalBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SesiTerjadwalViewHolder (val binding: ItemSesiTerjadwalBinding) :ViewHolder(binding.root){
    fun bind(
        model: RequestRateCard,
        listener: SesiTerjadwalAdapter.SesiTerjadwalListener
    ){
        RateCardClient().getRateCard(model.rate_card_id.toString()).addOnSuccessListener {
            val rateCard = it.toObject(RateCard::class.java)!!
            val timeEnd: String = calculateTimeEnd(model.time, rateCard.duration)
            val fullDate = getStringDate(model.date)
            binding.apply {
                tvTitleRateCard.text = rateCard.title
                tvDescriptionRateCard.text = rateCard.desc
                tvDate.text = fullDate
                tvTimeStart.text = model.time
                tvTimeEnd.text = timeEnd
                tvPrice.text = rateCard.price.toString()
                btnLihatDetail .setOnClickListener {
                    listener.onItemClicked(model)
                }
            }
        }

    }
    private fun getStringDate(date: String?): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateFormatted : Date? = formatter.parse(date!!)

        val calender = Calendar.getInstance()
        calender.time = dateFormatted!!

        val dayName = when(calender.get(Calendar.DAY_OF_WEEK)){
            1 -> "Minggu"
            2 -> "Senin"
            3 -> "Selasa"
            4 -> "Rabu"
            5 -> "Kamis"
            6 -> "Jumat"
            7 -> "Sabtu"
            else -> "Minggu"
        }

        val monthName = when(calender.get(Calendar.MONTH)){
            0 -> "Januari"
            1 -> "Februari"
            2 -> "Maret"
            3 -> "April"
            4 -> "Mei"
            5 -> "Juni"
            6 -> "Juli"
            7 -> "Agustus"
            8 -> "September"
            9 -> "Oktober"
            10 -> "November"
            11 -> "Desember"
            else -> "Januari"
        }

        return "$dayName, ${calender.get(Calendar.DAY_OF_MONTH)} $monthName ${calender.get(Calendar.YEAR)}"
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