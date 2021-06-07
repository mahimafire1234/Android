package com.example.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var et:EditText
    private lateinit var et1:EditText
    private lateinit var btnAdd:Button
    private lateinit var tvresult:TextView
    private lateinit var rdsum:RadioButton
    private lateinit var rdsub:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         et=findViewById(R.id.et)
         et1=findViewById(R.id.et1)
         tvresult=findViewById(R.id.tvresult)
         btnAdd=findViewById(R.id.btnAdd)
        rdsum=findViewById(R.id.rdsum)
            rdsub=findViewById(R.id.rdsub)

        val hi="hi";
        btnAdd.setOnClickListener {
            val first:Int=et.text.toString().toInt()
            val second:Int=et1.text.toString().toInt()
//text validation
            if(TextUtils.isEmpty(et.text)){
                et.error="Enter first num"
                et.requestFocus()
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(et1.text)){
                et1.error="Enter second num"
                et1.requestFocus()
                return@setOnClickListener
            }
            if(rdsum.isChecked){
                addNum(first,second)
            }else{
                subNum(first, second)
            }
        }
    }
    private fun addNum(first:Int,second:Int){
        val result=first+second
        tvresult.text=result.toString()
        Toast.makeText(this@MainActivity,"Sum is $result",Toast.LENGTH_SHORT).show();
    }
    private fun subNum(first:Int,second:Int){
        val result=first-second
        tvresult.text=result.toString()
        Toast.makeText(this@MainActivity,"Subtraction is $result",Toast.LENGTH_SHORT).show();
    }
}