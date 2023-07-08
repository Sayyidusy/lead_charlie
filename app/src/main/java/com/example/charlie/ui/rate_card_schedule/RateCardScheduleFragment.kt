package com.example.charlie.ui.rate_card_schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.charlie.databinding.FragmentRateCardScheduleBinding
import com.example.charlie.ui.rate_card_schedule.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayout

class RateCardScheduleFragment : Fragment() {
    private var _binding: FragmentRateCardScheduleBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRateCardScheduleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPager()
    }

    private fun setupPager() {
        binding.apply {
            vpRateCardSchedule.adapter = PagerAdapter(childFragmentManager, lifecycle)
            tlRateCard.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    vpRateCardSchedule.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
//                    vpRateCardSchedule.currentItem = tab!!.position
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
//                    vpRateCardSchedule.currentItem = tab!!.position
                }

            })
        }
    }

}