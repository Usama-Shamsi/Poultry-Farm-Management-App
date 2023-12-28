package com.example.farm_application_2.ui.bird

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farm_application_2.databinding.FragmentBirdBinding
import com.example.farm_application_2.databinding.FragmentDashboardBinding

class BirdFragment : Fragment() {

    private var _binding: FragmentBirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val birdViewModel =
            ViewModelProvider(this).get(BirdViewModel::class.java)

        _binding = FragmentBirdBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBird
        birdViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}