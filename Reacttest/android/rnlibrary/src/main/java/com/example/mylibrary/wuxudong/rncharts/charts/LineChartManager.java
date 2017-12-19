package com.example.mylibrary.wuxudong.rncharts.charts;


import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.LineDataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

public class LineChartManager extends BarLineChartBaseManager<LineChart, Entry> {

    @Override
    public String getName() {
        return "RNLineChart";
    }

    @Override
    protected LineChart createViewInstance(ThemedReactContext reactContext) {
        LineChart lineChart =  new LineChart(reactContext);
        lineChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(lineChart));
        return lineChart;
    }

    @Override
    DataExtract getDataExtract() {
        return new LineDataExtract();
    }
}
