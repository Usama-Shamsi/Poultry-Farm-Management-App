package com.example.farm_application_2.ui.egg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farm_application_2.databinding.FragmentEggBinding
import com.example.farm_application_2.databinding.FragmentHomeBinding

class EggFragment : Fragment() {

    private var _binding: FragmentEggBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val eggViewModel =
            ViewModelProvider(this).get(EggViewModel::class.java)

        _binding = FragmentEggBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textEgg
        eggViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}