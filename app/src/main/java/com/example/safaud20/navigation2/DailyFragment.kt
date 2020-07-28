package com.example.safaud20.navigation2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.safaud20.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.DecimalFormat

class DailyFragment : Fragment(){
    private lateinit var chart: BarChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_daily,container,false)

        chart = view.findViewById(R.id.chart1)
        chart.setBackgroundColor(Color.WHITE)
        chart.setExtraTopOffset(-30f)
        chart.setExtraBottomOffset(10f)
        chart.setExtraLeftOffset(70f)
        chart.setExtraRightOffset(70f)

        chart.setDrawBarShadow(false)
        chart.setDrawValueAboveBar(false)

        chart.getDescription().isEnabled = false

        chart.setPinchZoom(false)

        chart.setDrawGridBackground(false)

        val xAxis = chart.getXAxis()

        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)
        xAxis.textColor = Color.LTGRAY
        xAxis.textSize = 13f
        xAxis.labelCount = 5
        xAxis.granularity = 1f


        val left = chart.getAxisLeft()
        left.setDrawLabels(false)
        left.spaceTop = 0f
        left.spaceBottom = 0f
        left.setDrawAxisLine(false)
        left.setDrawGridLines(false)
//        left.setLabelCount(4,true)
        left.setDrawZeroLine(true) // draw a zero line

        left.zeroLineColor = Color.GRAY
        left.zeroLineWidth = 0.7f
        chart.getAxisRight().isEnabled = false
        chart.getLegend().isEnabled = false


        // THIS IS THE ORIGINAL DATA YOU WANT TO PLOT
        val data: MutableList<Data> = java.util.ArrayList()
        data.add(Data(0f, 4f, "10시","Awake"))
        data.add(Data(1f, 4f, "11시","Awake"))
        data.add(Data(2f, 2f, "12시","Stage1"))
        data.add(Data(3f, 2f, "1시","Stage1"))
        data.add(Data(4f, 1f, "2시","Stage2"))
        data.add(Data(5f, -1f, "3시","Stage3"))
        data.add(Data(6f, 2f, "4시","Stage1"))
        data.add(Data(7f, 3f, "5시","REM"))
        data.add(Data(8f, 3f, "6시","REM"))
        data.add(Data(9f, 1f, "7시","Stage2"))
        data.add(Data(10f, 1f, "8시","Stage2"))

        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return data[Math.min(Math.max(value.toInt(), 0), data.size - 1)].xAxisValue
            }
        }

        setData(data)
        return view
    }

    private fun setData(dataList: List<Data>) {
        val values = java.util.ArrayList<BarEntry>()
        val colors: MutableList<Int> = java.util.ArrayList()
//        val green = Color.rgb(110, 190, 102)
        val red = Color.rgb(200, 200, 0)
        for (i in dataList.indices) {
            val d: Data =
                dataList[i]
            val entry = BarEntry(d.xValue, d.yValue)
            values.add(entry)

            // specific colors
            if (d.yValue >= 0) colors.add(red) else colors.add(red)
        }
        val set: BarDataSet
        if (chart.data != null &&
            chart.data.dataSetCount > 0
        ) {
            set = chart.data.getDataSetByIndex(0) as BarDataSet
            set.values = values
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            set = BarDataSet(values, "Values")
            set.colors = colors
            set.setValueTextColors(colors)
            val data = BarData(set)
            data.setValueTextSize(13f)
            data.setValueFormatter(Formatter())
            data.barWidth = 1f
            chart.data = data
            chart.invalidate()
        }
    }

    private class Data internal constructor(
        val xValue: Float,
        val yValue: Float,
        val xAxisValue: String,
        val left:String

    )
//    private class Left internal constructor(
//        val left:String
//    )

    private class Formatter internal constructor() :
        ValueFormatter() {
        private val mFormat: DecimalFormat
        override fun getFormattedValue(value: Float): String {
            return mFormat.format(value.toDouble())
        }

        init {
            mFormat = DecimalFormat("######.0")
        }
    }
}
