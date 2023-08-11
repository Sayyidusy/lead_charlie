package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.ItemRequestRateCardBinding

class RequestAdapter(private val listener: RequestListener) :
    ListAdapter<RequestRateCard, RequestViewHolder>(RequestDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        return RequestViewHolder(
            ItemRequestRateCardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(getItem(position),listener)
    }

    interface RequestListener {
        fun onItemTerimaClicked(requestID: String)
        fun onItemTolakClicked(requestID: String)
    }

}