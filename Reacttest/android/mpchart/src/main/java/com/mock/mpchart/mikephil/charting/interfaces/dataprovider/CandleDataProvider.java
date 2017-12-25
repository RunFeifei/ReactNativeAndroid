package com.mock.mpchart.mikephil.charting.interfaces.dataprovider;

import com.mock.mpchart.mikephil.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
