package com.example.safaud20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.safaud20.SleepTest.ScrollingFragment
import com.example.safaud20.alarm.AlarmMakeFragment
import com.example.safaud20.alarm.TimeViewModel
import com.example.safaud20.navigation.AlarmFragment
import com.example.safaud20.navigation.DetailViewFragment
import com.example.safaud20.navigation.GraphFragment
import com.example.safaud20.navigation.GridFragment
import com.example.safaud20.navigation2.DailyFragment
import com.example.safaud20.navigation2.MonthlyFragment
import com.example.safaud20.navigation2.WeeklyFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private val newWordActivityRequestCode = 1
    private lateinit var TimeViewModel : TimeViewModel
    var value1 : String? = null

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

    when(p0.itemId){
        R.id.home ->{
            val detailViewFragment = DetailViewFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,detailViewFragment).commit()
            return true
        }
        R.id.sleep_test ->{
            val gridFragment = GridFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,gridFragment).commit()
            return true
        }
        R.id.induced_sleep ->{
           setAlarm("default")
            return true
        }
        R.id.statistics ->{
            val graphFragment = GraphFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,graphFragment).commit()
            return true
        }
        R.id.daily -> {
            var dailyFragment = DailyFragment()
            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.main_content2, dailyFragment).commit()
            }
            return true
        }

        R.id.weekly -> {
            var WeeklyFragment = WeeklyFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content2, WeeklyFragment).commit()
            return true
        }

        R.id.monthly -> {
            var MonthlyFragment = MonthlyFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content2, MonthlyFragment).commit()
            return true
        }
    }
        return false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        //디폴트 화면 띄우는거
        bottom_navigation.selectedItemId = R.id.home

    }



    fun setAlarm(name : String){
//        var tran = supportFragmentManager.beginTransaction()

        val alarmfragment= AlarmFragment()
        val alarmmakefragment= AlarmMakeFragment()

        when(name){
            "default"->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content,alarmfragment).commit()
            }
            "make"->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content,alarmmakefragment).commit()
                supportFragmentManager.beginTransaction().addToBackStack(null)
            }
        }

    }
    fun sleepTest (name: String) {
        val sleepTest1 = ScrollingFragment()

        when(name){
            "KESS" ->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content,sleepTest1).commit()
            }
        }

    }

    fun dateSelected(name: String){
        val dailyseleced = DailyFragment()
        when(name){
            "dailyseleced" ->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content2,dailyseleced).commit()
            }
        }
    }



}


