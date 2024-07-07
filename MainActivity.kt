package com.example.conversions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.conversions.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var submitDistanceButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val submitDistanceButton = findViewById<Button>(R.id.submit_distance)

        submitDistanceButton.setOnClickListener{

            val kmtomInput = findViewById<EditText>(R.id.km_to_m_input).text.toString().toDoubleOrNull()
            val mtokmInput = findViewById<EditText>(R.id.m_to_km_input).text.toString().toDoubleOrNull()


            if (kmtomInput != null) {
                val meters = kmtomInput * 1000
                findViewById<TextView>(R.id.km_to_m_output).text = meters.toString()
            }

            if (mtokmInput != null) {
                val kilometers = mtokmInput / 1000
                findViewById<TextView>(R.id.m_to_km_output).text = kilometers.toString()
            }

            val mToFtInput = findViewById<EditText>(R.id.m_to_ft_input)
            val mToFtOutput = findViewById<TextView>(R.id.m_to_ft_output)

            mToFtInput.text.toString().toDoubleOrNull()?.let {
                val feet = it * 3.28084
                mToFtOutput.text = String.format("%.2f", feet)
            }

            val cmToMInput = findViewById<EditText>(R.id.cm_to_m_input)
            val cmToMOutput = findViewById<TextView>(R.id.cm_to_m_output)
            val mToCmInput = findViewById<EditText>(R.id.m_to_cm_input)
            val mToCmOutput = findViewById<TextView>(R.id.m_to_cm_output)

            cmToMInput.text.toString().toDoubleOrNull()?.let {
                val meters = it / 100
                cmToMOutput.text = String.format("%.2f", meters)
            }

            mToCmInput.text.toString().toDoubleOrNull()?.let {
                val centimeters = it * 100
                mToCmOutput.text = String.format("%.0f", centimeters)
            }

            val inToFtInput = findViewById<EditText>(R.id.in_to_ft_input)
            val inToFtOutput = findViewById<TextView>(R.id.in_to_ft_output)
            val ftToInInput = findViewById<EditText>(R.id.ft_to_in_input)
            val ftToInOutput = findViewById<TextView>(R.id.ft_to_in_output)

            inToFtInput.text.toString().toDoubleOrNull()?.let {
                val feet = it / 12
                inToFtOutput.text = String.format("%.2f", feet)
            }

            ftToInInput.text.toString().toDoubleOrNull()?.let {
                val inches = it * 12
                ftToInOutput.text = String.format("%.0f", inches)
            }

            val ftToMInput = findViewById<EditText>(R.id.ft_to_m_input)
            val ftToMOutput = findViewById<TextView>(R.id.ft_to_m_output)

            ftToMInput.text.toString().toDoubleOrNull()?.let {
                val meters = it * 0.3048
                ftToMOutput.text = String.format("%.2f", meters)
            }

            val mToYdInput = findViewById<EditText>(R.id.m_to_yd_input).text.toString().toDoubleOrNull()
            mToYdInput?.let {
                val result = it * 1.09361
                findViewById<TextView>(R.id.m_to_yd_output).text = String.format("%.2f", result)
            }

            val ydToMInput = findViewById<EditText>(R.id.yd_to_m_input).text.toString().toDoubleOrNull()
            ydToMInput?.let {
                val result = it * 0.9144
                findViewById<TextView>(R.id.yd_to_m_output).text = String.format("%.2f", result)
            }


            val kmToMiInput = findViewById<EditText>(R.id.km_to_mi_input).text.toString().toDoubleOrNull()
            kmToMiInput?.let {
                val result = it * 0.621371
                findViewById<TextView>(R.id.km_to_mi_output).text = String.format("%.2f", result)
            }


            val miToKmInput = findViewById<EditText>(R.id.mi_to_km_input).text.toString().toDoubleOrNull()
            miToKmInput?.let {
                val result = it * 1.60934
                findViewById<TextView>(R.id.mi_to_km_output).text = String.format("%.2f", result)
            }



        }





            //--------------------------

        val emailButton = findViewById<FloatingActionButton>(R.id.fab)
        emailButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("coconutx453@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Subject")
                putExtra(Intent.EXTRA_TEXT, "Hey, ")
            }
            try {
                startActivity(Intent.createChooser(emailIntent, "Send email..."))
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "Try Again :(", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean
    {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}