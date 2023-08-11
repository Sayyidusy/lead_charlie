package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.databinding.FragmentJadwalTersediaBinding
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.month.adapter.MonthPagerAdapter
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time.TimeAdapter
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time.TimeItemModel

class JadwalTersediaFragment() : Fragment() {
    companion object {
        const val RATE_CARD_ID = "rate_card_id"
        fun newInstance(id: String): JadwalTersediaFragment {
            val fragment = JadwalTersediaFragment()
            val bundle = Bundle()
            bundle.putString(RATE_CARD_ID, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: FragmentJadwalTersediaBinding? = null
    private val binding get() = _binding!!
    private val rateCardId by lazy {
        arguments?.getString(RATE_CARD_ID)
    }
    private val mTimeAdapter by lazy {
        TimeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJadwalTersediaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapterTime()
        loadData()
        setupPager()
    }

    private fun setupPager() {
        RateCardClient().getRateCard(rateCardId!!).addOnSuccessListener {
            val data = it.toObject(RateCard::class.java)
            val newData = data?.copy(id = it.id)
            val activeDatesByMonth: MutableMap<Int, ArrayList<String>> = mutableMapOf()

            newData?.available_dates?.forEach { fullDate ->
                val dateArray = fullDate.split("/")
                val date = dateArray[0]
                val month = dateArray[1]

                if (activeDatesByMonth[month.toInt()] == null) {
                    activeDatesByMonth[month.toInt()] = arrayListOf()
                }

                activeDatesByMonth[month.toInt()]?.add(date)
                Log.d(
                    "JadwalTersediaFragment",
                    "loadDataDates: tanggal=${date} bulan=${month} $activeDatesByMonth"
                )
            }
            val listActiveMonths = activeDatesByMonth.keys.toMutableList() as ArrayList<Int>
            Toast.makeText(
                requireContext(),
                "List Months: ${listActiveMonths}, ListActiveDates: $activeDatesByMonth",
                Toast.LENGTH_LONG
            ).show()
            binding.apply {
                vpDayMonth.adapter =
                    MonthPagerAdapter(
                        childFragmentManager,
                        lifecycle,
                        listActiveMonths,
                        activeDatesByMonth
                    )
            }
        }
    }


    private fun loadData() {
        RateCardClient().getRateCard(rateCardId!!).addOnSuccessListener {
            val listTime = arrayListOf<TimeItemModel>()
            val data = it.toObject(RateCard::class.java)
            val newData = data?.copy(id = it.id)

//            newData?.available_dates?.forEach { fullDate ->
//                val dateArray = fullDate.split("/")
//                val date = dateArray[0]
//                val month = dateArray[1]
//
//                if (activeDatesByMonth[month.toInt()] == null) {
//                    activeDatesByMonth[month.toInt()] = arrayListOf()
//                }
//
//                activeDatesByMonth[month.toInt()]?.add(date)
//                Log.d(
//                    "JadwalTersediaFragment",
//                    "loadDataDates: tanggal=${date} bulan=${month} $activeDatesByMonth"
//                )
//            }
            newData?.available_times?.forEach { time ->
                val parts = time.split(".")
                val hour = parts[0].toInt()
                val minute = parts[1].toInt()

                val timeString = String.format("%02d.%02d", hour, minute)
                val timeItem = TimeItemModel(
                    time = timeString,
                    isSelected = false,
                )
                listTime.add(timeItem)
            }
            mTimeAdapter.submitList(listTime)
        }.addOnFailureListener {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAdapterTime() {
        binding.apply {
            rvTime.apply {
                adapter = mTimeAdapter
                layoutManager = GridLayoutManager(requireContext(), 3)
            }
        }
    }

}
