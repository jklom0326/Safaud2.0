package com.example.safaud20

import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alarm_make.*
import java.util.*

class AlarmMakeActivity : AppCompatActivity() {
    var picker: TimePicker? = null
    var btnGet: Button? = null
    var tvw: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_make)
        picker?.setIs24HourView(true)
        tvw = findViewById(R.id.textView1)
        picker=findViewById(R.id.timePicker1)
        btnGet = findViewById(R.id.button1)
    button1.setOnClickListener() {
        var hour = null
        var minute = null
        var am_pm: String? = null


    }

        val mPickTimeBtn = findViewById<Button>(R.id.button1)
        val textView     = findViewById<TextView>(R.id.textView1)

        mPickTimeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                textView.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }


    }
}


