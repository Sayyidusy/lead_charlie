package com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.databinding.FragmentKreatorHomeBinding
import com.example.charlie.databinding.FragmentSesiTerjadwalBinding

class SesiTerjadwalFragment : Fragment() {
    private var _binding : FragmentSesiTerjadwalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSesiTerjadwalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}