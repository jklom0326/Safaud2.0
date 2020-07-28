package com.example.safaud20.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.safaud20.MainActivity
import com.example.safaud20.R



class GraphFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_graph,container,false)

        val button1 = view.findViewById<Button>(R.id.dailyseleced)
        val button2 = view.findViewById<Button>(R.id.weeklyseleced)
        val button3 = view.findViewById<Button>(R.id.monthlyseleced)


        button1?.setOnClickListener(){
            val mainActivity = activity as MainActivity
            mainActivity.dateSelected( "dailyseleced")
        }

        button2?.setOnClickListener(){
            val mainActivity = activity as MainActivity
            mainActivity.dateSelected( "weeklyseleced")
        }

        button3?.setOnClickListener(){
            val mainActivity = activity as MainActivity
            mainActivity.dateSelected( "monthlyseleced")
        }
        return view
    }
}


