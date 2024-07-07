package com.example.conversions.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.conversions.databinding.FragmentMassBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentMassBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentMassBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSlideshow
//        slideshowViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val submitMassButton: Button = binding.submitMass
        submitMassButton.setOnClickListener {

            val kgToLbInput: EditText = binding.kgToLbInput
            val kgToLbOutput: TextView = binding.kgToLbOutput
            kgToLbInput.text.toString().toDoubleOrNull()?.let {
                val pounds = it * 2.20462
                kgToLbOutput.text = String.format("%.2f", pounds)
            }

            val lbToKgInput: EditText = binding.lbToKgInput
            val lbToKgOutput: TextView = binding.lbToKgOutput
            lbToKgInput.text.toString().toDoubleOrNull()?.let {
                val kilograms = it * 0.453592
                lbToKgOutput.text = String.format("%.2f", kilograms)
            }

            val gToOzInput: EditText = binding.gToOzInput
            val gToOzOutput: TextView = binding.gToOzOutput
            gToOzInput.text.toString().toDoubleOrNull()?.let {
                val ounces = it * 0.035274
                gToOzOutput.text = String.format("%.2f", ounces)
            }

            val ozToGInput: EditText = binding.ozToGInput
            val ozToGOutput: TextView = binding.ozToGOutput
            ozToGInput.text.toString().toDoubleOrNull()?.let {
                val grams = it * 28.3495
                ozToGOutput.text = String.format("%.2f", grams)
            }

            val galToQtInput: EditText = binding.galToQtInput
            val galToQtOutput: TextView = binding.galToQtOutput
            galToQtInput.text.toString().toDoubleOrNull()?.let {
                val quarts = it * 4
                galToQtOutput.text = String.format("%.2f", quarts)
            }

            val qtToPtInput: EditText = binding.qtToPtInput
            val qtToPtOutput: TextView = binding.qtToPtOutput
            qtToPtInput.text.toString().toDoubleOrNull()?.let {
                val pints = it * 2
                qtToPtOutput.text = String.format("%.2f", pints)
            }

            val ptToLInput: EditText = binding.ptToLInput
            val ptToLOutput: TextView = binding.ptToLOutput
            ptToLInput.text.toString().toDoubleOrNull()?.let {
                val liters = it * 0.473176
                ptToLOutput.text = String.format("%.2f", liters)
            }

            val lToMlInput: EditText = binding.lToMlInput
            val lToMlOutput: TextView = binding.lToMlOutput
            lToMlInput.text.toString().toDoubleOrNull()?.let {
                val milliliters = it * 1000
                lToMlOutput.text = String.format("%.2f", milliliters)
            }

            val mlToCupInput: EditText = binding.mlToCupInput
            val mlToCupOutput: TextView = binding.mlToCupOutput
            mlToCupInput.text.toString().toDoubleOrNull()?.let {
                val cups = it * 0.00422675
                mlToCupOutput.text = String.format("%.2f", cups)
            }

            val cupToLInput: EditText = binding.cupToLInput
            val cupToLOutput: TextView = binding.cupToLOutput
            cupToLInput.text.toString().toDoubleOrNull()?.let {
                val liters = it * 0.236588
                cupToLOutput.text = String.format("%.2f", liters)
            }
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}