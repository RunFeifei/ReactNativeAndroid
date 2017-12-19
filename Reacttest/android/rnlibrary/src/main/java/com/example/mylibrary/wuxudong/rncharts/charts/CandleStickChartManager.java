package com.example.mylibrary.wuxudong.rncharts.charts;

import com.example.mylibrary.wuxudong.rncharts.data.CandleDataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.data.CandleEntry;

public class CandleStickChartManager extends BarLineChartBaseManager<CandleStickChart, CandleEntry> {

    @Override
    public String getName() {
        return "RNCandleStickChart";
    }

    @Override
    protected CandleStickChart createViewInstance(ThemedReactContext reactContext) {
        CandleStickChart candleStickChart = new CandleStickChart(reactContext);
        candleStickChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(candleStickChart));
        return candleStickChart;
    }


    @Override
    DataExtract getDataExtract() {
        return new CandleDataExtract();
    }
}
