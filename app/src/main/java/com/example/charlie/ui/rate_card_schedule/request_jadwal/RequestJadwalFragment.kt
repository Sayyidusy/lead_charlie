package com.example.charlie.ui.rate_card_schedule.request_jadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.databinding.FragmentRateCardScheduleBinding
import com.example.charlie.databinding.FragmentRequestJadwalBinding

class RequestJadwalFragment : Fragment() {
    private var _binding : FragmentRequestJadwalBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRequestJadwalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply{

        }
    }

}