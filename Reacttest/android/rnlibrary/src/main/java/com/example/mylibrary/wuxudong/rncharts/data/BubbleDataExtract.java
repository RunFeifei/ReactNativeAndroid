package com.example.mylibrary.wuxudong.rncharts.data;


import com.example.mylibrary.wuxudong.rncharts.utils.BridgeUtils;
import com.example.mylibrary.wuxudong.rncharts.utils.ChartDataSetConfigUtils;
import com.example.mylibrary.wuxudong.rncharts.utils.ConversionUtil;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.mock.mpchart.mikephil.charting.data.BubbleData;
import com.mock.mpchart.mikephil.charting.data.BubbleDataSet;
import com.mock.mpchart.mikephil.charting.data.BubbleEntry;
import com.mock.mpchart.mikephil.charting.interfaces.datasets.IDataSet;

import java.util.ArrayList;

/**
 * Created by xudong on 02/03/2017.
 */

public class BubbleDataExtract extends DataExtract<BubbleData, BubbleEntry> {
    @Override
    BubbleData createData() {
        return new BubbleData();
    }


    @Override
    IDataSet<BubbleEntry> createDataSet(ArrayList<BubbleEntry> entries, String label) {
        return new BubbleDataSet(entries, label);
    }

    @Override
    void dataSetConfig(IDataSet<BubbleEntry> dataSet, ReadableMap config) {
        BubbleDataSet bubbleDataSet = (BubbleDataSet) dataSet;

        ChartDataSetConfigUtils.commonConfig(bubbleDataSet, config);
        ChartDataSetConfigUtils.commonBarLineScatterCandleBubbleConfig(bubbleDataSet, config);

        // BubbleDataSet only config
        if (BridgeUtils.validate(config, ReadableType.Number, "highlightCircleWidth")) {
            bubbleDataSet.setHighlightCircleWidth((float) config.getDouble("highlightCircleWidth"));
        }
    }

    @Override
    BubbleEntry createEntry(ReadableArray values, int index) {
        if (!ReadableType.Map.equals(values.getType(index))) {
            throw new IllegalArgumentException("Invalid BubbleEntry data");
        }

        ReadableMap map = values.getMap(index);

        float x = index;
        if (map.hasKey("x")) {
            x = (float) map.getDouble("x");
        }

        if (!BridgeUtils.validate(map, ReadableType.Number, "y") ||
                !BridgeUtils.validate(map, ReadableType.Number, "size")) {
            throw new IllegalArgumentException("Invalid BubbleEntry data");
        }


        float y = (float) map.getDouble("y");
        float size = (float) map.getDouble("size");

        BubbleEntry bubbleEntry = new BubbleEntry(x, y, size, ConversionUtil.toMap(map));

        return bubbleEntry;
    }
}
