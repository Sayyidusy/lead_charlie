package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.terima

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.databinding.FragmentTerimaBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class TerimaFragment : BottomSheetDialogFragment() {
    companion object {
        const val REQUEST_ID = "request_id"
        fun newInstance(requestId: String): TerimaFragment {
            val bundle = Bundle()
            bundle.putString(REQUEST_ID, requestId)
            val fragment = TerimaFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: FragmentTerimaBinding? = null
    private val binding get() = _binding!!

    private val requestId: String by lazy {
        arguments?.getString(REQUEST_ID) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTerimaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnKirim.setOnClickListener {
                RateCardClient().updateRequestStatus(requestId, "ACCEPTED")
                    .addOnSuccessListener {
                        Toast.makeText(
                            binding.root.context,
                            "Permintaan diterima",
                            Toast.LENGTH_SHORT
                        ).show()
                        dismiss()
                    }.addOnFailureListener {
                        Toast.makeText(
                            binding.root.context,
                            "Gagal mengubah status",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
        }
    }
}