package com.example.charlie.ui.audiens.rate_card_schedule.request_jadwal

import android.R
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.data.model.RequestRateCard
import com.example.charlie.databinding.FragmentRequestJadwalBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class RequestJadwalFragment : Fragment() {
    private var _binding: FragmentRequestJadwalBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRequestJadwalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnTanggal.setOnClickListener {
                showDatePickerDialog()
            }
            clWaktu.setOnClickListener {
                showTimePickerDialog()
            }

            btnBooking.setOnClickListener {
                if (!(btnTanggal.text == "Pilih Tanggal")) {
                    val newRequest = RequestRateCard(
                        //ganti dengan id model rate card yang dipilih
                        rate_card_id = "ljsFAMfo47FDCBIWyD8C",
                        date = formatDate(btnTanggal.text.toString()),
                        time = "${tvJam.text}.${tvMenit.text}",
                        status = "PENDING"
                    )
                    RateCardClient().addRequest(newRequest).addOnSuccessListener {
                        Toast.makeText(
                            requireContext(),
                            "Berhasil booking jadwal",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }.addOnFailureListener {
                        Toast.makeText(requireContext(), "Gagal booking jadwal", Toast.LENGTH_SHORT)
                            .show()
                    }
                }else{
                    Toast.makeText(requireContext(), "Masukkan Tanggal dan Waktu", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            requireContext(),
            3,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.apply {
                    tvJam.text = String.format("%02d", hourOfDay)
                    tvMenit.text = String.format("%02d", minute)
                }
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }

    private fun showDatePickerDialog() {
        val tanggalHariIni: LocalDate = LocalDate.now()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val date = makeDateString(dayOfMonth, month, year)
                binding.apply {
                    btnTanggal.text = date
                }
            },
            tanggalHariIni.year,
            tanggalHariIni.monthValue-1,
            tanggalHariIni.dayOfMonth
        )
        datePickerDialog.show()
    }

    private fun makeDateString(dayOfMonth: Int, month: Int, year: Int): String {
        val monthInt = month + 1
        val monthString: String
        when (monthInt) {
            1 -> {
                monthString = "Januari"
            }

            2 -> {
                monthString = "Februari"
            }

            3 -> {
                monthString = "Maret"
            }

            4 -> {
                monthString = "April"
            }

            5 -> {
                monthString = "Mei"
            }

            6 -> {
                monthString = "Juni"
            }

            7 -> {
                monthString = "Juli"
            }

            8 -> {
                monthString = "Agustus"
            }

            9 -> {
                monthString = "September"
            }

            10 -> {
                monthString = "Oktober"
            }

            11 -> {
                monthString = "November"
            }

            12 -> {
                monthString = "Desember"
            }

            else -> {
                monthString = "Error"
            }
        }
        return "$dayOfMonth $monthString $year"
    }

    fun formatDate(inputDate: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("id", "ID"))
        val outputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy", Locale("id", "ID"))
        val date = LocalDate.parse(inputDate, inputFormatter)
        return outputFormatter.format(date)
    }

}