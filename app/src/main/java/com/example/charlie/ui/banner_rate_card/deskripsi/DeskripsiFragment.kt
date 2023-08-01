package com.example.charlie.ui.banner_rate_card.deskripsi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.R
import com.example.charlie.databinding.FragmentBannerRateCardBinding
import com.example.charlie.databinding.FragmentDeskripsiBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DeskripsiFragment : BottomSheetDialogFragment() {
    private var _binding : FragmentDeskripsiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentDeskripsiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}