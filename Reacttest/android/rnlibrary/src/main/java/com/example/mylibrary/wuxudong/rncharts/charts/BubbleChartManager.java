package com.example.mylibrary.wuxudong.rncharts.charts;


import com.example.mylibrary.wuxudong.rncharts.data.BubbleDataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.data.BubbleEntry;

public class BubbleChartManager extends ChartBaseManager<BubbleChart, BubbleEntry> {

    @Override
    public String getName() {
        return "RNBubbleChart";
    }

    @Override
    protected BubbleChart createViewInstance(ThemedReactContext reactContext) {
        BubbleChart bubbleChart =  new BubbleChart(reactContext);
        bubbleChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(bubbleChart));
        return bubbleChart;
    }


    @Override
    DataExtract getDataExtract() {
        return new BubbleDataExtract();
    }
}
