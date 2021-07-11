package com.example.myfirstandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    private lateinit var btnArithmetic:Button
    private lateinit var btnSimpleInterest:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnArithmetic=findViewById(R.id.btnArithmetic)
        btnSimpleInterest=findViewById(R.id.btnSimpleInterest)

//        button click
        btnArithmetic.setOnClickListener {
            val intent= Intent(this,AdditionActivity::class.java)
            startActivity(intent)
        }

        btnSimpleInterest.setOnClickListener {
            val intent=Intent(this,CountryCapitalActivity::class.java);
            startActivity(intent);
        }

    }
}