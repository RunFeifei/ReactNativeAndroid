package com.example.mylibrary.wuxudong.rncharts.charts;


import android.support.annotation.Nullable;
import android.view.View;

import com.example.mylibrary.wuxudong.rncharts.data.DataExtract;
import com.example.mylibrary.wuxudong.rncharts.data.PieDataExtract;
import com.example.mylibrary.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.example.mylibrary.wuxudong.rncharts.utils.BridgeUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;

import java.util.Map;

public class PieChartManager extends ChartBaseManager<PieChart, PieEntry> {

    @Override
    public String getName() {
        return "RNPieChart";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        PieChart pieChart = new PieChart(reactContext);
        pieChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(pieChart));
        return pieChart;
    }

    @Override
    DataExtract getDataExtract() {
        return new PieDataExtract();
    }

    @Nullable
    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("animateY", 0);
    }

    @Override
    public void receiveCommand(View root, int commandId, @javax.annotation.Nullable ReadableArray args) {
        super.receiveCommand(root, commandId, args);
        if (commandId == 0 && root instanceof PieChart) {
            ((PieChart) root).animateY(2000, Easing.EasingOption.EaseInOutQuad);
        }
    }

    @ReactProp(name = "drawEntryLabels")
    public void setDrawSliceText(PieChart chart, boolean enabled) {
        chart.setDrawEntryLabels(enabled);
    }

    @ReactProp(name = "usePercentValues")
    public void setUsePercentValues(PieChart chart, boolean enabled) {
        chart.setUsePercentValues(enabled);
    }

    @ReactProp(name = "centerText")
    public void setCenterText(PieChart chart, String text) {
        chart.setCenterText(text);
    }

    @ReactProp(name = "styledCenterText")
    public void setStyledCenterText(PieChart chart, ReadableMap propMap) {
        if (BridgeUtils.validate(propMap, ReadableType.String, "text")) {
            chart.setCenterText(propMap.getString("text"));
        } else {
            chart.setCenterText("");
        }

        if (BridgeUtils.validate(propMap, ReadableType.Number, "color")) {
            chart.setCenterTextColor(propMap.getInt("color"));
        }

        if (BridgeUtils.validate(propMap, ReadableType.Number, "size")) {
            chart.setCenterTextSize((float) propMap.getDouble("size"));
        }
    }

    @ReactProp(name = "centerTextRadiusPercent")
    public void setCenterTextRadiusPercent(PieChart chart, float radiusPercent) {
        chart.setCenterTextRadiusPercent(radiusPercent);
    }

    @ReactProp(name = "holeRadius")
    public void setHoleRadius(PieChart chart, float percent) {
        chart.setHoleRadius(percent);
    }

    @ReactProp(name = "holeColor")
    public void setHoleColor(PieChart chart, Integer color) {
        chart.setHoleColor(color);
    }

    @ReactProp(name = "transparentCircleRadius")
    public void setTransparentCircleRadius(PieChart chart, float percent) {
        chart.setTransparentCircleRadius(percent);
    }

    @ReactProp(name = "transparentCircleColor")
    public void setTransparentCircleColor(PieChart chart, Integer color) {
        chart.setTransparentCircleColor(color);
    }

    @ReactProp(name = "entryLabelColor")
    public void setEntryLabelColor(PieChart chart, Integer color) {
        chart.setEntryLabelColor(color);
    }

    @ReactProp(name = "entryLabelTextSize")
    public void setEntryLabelTextSize(PieChart chart, float size) {
        chart.setEntryLabelTextSize(size);
    }

    @ReactProp(name = "maxAngle")
    public void setMaxAngle(PieChart chart, float maxAngle) {
        chart.setMaxAngle(maxAngle);
    }

    @ReactProp(name = "rotationEnabled")
    public void setRotationEnabled(PieChart chart, boolean enabled) {
        chart.setRotationEnabled(enabled);
    }

    @ReactProp(name = "rotationAngle")
    public void setRotationAngle(PieChart chart, float angle) {
        chart.setRotationAngle(angle);
    }


}
