package com.example.mpt_ex

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mpt_ex.databinding.ActivityFrameBinding
import com.example.mpt_ex.databinding.ActivityMainBinding

class FrameActivity : AppCompatActivity() {

    lateinit var linear_RFG : LinearLayout
    lateinit var linear_RCP : LinearLayout
    lateinit var linear_SET : LinearLayout
    lateinit var btnToRFG : Button
    lateinit var btnToRCP : Button
    lateinit var btnToSET : Button
    lateinit var frameLayout : FrameLayout

    lateinit var binding : ActivityFrameBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        btnToRFG = findViewById(R.id.btnToRFG)
        btnToRCP = findViewById(R.id.btnToRCP)
        btnToSET = findViewById(R.id.btnToSET)


        binding = ActivityFrameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnToRFG.setOnClickListener {
            setFragmentRFG()
        }
        binding.btnToRCP.setOnClickListener {
            setFragmentRCP()
        }
        binding.btnToSET.setOnClickListener {
            setFragmentSET()
        }


        /*
        var Handle = intent.getIntExtra("Handle",0)
        if(Handle == 1){
            linear_RFG.visibility = View.VISIBLE
            btnToRFG.isEnabled = false
        }
        else if(Handle == 2){
            linear_RCP.visibility = View.VISIBLE
            btnToRCP.isEnabled = false
        }
        else if(Handle == 3){
            linear_SET.visibility = View.VISIBLE
            btnToSET.isEnabled = false
        }
        else{
            //예외처리
        }*/
    }
    var flag = 0
    private fun switchFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        when(flag){
            0 -> {
                transaction.add(R.id.frameLayout, FragmentRFG())
                flag = 1
            }
            1 -> {
                transaction.replace(R.id.frameLayout, FragmentRCP())
                flag = 2
            }
            2 -> {
                transaction.replace(R.id.frameLayout, FragmentSET())
                flag = 1
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }


    private fun setFragmentRFG() {
        val transaction = supportFragmentManager.beginTransaction().add(R.id.frameLayout, FragmentRFG())
        transaction.commit()
    }
    private fun setFragmentRCP() {
        val transaction = supportFragmentManager.beginTransaction().add(R.id.frameLayout, FragmentRCP())
        transaction.commit()
    }
    private fun setFragmentSET() {
        val transaction = supportFragmentManager.beginTransaction().add(R.id.frameLayout, FragmentSET())
        transaction.commit()
    }
    private fun removeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val frameLayout = supportFragmentManager.findFragmentById(R.id.frameLayout)
        transaction.remove(frameLayout!!)
        transaction.commit()
    }

}