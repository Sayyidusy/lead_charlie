package com.example.charlie.ui.banner_rate_card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.charlie.databinding.FragmentBannerRateCardBinding
import com.example.charlie.ui.banner_rate_card.cara_pakai.CaraPakaiFragment
import com.example.charlie.ui.banner_rate_card.deskripsi.DeskripsiFragment
import com.example.charlie.ui.banner_rate_card.keuntungan.KeuntunganFragment

class RateCardBannerFragment : Fragment() {
    private var _binding : FragmentBannerRateCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBannerRateCardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnBeliRateCard.setOnClickListener {
                navigateToRateCardSchedule()
            }
            btnDeskripsiRateCard.setOnClickListener {
                DeskripsiFragment().show(childFragmentManager, "DeskripsiFragment")
            }
            btnKeuntunganRateCard.setOnClickListener {
                KeuntunganFragment().show(childFragmentManager, "KeuntunganFragment")
            }
            btnCaraPakaiRateCard.setOnClickListener {
                CaraPakaiFragment().show(childFragmentManager, "CaraPakaiFragment")
            }
        }

    }

    private fun navigateToRateCardSchedule() {
        val direction = RateCardBannerFragmentDirections.actionRateCardBannerFragmentToRateCardScheduleFragment()
        findNavController().navigate(direction)
    }


}