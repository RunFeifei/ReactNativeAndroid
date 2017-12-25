package com.mock.mpchart.mikephil.charting.interfaces.dataprovider;

import com.mock.mpchart.mikephil.charting.data.CombinedData;

/**
 * Created by philipp on 11/06/16.
 */
public interface CombinedDataProvider extends LineDataProvider, BarDataProvider, BubbleDataProvider, CandleDataProvider, ScatterDataProvider {

    CombinedData getCombinedData();
}
