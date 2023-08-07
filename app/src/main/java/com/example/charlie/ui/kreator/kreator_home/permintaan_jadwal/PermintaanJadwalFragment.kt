package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.databinding.FragmentKreatorHomeBinding
import com.example.charlie.databinding.FragmentPermintaanJadwalBinding

class PermintaanJadwalFragment : Fragment() {
    private var _binding : FragmentPermintaanJadwalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPermintaanJadwalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}