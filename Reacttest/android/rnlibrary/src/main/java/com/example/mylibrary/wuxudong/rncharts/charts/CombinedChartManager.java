package com.example.mylibrary.wuxudong.rncharts.charts;


import com.example.mylibrary.wuxudong.rncharts.data.CombinedDataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.mock.mpchart.mikephil.charting.charts.CombinedChart;
import com.mock.mpchart.mikephil.charting.data.Entry;

public class CombinedChartManager extends BarLineChartBaseManager<CombinedChart, Entry> {

    @Override
    public String getName() {
        return "RNCombinedChart";
    }

    @Override
    protected CombinedChart createViewInstance(ThemedReactContext reactContext) {
        CombinedChart combinedChart = new CombinedChart(reactContext);
        combinedChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(combinedChart));
        return combinedChart;
    }

    @Override
    DataExtract getDataExtract() {
        return new CombinedDataExtract();
    }
}
