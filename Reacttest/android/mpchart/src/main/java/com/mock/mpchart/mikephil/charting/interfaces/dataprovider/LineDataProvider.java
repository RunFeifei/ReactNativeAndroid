package com.mock.mpchart.mikephil.charting.interfaces.dataprovider;

import com.mock.mpchart.mikephil.charting.components.YAxis;
import com.mock.mpchart.mikephil.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
