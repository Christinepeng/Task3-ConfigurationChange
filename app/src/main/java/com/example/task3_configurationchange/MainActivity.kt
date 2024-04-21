package com.example.task3_configurationchange

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private companion object {
        const val KEY_COUNTER = "counter"
        const val MAX_COUNTER_VALUE = 1000
    }

    private var counter = 0
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        counterTextView = findViewById(R.id.textView)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER)
            updateCounterText()
        }

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            if (counter < MAX_COUNTER_VALUE) {
                counter++
                updateCounterText()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNTER, counter)
        super.onSaveInstanceState(outState)
    }

    private fun updateCounterText() {
        counterTextView.text = counter.toString()
    }
}