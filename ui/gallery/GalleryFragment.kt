package com.example.conversions.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.conversions.databinding.FragmentTemperatureBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentTemperatureBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentTemperatureBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val submitTemperatureButton: Button = binding.submitTemperature
        submitTemperatureButton.setOnClickListener {
            val cToFInput: EditText = binding.cToFInput
            val cToFOutput: TextView = binding.cToFOutput

            cToFInput.text.toString().toDoubleOrNull()?.let{
                val fahrenheit = it * 9 / 5 + 32
                cToFOutput.text = String.format("%.2f", fahrenheit)
            }

            val fToCInput: EditText = binding.fToCInput
            val fToCOutput: TextView = binding.fToCOutput

            fToCInput.text.toString().toDoubleOrNull()?.let{
                val celsius = (it - 32) * 5 / 9
                fToCOutput.text = String.format("%.2f", celsius)
            }

            val cToKInput: EditText = binding.cToKInput
            val cToKOutput: TextView = binding.cToKOutput

            cToKInput.text.toString().toDoubleOrNull()?.let{
                val kelvin = it + 273.15
                cToKOutput.text = String.format("%.2f", kelvin)
            }

            val kToCInput: EditText = binding.kToCInput
            val kToCOutput: TextView = binding.kToCOutput

            kToCInput.text.toString().toDoubleOrNull()?.let{
                val celsius = it - 273.15
                kToCOutput.text = String.format("%.2f", celsius)
            }

            val fToKInput: EditText = binding.fToKInput
            val fToKOutput: TextView = binding.fToKOutput

            fToKInput.text.toString().toDoubleOrNull()?.let{
                val kelvin = (it - 32) * 5 / 9 + 273.15
                fToKOutput.text = String.format("%.2f", kelvin)
            }

            val kToFInput: EditText = binding.kToFInput
            val kToFOutput: TextView = binding.kToFOutput

            kToFInput.text.toString().toDoubleOrNull()?.let{
                val fahrenheit = (it - 273.15) * 9 / 5 + 32
                kToFOutput.text = String.format("%.2f", fahrenheit)
            }



            // Add other conversions as necessary
        }


//        val textView: TextView = binding.textGallery
//        galleryViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}