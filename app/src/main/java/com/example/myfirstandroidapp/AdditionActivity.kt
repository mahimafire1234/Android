package com.example.myfirstandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AdditionActivity : AppCompatActivity() {
    private lateinit var et: EditText
    private lateinit var et1: EditText
    private lateinit var btnAdd: Button
    private lateinit var tvresult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        et=findViewById(R.id.et)
        et1=findViewById(R.id.et1)
        tvresult=findViewById(R.id.tvresult)
        btnAdd=findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            alertshow();
        }
    }

    private fun alertshow(){
        val builder=AlertDialog.Builder(this);
        builder.setTitle("Addition");

        builder.setMessage("Do you want to add?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("Yes"){
            _,_->
            val num1=et.text.toString().toInt();
            val num2=et1.text.toString().toInt();

            val result=num1+num2;
            tvresult.text=result.toString();

//            open activity
            var intent=Intent(this,ListActivity::class.java);
            intent.putExtra("output",result);
            startActivity(intent);
        };

        builder.setNegativeButton("No"){
            _,_->
            Toast.makeText(this, "clicked no", Toast.LENGTH_SHORT).show()
        }
        val alert=builder.create();
        alert.setCancelable(false);
        alert.show();
    }
}