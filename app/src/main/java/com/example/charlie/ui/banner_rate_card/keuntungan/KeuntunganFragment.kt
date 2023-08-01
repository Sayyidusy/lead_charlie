package com.example.charlie.ui.banner_rate_card.keuntungan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.charlie.databinding.FragmentDeskripsiBinding
import com.example.charlie.databinding.FragmentKeuntunganBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class KeuntunganFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentKeuntunganBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeuntunganBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}