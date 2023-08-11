package com.example.charlie.ui.kreator.schedule_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RateCard
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.FragmentVideoCallDetailBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class VideoCallDetailFragment : Fragment() {
    private var _binding: FragmentVideoCallDetailBinding? = null
    private val binding get() = _binding!!

    private val mArgs: VideoCallDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoCallDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            ibBack.setOnClickListener {
                navigateBack()
            }
        }
        loadData()
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }

    private fun loadData() {
        val requestId = mArgs.requestId
        RateCardClient().getRequest(requestId).addOnSuccessListener { requestDoc ->
            val requestData = requestDoc.toObject(RequestRateCard::class.java)
            RateCardClient().getRateCard(requestData?.rate_card_id!!)
                .addOnSuccessListener { rateCardDoc ->
                    val rateCardData = rateCardDoc.toObject(RateCard::class.java)
                    val timeEnd: String = calculateTimeEnd(requestData.time, rateCardData?.duration)
                    val fullDate = getStringDate(requestData.date)
                    binding.apply {
                        tvTitleRateCard.text = rateCardData?.title
                        tvDescriptionRateCard.text = rateCardData?.desc
                        tvDate.text = fullDate
                        tvTimeStart.text = requestData.time
                        tvTimeEnd.text = timeEnd
                        tvPrice.text = rateCardData?.price.toString()
                    }
                }
        }
    }

    private fun getStringDate(date: String?): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateFormatted: Date? = formatter.parse(date!!)

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

        val monthName = when (calender.get(Calendar.MONTH)) {
            0 -> "Januari"
            1 -> "Februari"
            2 -> "Maret"
            3 -> "April"
            4 -> "Mei"
            5 -> "Juni"
            6 -> "Juli"
            7 -> "Agustus"
            8 -> "September"
            9 -> "Oktober"
            10 -> "November"
            11 -> "Desember"
            else -> "Januari"
        }

        return "$dayName, ${calender.get(Calendar.DAY_OF_MONTH)} $monthName ${calender.get(Calendar.YEAR)}"
    }

    private fun calculateTimeEnd(timeStart: String?, duration: Int?): String {
        val timeStartArray = timeStart!!.split(".")

        val hours = timeStartArray[0].toInt()
        val minutes = timeStartArray[1].toInt()

        val timeStartInMinutes = hours * 60 + minutes
        val timeEndInMinutes = timeStartInMinutes + duration!!

        val hourEnd = timeEndInMinutes / 60
        val minuteEnd = timeEndInMinutes % 60

        return String.format("%02d.%02d", hourEnd, minuteEnd)
    }

}