package com.example.conversions.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.conversions.databinding.FragmentDistanceBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentDistanceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentDistanceBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.distancePlaceholder
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Access your button from the binding

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}