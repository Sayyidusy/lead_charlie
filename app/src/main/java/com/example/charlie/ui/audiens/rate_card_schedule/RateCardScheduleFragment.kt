package com.example.charlie.ui.audiens.rate_card_schedule

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.databinding.FragmentRateCardScheduleBinding
import com.example.charlie.ui.audiens.rate_card_schedule.adapter.RateCardPagerAdapter
import com.google.android.material.tabs.TabLayout

class RateCardScheduleFragment : Fragment() {
    private var _binding: FragmentRateCardScheduleBinding? = null

    private val binding get() = _binding!!

    private val mArgs: RateCardScheduleFragmentArgs by navArgs()

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
        loadData()
    }

    private fun loadData() {
        val rateCardId = mArgs.rateCardId
        RateCardClient().getRateCard(rateCardId).addOnSuccessListener {
            Log.d("RateCardScheduleFragment", "loadDataSnapshot: ${it.data}")
            val data = it.toObject(RateCard::class.java)
            binding.apply {
                tvDesc.text = data!!.desc
                tvTitle.text = data.title
                tvField.text = data.field
                tvKreatorName.text = data.creator_name
                tvDuration.text = data.duration.toString()
                Glide.with(requireContext()).load(data.image).transform(CenterCrop(), RoundedCorners(10)).into(ivRateCard)
            }
        }
    }

    private fun setupPager() {
        binding.apply {
            vpRateCardSchedule.adapter = RateCardPagerAdapter(childFragmentManager, lifecycle)
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