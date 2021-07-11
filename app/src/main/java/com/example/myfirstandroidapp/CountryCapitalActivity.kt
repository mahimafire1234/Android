package com.example.myfirstandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast

class CountryCapitalActivity : AppCompatActivity() {
    private lateinit var list:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_capital)

        list=findViewById(R.id.list)


        val countries= mapOf<String,String>(
            "Nepal" to "ktm",
            "india" to "deli",
            "chana" to "beijing"
        )


        val adapter=ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries.keys.toTypedArray()
        )
        list.adapter=adapter;

        list.setOnItemClickListener { adapter, view, position, id ->
            val country=adapter.getItemAtPosition(position).toString()
            val capital=countries[country]

            val intent=Intent(this,CapitalActivity::class.java);
            intent.putExtra("country",country);
            intent.putExtra("capital",capital);
//            Toast.makeText(this,"$country capital is $capital",Toast.LENGTH_SHORT).show();
        }
    }
}