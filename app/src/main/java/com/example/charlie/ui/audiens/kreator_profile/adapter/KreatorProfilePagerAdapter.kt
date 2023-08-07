package com.example.charlie.ui.audiens.kreator_profile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charlie.ui.audiens.kreator_profile.informasi.InformasiFragment
import com.example.charlie.ui.audiens.kreator_profile.layanan.LayananFragment
import com.example.charlie.ui.audiens.kreator_profile.sesi.SesiFragment
import com.example.charlie.ui.audiens.kreator_profile.ulasan.UlasanFragment

class KreatorProfilePagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                InformasiFragment()
            }

            1 -> {
                SesiFragment()
            }

            2 -> {
                LayananFragment()
            }

            3 -> {
                UlasanFragment()
            }

            else -> {
                InformasiFragment()
            }
        }
    }
}