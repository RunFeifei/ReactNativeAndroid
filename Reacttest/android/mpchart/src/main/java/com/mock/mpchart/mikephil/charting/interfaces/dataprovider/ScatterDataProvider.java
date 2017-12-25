package com.mock.mpchart.mikephil.charting.interfaces.dataprovider;

import com.mock.mpchart.mikephil.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
