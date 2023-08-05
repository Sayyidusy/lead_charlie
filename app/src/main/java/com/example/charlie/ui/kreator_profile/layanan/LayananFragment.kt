package com.example.charlie.ui.kreator_profile.layanan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.databinding.FragmentLayananBinding
import com.example.charlie.ui.kreator_profile.KreatorProfileFragmentDirections
import com.example.charlie.ui.kreator_profile.layanan.adapter.RateCardAdapter

class LayananFragment : Fragment() {
    private var _binding: FragmentLayananBinding? = null
    private val binding get() = _binding!!

    private val mRateCardAdapter by lazy {
        RateCardAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLayananBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        setupAdapter()
        binding.apply {
            ibBanner.setOnClickListener {
                navigateToRateCardBanner()
            }
        }
    }

    private fun loadData() {
        RateCardClient().getAllRateCard().addOnSuccessListener {
            val list = arrayListOf<RateCard?>()
            Log.d("LayananFragment", "loadDataQuery: ${it.documents}")
            it.documents.forEach { doc ->
                Log.d("LayananFragment", "loadDataDoc: ${doc.data}")
                val data = doc.toObject(RateCard::class.java)
                list.add(data)
            }
            Log.d("LayananFragment", "loadDataList: ${list}")
            mRateCardAdapter.submitList(list)
        }.addOnFailureListener {
            Log.e("LayananFragment", "loadDataFailed: ${it.message}", it)
        }
    }

    private fun setupAdapter() {
        binding.apply {
            rvRateCard.layoutManager = LinearLayoutManager(requireContext())
            rvRateCard.adapter = mRateCardAdapter
        }
    }


    private fun navigateToRateCardBanner() {
        val direction =
            KreatorProfileFragmentDirections.actionKreatorProfileFragmentToRateCardBannerFragment3()
        findNavController().navigate(direction)
    }

}