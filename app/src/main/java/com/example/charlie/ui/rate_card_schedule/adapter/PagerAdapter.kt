package com.example.charlie.ui.rate_card_schedule.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charlie.ui.rate_card_schedule.jadwal_tersedia.JadwalTersediaFragment
import com.example.charlie.ui.rate_card_schedule.request_jadwal.RequestJadwalFragment

class PagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                JadwalTersediaFragment()
            }
            1 -> {
                RequestJadwalFragment()
            }
            else -> {
                JadwalTersediaFragment()
            }
        }
    }

}