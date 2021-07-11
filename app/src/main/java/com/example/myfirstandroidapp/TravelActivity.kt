package com.example.myfirstandroidapp

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.util.*

class TravelActivity : AppCompatActivity() {
    private lateinit var spinner:Spinner;
    private lateinit var autoComplete:AutoCompleteTextView;
    private lateinit var startDate: Button;
    private lateinit var endDate: Button;
    private lateinit var ednopassengers: EditText;
    private lateinit var submit: Button;
    private lateinit var tvouput: TextView;
    private lateinit var startDay:String;
    private lateinit var endDay:String;
    private lateinit var selectedItem:String;
    val cities= arrayOf("Pokhara","Chitwan","Bhairawa");
    private lateinit var fee:String;
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)
//        binding
        spinner=findViewById(R.id.spinner);
        autoComplete=findViewById(R.id.autoComplete);
        startDate=findViewById(R.id.startDate);
        endDate=findViewById(R.id.endDate);
        ednopassengers=findViewById(R.id.ednopassengers);
        submit=findViewById(R.id.submit);
        tvouput=findViewById(R.id.tvoutput);
        startDate.setOnClickListener { loadDate() };
        endDate.setOnClickListener { endDate() };

        val adapter=ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cities
        );
        spinner.adapter=adapter;

        spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            )
            {
                selectedItem=parent?.getItemAtPosition(position).toString();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@TravelActivity,"nothing selected",Toast.LENGTH_SHORT).show();
            }
        }

        autoComplete.setAdapter(adapter);
        autoComplete.threshold=1;
        submit.setOnClickListener { calc() };


    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadDate(){
        val c= Calendar.getInstance();
        val year=c.get(Calendar.YEAR);
        val month=c.get(Calendar.MONTH);
        val day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                    startDate.text = "$dayOfMonth - ${month+1} - $year"
                    startDay="$year${month+1}$dayOfMonth";

            },
            year,
            month,
            day
        ).show();
    }
//   enddate
    private fun endDate(){
        val c= Calendar.getInstance();
        val year=c.get(Calendar.YEAR);
        val month=c.get(Calendar.MONTH);
        val day=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog(
            this,
             DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                endDate.text = "$dayOfMonth - ${month+1} - $year"
                 endDay="$year${month+1}$dayOfMonth";

             },
        year,
        month,
        day).show();
    }

    private fun calc(){
        val numpass=ednopassengers.text.toString().toInt();
        val days=(endDay.toInt()-startDay.toInt())+1;
        if(selectedItem==="Pokhara"){
             fee="1200";
        }else if(selectedItem==="Chitwan"){
             fee="1000";
        }else if(selectedItem==="Bhairawa"){
             fee="2000";
        }
        var result=(numpass*days*fee.toInt()).toString();
        tvouput.text="Your total costs is $result";

    }
}