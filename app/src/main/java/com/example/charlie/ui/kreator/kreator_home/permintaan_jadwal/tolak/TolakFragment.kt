package com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.tolak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.charlie.R
import com.example.charlie.data.firebase.RateCardClient
import com.example.charlie.databinding.FragmentTerimaBinding
import com.example.charlie.databinding.FragmentTolakBinding
import com.example.charlie.ui.kreator.kreator_home.permintaan_jadwal.terima.TerimaFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TolakFragment : BottomSheetDialogFragment() {
    companion object {
        private const val REQUEST_ID = "request_id"
        fun newInstance(requestId: String): TolakFragment {
            val bundle = Bundle()
            bundle.putString(REQUEST_ID, requestId)
            val fragment = TolakFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
    private var _binding: FragmentTolakBinding? = null
    private val binding get() = _binding!!

    private val requestId: String by lazy {
        arguments?.getString(TerimaFragment.REQUEST_ID) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTolakBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnKirim.setOnClickListener {
                RateCardClient().updateRequestStatus(requestId, "REJECTED")
                    .addOnSuccessListener {
                        Toast.makeText(
                            binding.root.context,
                            "Permintaan ditolak",
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