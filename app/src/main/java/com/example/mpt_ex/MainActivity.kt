package com.example.mpt_ex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnToFragment_RFG : Button
    lateinit var btnToFragment_RCP : Button
    lateinit var btnToFragment_SET : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToFragment_RFG = findViewById<Button>(R.id.btnToFragment_RFG)
        btnToFragment_RCP = findViewById<Button>(R.id.btnToFragment_RFG)
        btnToFragment_SET = findViewById<Button>(R.id.btnToFragment_RFG)

        btnToFragment_RFG.setOnClickListener {
            var intent = Intent(applicationContext, FrameActivity::class.java)
            //intent.putExtra("Handle", 1) //핸들값 1전달

            startActivity(intent)
        }
        btnToFragment_RCP.setOnClickListener {
            var intent = Intent(applicationContext, FrameActivity::class.java)
            //intent.putExtra("Handle",2) //핸들값 2전달

            startActivity(intent)
        }
        btnToFragment_SET.setOnClickListener {
            var intent = Intent(applicationContext, FrameActivity::class.java)
            //intent.putExtra("Handle",3) //핸들값 3전달

            startActivity(intent)
        }
    }
}