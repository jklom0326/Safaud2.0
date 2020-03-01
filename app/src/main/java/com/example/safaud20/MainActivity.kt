package com.example.safaud20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.safaud20.navigation.AlarmFragment
import com.example.safaud20.navigation.DetailViewFragment
import com.example.safaud20.navigation.GraphFragment
import com.example.safaud20.navigation.GridFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

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
            var alarmFragment = AlarmFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_content,alarmFragment).commit()
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
    }

}
