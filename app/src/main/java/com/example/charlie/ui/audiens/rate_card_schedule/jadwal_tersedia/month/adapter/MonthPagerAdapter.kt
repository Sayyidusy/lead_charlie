package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.month.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.month.MonthFragment

class MonthPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle,
    private val activeMonths: List<Int>,
    private val activeDatesByMonth: Map<Int, ArrayList<String>>
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        Log.d("MonthPagerAdapter", "getItemCount: ${activeMonths.size}")
        return activeMonths.size
    }

    override fun createFragment(position: Int): Fragment {
        val month :Int = activeMonths[position]
        val activeDates:ArrayList<String> = activeDatesByMonth[month] ?: arrayListOf()
        return MonthFragment.newInstance(month, activeDates)
    }
}