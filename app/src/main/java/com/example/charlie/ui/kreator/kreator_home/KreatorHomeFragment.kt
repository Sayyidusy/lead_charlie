package com.example.charlie.ui.kreator.kreator_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.charlie.databinding.FragmentKreatorHomeBinding
import com.example.charlie.ui.kreator.kreator_home.adapter.KreatorHomePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class KreatorHomeFragment : Fragment() {
    private var _binding: FragmentKreatorHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKreatorHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPager()
    }

    private fun setupPager() {
        binding.apply {
            vpJadwal.adapter = KreatorHomePagerAdapter(childFragmentManager, lifecycle)
            tlJadwal.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    vpJadwal.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    vpJadwal.currentItem = tab.position
                }

                override fun onTabReselected(tab: TabLayout.Tab) {
                    vpJadwal.currentItem = tab.position
                }
            })
        }
    }

}