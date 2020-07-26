package com.example.safaud20.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.safaud20.MainActivity
import com.example.safaud20.R
import kotlinx.android.synthetic.main.fragment_grid.*
import kotlinx.android.synthetic.main.fragment_scrolling.*
import lib.kingja.switchbutton.SwitchMultiButton

class GridFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_grid,container,false)

        val button1 = view.findViewById<Button>(R.id.KESS)
        val highly = "매우 많이"
        val pretty = "상당히"
        val little = "적음"
        val absol = "전혀"

        button1?.setOnClickListener(){
            val mainActivity = activity as MainActivity
            mainActivity.sleepTest( "KESS")
        }
        val mSwitchMultiButton = view?.findViewById<SwitchMultiButton>(R.id.switchMultiButton)
        mSwitchMultiButton?.setText(absol,little,pretty,highly)

        return view


    }

}