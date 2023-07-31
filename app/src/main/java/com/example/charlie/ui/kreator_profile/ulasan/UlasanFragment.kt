package com.example.charlie.ui.kreator_profile.ulasan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.R
import com.example.charlie.databinding.FragmentLayananBinding
import com.example.charlie.databinding.FragmentUlasanBinding

class UlasanFragment : Fragment() {
    private var _binding : FragmentUlasanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUlasanBinding.inflate(layoutInflater)
        return binding.root
    }
}