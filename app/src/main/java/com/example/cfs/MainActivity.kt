package com.example.cfs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etxt : EditText = findViewById(R.id.etxt)
        val conv : Button = findViewById(R.id.button)
        val res : TextView = findViewById(R.id.textView)
        conv.setOnClickListener {
            val temp = etxt.text.toString()
            val temperature = temp.toDouble()
            val convertedTemperature = convertTemperature(temperature)
            res.text = "Result: $convertedTemperature"
        }
    }
    private fun convertTemperature(temperature: Double): String {
        val fahrenheit = (temperature * 9 / 5) + 32
        return String.format("%.2f°F", fahrenheit)
    }
}