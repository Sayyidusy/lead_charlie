package com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.FragmentJadwalTersediaBinding
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.day.DayAdapter
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.day.DayItemModel
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time.TimeAdapter
import com.example.charlie.ui.audiens.rate_card_schedule.jadwal_tersedia.adapter.time.TimeItemModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class JadwalTersediaFragment() : Fragment(), TimeAdapter.TimeListener, DayAdapter.DayListener {
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
    private val mDayAdapter = DayAdapter(this)
    private val mTimeAdapter = TimeAdapter(this)
    private val listTime = mutableListOf<TimeItemModel>()
    private val listDay = mutableListOf<DayItemModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJadwalTersediaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapterDay()
        setupAdapterTime()
        loadData()
        binding.apply {
            btnBooking.setOnClickListener {
                val time = listTime.find { it.isSelected }
                val date = listDay.find { it.isSelected }
                if (time != null && date != null) {
                    val newRequest = RequestRateCard(
                        rate_card_id = rateCardId,
                        date = "${date.date}/${date.month}/2023",
                        time = time.time,
                        status = "ACCEPTED"
                    )
                    RateCardClient().addRequest(newRequest).addOnSuccessListener {
                        Toast.makeText(requireContext(), "Berhasil booking", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(requireContext(), "Gagal booking jadwal", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(requireContext(), "Pilih waktu dan tanggal terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun loadData() {
        RateCardClient().getRateCard(rateCardId!!).addOnSuccessListener {
            val data = it.toObject(RateCard::class.java)
            val newData = data?.copy(id = it.id)
            newData?.available_dates?.forEach { fullDate ->
                val dateArray = fullDate.split("/")
                val date = dateArray[0]
                val month = dateArray[1]
                val day = getDay(fullDate)
                val dayItem = DayItemModel(
                    day = day,
                    date = date,
                    month = month,
                    isSelected = false,
                )
                listDay.add(dayItem)
            }
            newData?.available_times?.forEach { time ->
                val parts = time.split(".")
                val hour = parts[0].toInt()
                val minute = parts[1].toInt()

                val timeString = String.format("%02d.%02d", hour, minute)
                val timeItem = TimeItemModel(
                    id = listTime.size,
                    time = timeString,
                    isSelected = false
                )
                listTime.add(timeItem)
            }
            mDayAdapter.submitList(listDay)
            Log.d("JadwalTersediaFragment", "submitList(loadData): $listTime")
            mTimeAdapter.submitList(listTime)
        }.addOnFailureListener {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
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

    private fun setupAdapterDay() {
        binding.apply {
            rvDay.apply {
                adapter = mDayAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
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

    override fun onItemClicked(data: TimeItemModel) {
        Log.d("IsSelected di array", "onItemClicked: id=${data.id},time=${data.time}, isSelected=${data.isSelected}")
        listTime.onEachIndexed { index, it ->
            if (it.id == data.id) {
                listTime[index] = it.copy(isSelected = true)
            } else if (it.isSelected) {
                listTime[index] = it.copy(isSelected = false)
            }
        }

        Log.d("JadwalTersediaFragment", "submitList(onItemClicked): $listTime")
        mTimeAdapter.submitList(listTime.toList())
    }

    override fun onItemClicked(data: DayItemModel) {
        listDay.onEachIndexed { index, it ->
            if (it.date == data.date) {
                listDay[index] = it.copy(isSelected = true)
            } else if (it.isSelected) {
                listDay[index] = it.copy(isSelected = false)
            }
        }
        mDayAdapter.submitList(listDay.toList())
    }
}
