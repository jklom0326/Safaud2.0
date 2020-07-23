package com.example.safaud20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.safaud20.alarm.AlarmMakeFragment
import com.example.safaud20.alarm.TimeViewModel
import com.example.safaud20.alarm.alramData
import com.example.safaud20.navigation.AlarmFragment
import com.example.safaud20.navigation.DetailViewFragment
import com.example.safaud20.navigation.GraphFragment
import com.example.safaud20.navigation.GridFragment
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_alarm_make.*
import kotlinx.android.synthetic.main.fragment_daily.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private val newWordActivityRequestCode = 1
    private lateinit var TimeViewModel : TimeViewModel
    var value1 : String? = null

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

    when(p0.itemId){
        R.id.home ->{
            var detailViewFragment = DetailViewFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,detailViewFragment).commit()
            return true
        }
        R.id.sleep_test ->{
            var gridFragment = GridFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,gridFragment).commit()
            return true
        }
        R.id.induced_sleep ->{
           setAlarm("default")
            return true
        }
        R.id.statistics ->{
            var graphFragment = GraphFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,graphFragment).commit()
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

//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_list)
//        val adapter = com.example.safaud20.alarm.ListAdapter(this)
//        recyclerView.adapter = adapter
//        recyclerView?.layoutManager=LinearLayoutManager(this)
//
//        TimeViewModel = ViewModelProvider(this).get(TimeViewModel::class.java)
//        TimeViewModel.alllist.observe(this, Observer { alramData ->
//            alramData?.let { adapter.settimes(it) }
//        })
//        val fab = findViewById<Button>(R.id.button1)
//        fab.setOnClickListener{
//            val intent = Intent(this@MainActivity, AlarmFragment::class.java)
//            startActivityForResult(intent,newWordActivityRequestCode)
//        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            data?.getStringExtra(AlarmMakeFragment.EXTRA_REPLY)?.let {
//                val word = alramData(it)
//                TimeViewModel.insert(word)
//            }
//        }else{
//            Toast.makeText(applicationContext,R.string.empty_not_saved,Toast.LENGTH_LONG).show()
//        }
//    }



    fun setAlarm(name : String){
//        var tran = supportFragmentManager.beginTransaction()

        var alarmfragment= AlarmFragment()
        var alarmmakefragment= AlarmMakeFragment()

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


}


