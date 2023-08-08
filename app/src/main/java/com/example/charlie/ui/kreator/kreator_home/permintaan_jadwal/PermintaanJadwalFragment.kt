package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.FragmentKreatorHomeBinding
import com.example.charlie.databinding.FragmentPermintaanJadwalBinding
import com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.adapter.RequestAdapter

class PermintaanJadwalFragment : Fragment() {
    private var _binding : FragmentPermintaanJadwalBinding? = null
    private val binding get() = _binding!!

    private val mRequestAdapter : RequestAdapter by lazy {
        RequestAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPermintaanJadwalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        LoadData()
    }

    private fun LoadData() {
        RateCardClient().getAllRequest().addOnSuccessListener {
            val list = arrayListOf<RequestRateCard?>()
            it.documents.forEach { doc ->
                val data = doc.toObject(RequestRateCard::class.java)
                val newData = data?.copy(id = doc.id)
                list.add(newData)
            }
            mRequestAdapter.submitList(list)
        }
    }

    private fun setupAdapter() {
        binding.apply {
            rvRequestRateCard.layoutManager = LinearLayoutManager(requireContext())
            rvRequestRateCard.adapter = mRequestAdapter
        }
    }

}