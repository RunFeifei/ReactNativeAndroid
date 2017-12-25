package com.example.mylibrary.wuxudong.rncharts.charts;

import android.view.View;

import com.example.mylibrary.wuxudong.rncharts.data.BarDataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mock.mpchart.mikephil.charting.charts.BarChart;
import com.mock.mpchart.mikephil.charting.data.BarEntry;

public class BarChartManager extends BarLineChartBaseManager<BarChart, BarEntry> {

    @Override
    public String getName() {
        return "RNBarChart";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        BarChart barChart = new BarChart(reactContext);
        barChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(barChart));
        return barChart;
    }

    @Override
    DataExtract getDataExtract() {
        return new BarDataExtract();
    }

    @ReactProp(name = "drawValueAboveBar")
    public void setDrawValueAboveBar(BarChart chart, boolean enabled) {
        chart.setDrawValueAboveBar(enabled);
    }

    @ReactProp(name = "drawBarShadow")
    public void setDrawBarShadow(BarChart chart, boolean enabled) {
        chart.setDrawBarShadow(enabled);
    }
}
