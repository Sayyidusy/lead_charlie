package com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.FragmentSesiTerjadwalBinding
import com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal.adapter.SesiTerjadwalAdapter

class SesiTerjadwalFragment : Fragment() {
    private var _binding: FragmentSesiTerjadwalBinding? = null
    private val binding get() = _binding!!

    private val mSesiTerjadwalAdapter: SesiTerjadwalAdapter by lazy { SesiTerjadwalAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSesiTerjadwalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        loadData()
    }

    private fun loadData() {
        RateCardClient().getAllRequest().addSnapshotListener() { snapshot, error ->
            if (error != null) {
                Log.e("SesiTerjadwalFragment", "LoadData: ${error.message}", error)
            }
            val list = arrayListOf<RequestRateCard?>()
            snapshot?.documents?.forEach{
                val data = it.toObject(RequestRateCard::class.java)
                if (data!!.status == "ACCEPTED") {
                    val newData = data.copy(id = it.id)
                    list.add(newData)
                }
            }
            mSesiTerjadwalAdapter.submitList(list)
        }
    }

    private fun setupAdapter() {
        binding.apply {
            rvSesiTerjadwal.adapter = mSesiTerjadwalAdapter
            rvSesiTerjadwal.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}