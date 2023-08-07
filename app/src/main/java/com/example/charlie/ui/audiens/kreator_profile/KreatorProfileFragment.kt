package com.example.charlie.ui.audiens.kreator_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.charlie.databinding.FragmentKreatorProfileBinding
import com.example.charlie.ui.audiens.kreator_profile.adapter.KreatorProfilePagerAdapter
import com.google.android.material.tabs.TabLayout

class KreatorProfileFragment : Fragment() {
    private var _binding: FragmentKreatorProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKreatorProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPager()
    }


    private fun setupPager() {
        binding.apply {
            vpKreatorProfile.adapter = KreatorProfilePagerAdapter(childFragmentManager, lifecycle)
            tlKreatorProfile.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    vpKreatorProfile.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    vpKreatorProfile.currentItem = tab!!.position
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    vpKreatorProfile.currentItem = tab!!.position
                }
            })
        }
    }


}