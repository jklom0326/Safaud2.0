package com.example.safaud20

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.getSystemServiceName
import com.example.safaud20.receiver.AlarmReceiver
import com.example.safaud20.receiver.DeviceBootReceiver
import kotlinx.android.synthetic.main.activity_alarm_make.*
import java.util.*
import android.content.Context as Context1


class AlarmMakeActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_make)

        timePicker1.setIs24HourView(true)

        //시간설정하기, 없으면 디폴트

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("daily alarm", Context1.MODE_PRIVATE)
        val millis: Long =
            sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().timeInMillis)

        val nextNotifyTime: Calendar = GregorianCalendar()
        nextNotifyTime.timeInMillis = millis

        val nextDate = nextNotifyTime.time
        val date_text =
            SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(nextDate)
        Toast.makeText(
            applicationContext,
            "[처음 실행시] 다음 알람은 " + date_text + "으로 알람이 설정되었습니다!",
            Toast.LENGTH_SHORT
        ).show()

        // 이전 설정값으로 TimePicker 초기화
        val currentTime = nextNotifyTime.time
        val HourFormat =
            SimpleDateFormat("kk", Locale.getDefault())
        val MinuteFormat =
            SimpleDateFormat("mm", Locale.getDefault())

        val pre_hour = HourFormat.format(currentTime).toInt()
        val pre_minute = MinuteFormat.format(currentTime).toInt()

        if (Build.VERSION.SDK_INT >= 23) {
            timePicker1.setHour(pre_hour);
            timePicker1.setMinute(pre_minute);
        } else {
            timePicker1.setCurrentHour(pre_hour);
            timePicker1.setCurrentMinute(pre_minute);
        }
        val Button1 = findViewById<Button>(R.id.button1)
        Button1.setOnClickListener {
            val hour: Int
            val hour_24: Int
            val minute: Int
            val am_pm: String
            if (Build.VERSION.SDK_INT >= 23) {
                hour_24 = timePicker1.getHour()
                minute = timePicker1.getMinute()
            } else {
                hour_24 = timePicker1.getCurrentHour()
                minute = timePicker1.getCurrentMinute()
            }
            if (hour_24 > 12) {
                am_pm = "PM"
                hour = hour_24 - 12
            } else {
                hour = hour_24
                am_pm = "AM"
            }
            // 현재 지정된 시간으로 알람 시간 설정

            // 현재 지정된 시간으로 알람 시간 설정
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar[Calendar.HOUR_OF_DAY] = hour_24
            calendar[Calendar.MINUTE] = minute
            calendar[Calendar.SECOND] = 0

            // 이미 지난 시간을 지정했다면 다음날 같은 시간으로 설정

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }

            val currentDateTime = calendar.getTime();
            val date_text =
                SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(
                    currentDateTime
                );
            Toast.makeText(
                getApplicationContext(),
                date_text + "으로 알람이 설정되었습니다!",
                Toast.LENGTH_SHORT
            ).show();

            //  Preference에 설정한 값 저장
            val editor = getSharedPreferences("daily alarm", MODE_PRIVATE).edit();
            editor.putLong("nextNotifyTime", calendar.getTimeInMillis());
            editor.apply();

            finish()
        }

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlarmMakeActivity> {
        override fun createFromParcel(parcel: Parcel): AlarmMakeActivity {
            return AlarmMakeActivity(parcel)
        }

        override fun newArray(size: Int): Array<AlarmMakeActivity?> {
            return arrayOfNulls(size)
        }
    }
}










