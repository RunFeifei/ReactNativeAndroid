package com.example.mylibrary.wuxudong.rncharts.charts;


import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.ScatterDataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.mock.mpchart.mikephil.charting.charts.ScatterChart;
import com.mock.mpchart.mikephil.charting.data.Entry;

public class ScatterChartManager extends BarLineChartBaseManager<ScatterChart, Entry> {

    @Override
    public String getName() {
        return "RNScatterChart";
    }

    @Override
    protected ScatterChart createViewInstance(ThemedReactContext reactContext) {
        ScatterChart scatterChart = new ScatterChart(reactContext);
        scatterChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(scatterChart));
        return scatterChart;
    }


    @Override
    DataExtract getDataExtract() {
        return new ScatterDataExtract();
    }
}
