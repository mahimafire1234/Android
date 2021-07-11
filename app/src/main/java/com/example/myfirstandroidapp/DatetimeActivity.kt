package com.example.myfirstandroidapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import java.util.*

class DatetimeActivity : AppCompatActivity() {

    private lateinit var spinner:Spinner;
    private lateinit var autoCompleteTextview:AutoCompleteTextView;
    private lateinit var btnTimePicker:Button;
    private lateinit var btnLoadDate:Button;
    private lateinit var tvOutput:TextView;

    val countries=arrayOf("Nepal","China","Japan","Switzerland");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datetime)

        spinner=findViewById(R.id.spinner);
        autoCompleteTextview=findViewById(R.id.autoCompleteTextview);
        btnTimePicker=findViewById(R.id.btnTimePicker);
        btnLoadDate=findViewById(R.id.btnLoadDate);
        tvOutput=findViewById(R.id.tvOutput);

        val adapter=ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        );
        spinner.adapter=adapter;
        autoCompleteTextview.setAdapter(adapter);
        autoCompleteTextview.threshold=1;

        btnLoadDate.setOnClickListener { loadDate() }

        btnTimePicker.setOnClickListener { loadTime() }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadDate(){
        val c=Calendar.getInstance();
        val year=c.get(Calendar.YEAR);
        val month=c.get(Calendar.MONTH);
        val day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                tvOutput.text = "$dayOfMonth - ${month+1} - $year"
            },
            year,
            month,
            day).show();

    }
    private fun loadTime(){
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tvOutput.text = "$hour : $minute"
            },
            hour,
            minute,
            false
        ).show()
    }

}