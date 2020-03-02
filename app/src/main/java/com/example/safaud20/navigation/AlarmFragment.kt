package com.example.safaud20.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.safaud20.AlarmMakeActivity
import com.example.safaud20.R
import kotlinx.android.synthetic.main.fragment_alarm.*
import kotlinx.android.synthetic.main.fragment_alarm.add_alram

class AlarmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_alarm, container, false)
        val makeAlarm = view?.findViewById<View>(R.id.add_alram)

        if (makeAlarm != null) {
            makeAlarm.setOnClickListener {
                activity?.let {
                    val MakeAlarm = Intent(context, AlarmMakeActivity::class.java)
                    startActivity(MakeAlarm)
                }
            }
        }
        return view
    }
}
