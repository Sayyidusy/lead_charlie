package com.example.charlie.ui.banner_rate_card.cara_pakai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.R
import com.example.charlie.databinding.FragmentCaraPakaiBinding
import com.example.charlie.databinding.FragmentDeskripsiBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CaraPakaiFragment : BottomSheetDialogFragment() {
    private var _binding : FragmentCaraPakaiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCaraPakaiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}