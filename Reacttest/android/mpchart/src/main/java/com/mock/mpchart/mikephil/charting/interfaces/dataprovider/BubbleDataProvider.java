package com.mock.mpchart.mikephil.charting.interfaces.dataprovider;

import com.mock.mpchart.mikephil.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
