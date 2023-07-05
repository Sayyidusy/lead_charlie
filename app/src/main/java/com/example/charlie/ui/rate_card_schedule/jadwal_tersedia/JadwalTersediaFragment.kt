package com.example.charlie.ui.rate_card_schedule.jadwal_tersedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.databinding.FragmentJadwalTersediaBinding
import com.example.charlie.databinding.FragmentRateCardScheduleBinding

class JadwalTersediaFragment : Fragment() {
    private var _binding : FragmentJadwalTersediaBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJadwalTersediaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply{

        }
    }

}