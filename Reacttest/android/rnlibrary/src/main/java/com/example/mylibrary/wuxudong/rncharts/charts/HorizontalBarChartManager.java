package com.example.mylibrary.wuxudong.rncharts.charts;

import android.view.View;

import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.github.mikephil.charting.charts.HorizontalBarChart;

public class HorizontalBarChartManager extends BarChartManager {

    @Override
    public String getName() {
        return "RNHorizontalBarChart";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        HorizontalBarChart horizontalBarChart = new HorizontalBarChart(reactContext);
        horizontalBarChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(horizontalBarChart));
        return horizontalBarChart;
    }
}
