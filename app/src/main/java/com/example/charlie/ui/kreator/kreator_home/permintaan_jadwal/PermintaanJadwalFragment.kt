package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.FragmentPermintaanJadwalBinding
import com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.adapter.RequestAdapter

class PermintaanJadwalFragment : Fragment() {
    private var _binding: FragmentPermintaanJadwalBinding? = null
    private val binding get() = _binding!!

    private val mRequestAdapter: RequestAdapter by lazy {
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
        RateCardClient().getAllRequest().addSnapshotListener{ snapshot,error ->
            if (error!= null) {
                Log.e("PermintaanJadwalFragment", "LoadData: ${error.message}", error)
            }
            val list = arrayListOf<RequestRateCard?>()
            snapshot?.documents?.forEach { doc ->
                val data = doc.toObject(RequestRateCard::class.java)
                if (data!!.status == "PENDING") {
                    val newData = data?.copy(id = doc.id)
                    list.add(newData)
                }
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