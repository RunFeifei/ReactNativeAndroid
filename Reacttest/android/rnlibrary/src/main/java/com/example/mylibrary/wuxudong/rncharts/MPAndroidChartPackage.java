package com.example.mylibrary.wuxudong.rncharts;

import com.example.mylibrary.wuxudong.rncharts.charts.BarChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.BubbleChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.CandleStickChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.CombinedChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.HorizontalBarChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.LineChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.PieChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.RadarChartManager;
import com.example.mylibrary.wuxudong.rncharts.charts.ScatterChartManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MPAndroidChartPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList();
    }

    // Deprecated in RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new BarChartManager(),
                new HorizontalBarChartManager(),
                new BubbleChartManager(),
                new CandleStickChartManager(),
                new LineChartManager(),
                new PieChartManager(),
                new RadarChartManager(),
                new ScatterChartManager(),
                new CombinedChartManager()
        );
    }

}
