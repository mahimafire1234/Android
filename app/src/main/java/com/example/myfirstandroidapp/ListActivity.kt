package com.example.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ListActivity : AppCompatActivity() {
    private lateinit var output:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        output=findViewById(R.id.output);

//        receive activity

        val result=intent.getIntExtra("output",0);
        output.text=result.toString();
    }
}