package RealTimeStockPrice;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class RealTimeChart extends ChartPanel {
    private static TimeSeries timeSeries;
    private long value = 0;

    public RealTimeChart(String chartContent, String title, String yaxisName) {
        super(createChart(chartContent, title, yaxisName));
    }

    private static JFreeChart createChart(String chartContent, String title, String yaxisName) {
        // 创建时序图对象
        timeSeries = new TimeSeries(chartContent, Second.class);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeSeries);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "时间(秒)", yaxisName, timeseriescollection,
                true, true, false);
        XYPlot xyplot = jfreechart.getXYPlot();
        // 纵坐标设定
        ValueAxis valueaxis = xyplot.getDomainAxis();
        // 自动设置数据轴数据范围
        valueaxis.setAutoRange(true);
        //设置X轴范围
        valueaxis.setFixedAutoRange(750000D);

        valueaxis = xyplot.getRangeAxis();
        valueaxis.setRange(27800.0,27880.0);

        return jfreechart;
    }

    public void update(Second s, double b) {
        try {
            timeSeries.addOrUpdate(s, b);
            Thread.sleep(300);
        } catch (InterruptedException e) {

        }

    }

    private long randomNum() {
        System.out.println((Math.random() * 20 + 80));
        return (long) (Math.random() * 20 + 80);
    }
}
