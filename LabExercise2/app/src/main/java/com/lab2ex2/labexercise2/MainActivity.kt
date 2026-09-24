package com.lab2ex2.labexercise2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var count = 0
    private var step = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvOutput: TextView = findViewById(R.id.tvOutput)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnReset: Button = findViewById(R.id.btnReset)
        val btnStep: Button = findViewById(R.id.btnStep)

        btnAdd.setOnClickListener {
            count += step
            tvOutput.text = count.toString() //add output
        }

        btnSubtract.setOnClickListener {
            count -= step
            tvOutput.text = count.toString() //subtract output
        }

        btnStep.setOnClickListener {
            step = if (step == 1) 2 else 1
        }

        btnReset.setOnClickListener {
            count = 0
            step = 1
            tvOutput.text = count.toString()  //reset
        }
    }
}