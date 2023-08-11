package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charlie.databinding.FragmentMonthBinding
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.month.adapter.day.DayAdapter
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.month.adapter.day.DayItemModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MonthFragment : Fragment() {
    companion object {
        private const val ACTIVE_MONTH = "active_month"
        private const val ACTIVE_DATES = "active_dates"
        fun newInstance(month: Int, dates: ArrayList<String>): MonthFragment {
            val fragment = MonthFragment()
            val bundle = Bundle()
            bundle.putInt(ACTIVE_MONTH, month)
            bundle.putStringArrayList(ACTIVE_DATES, dates)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: FragmentMonthBinding? = null
    private val binding get() = _binding!!
    private val mDayAdapter by lazy {
        DayAdapter()
    }
    private val activeDates by lazy {
        arguments?.getStringArrayList(ACTIVE_DATES)
    }
    private val activeMonth by lazy {
        arguments?.getInt(ACTIVE_MONTH)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMonthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapterDay()
        loadData()
    }

    private fun loadData() {
        val monthName = "${getMonthName(activeMonth!!)} 2023"
        binding.apply {
            tvMonth.text = monthName
        }
        val listDay = arrayListOf<DayItemModel>()
        activeDates?.forEach { date ->
            val fullDate = "${date}/${activeMonth}/2023"
            val day = getDay(fullDate)
            val dayItem = DayItemModel(
                day = day,
                date = date,
                isSelected = false
            )
            listDay.add(dayItem)
        }
        mDayAdapter.submitList(listDay)
    }

    private fun setupAdapterDay() {
        binding.apply {
            rvDay.apply {
                adapter = mDayAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    private fun getMonthName(activeMonth: Int): String {
        return when (activeMonth) {
            1 -> "Januari"
            2 -> "Februari"
            3 -> "Maret"
            4 -> "April"
            5 -> "Mei"
            6 -> "Juni"
            7 -> "Juli"
            8 -> "Agustus"
            9 -> "September"
            10 -> "Oktober"
            11 -> "November"
            12 -> "Desember"
            else -> "Januari"
        }
    }

    private fun getDay(fullDate: String): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateFormatted: Date? = formatter.parse(fullDate)

        val calender = Calendar.getInstance()
        calender.time = dateFormatted!!

        val dayName = when (calender.get(Calendar.DAY_OF_WEEK)) {
            1 -> "Minggu"
            2 -> "Senin"
            3 -> "Selasa"
            4 -> "Rabu"
            5 -> "Kamis"
            6 -> "Jumat"
            7 -> "Sabtu"
            else -> "Minggu"
        }
        return dayName
    }
}