package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.ItemRequestRateCardBinding

class RequestViewHolder(val binding: ItemRequestRateCardBinding) : ViewHolder(binding.root) {
    fun bind(
        model: RequestRateCard,
        listener : RequestAdapter.RequestListener
    ) {
        RateCardClient().getRateCard(model.rate_card_id.toString()).addOnSuccessListener {
            val rateCard: RateCard = it.toObject(RateCard::class.java)!!
            binding.apply {
                tvTitleRateCard.text = rateCard.title
                tvDurasi.text = rateCard.duration.toString()
                tvPrice.text = rateCard.price.toString()
                tvDate.text = model.date
                tvTime.text = model.time
                btnTerima.setOnClickListener {
                    listener.onItemTerimaClicked(model.id.toString())
//                    RateCardClient().updateRequestStatus(model.id.toString(), "ACCEPTED")
//                        .addOnSuccessListener {
//                            Toast.makeText(
//                                binding.root.context,
//                                "Permintaan diterima",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }.addOnFailureListener {
//                            Toast.makeText(
//                                binding.root.context,
//                                "Gagal mengubah status",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
                }
                btnTolak.setOnClickListener {
                    listener.onItemTolakClicked(model.id.toString())
//                    RateCardClient().updateRequestStatus(model.id.toString(), "REJECTED")
//                        .addOnSuccessListener {
//                            Toast.makeText(
//                                binding.root.context,
//                                "Permintaan ditolak",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }.addOnFailureListener {
//                            Toast.makeText(
//                                binding.root.context,
//                                "Gagal mengubah status",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
                }
            }
        }
    }
}
