package com.example.charlie.ui.audiens.kreator_profile.informasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.R
import com.example.charlie.databinding.FragmentInformasiBinding


class InformasiFragment : Fragment() {
    private var _binding : FragmentInformasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInformasiBinding.inflate(layoutInflater)
        return binding.root
    }

}