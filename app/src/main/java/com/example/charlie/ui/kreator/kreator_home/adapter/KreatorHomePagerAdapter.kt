package com.example.charlie.ui.kreator.kreator_home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.PermintaanJadwalFragment
import com.example.charlie.ui.kreator.kreator_home.sesi_terjadwal.SesiTerjadwalFragment

class KreatorHomePagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(
    fm, lifecycle
) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                SesiTerjadwalFragment()
            }
            1 -> {
                PermintaanJadwalFragment()
            }
            else -> {
                SesiTerjadwalFragment()
            }
        }
    }
}