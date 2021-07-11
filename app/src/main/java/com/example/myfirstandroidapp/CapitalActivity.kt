package com.example.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CapitalActivity : AppCompatActivity() {
    private lateinit var tvcapital:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capital)

        tvcapital=findViewById(R.id.tvcapital);
//        val result=intent.getStringExtra("country","0");
//        val result1=intent.getIntExtra("capital",0);
//        tvcapital.text="capital of $result";
    }
}