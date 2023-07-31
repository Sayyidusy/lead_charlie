package com.example.charlie.ui.kreator_profile.layanan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.charlie.R
import com.example.charlie.databinding.FragmentLayananBinding
import com.example.charlie.ui.kreator_profile.KreatorProfileFragmentDirections

class LayananFragment : Fragment() {
    private var _binding : FragmentLayananBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLayananBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            ibBanner.setOnClickListener{
                navigateToRateCardBanner()
            }
        }
    }

    private fun navigateToRateCardBanner() {
        val direction = KreatorProfileFragmentDirections.actionKreatorProfileFragmentToRateCardBannerFragment3()
        findNavController().navigate(direction)
    }

}