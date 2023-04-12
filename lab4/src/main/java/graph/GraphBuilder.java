package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import utils.dot.Dot;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class GraphBuilder {

    public void buildGraph(List<Dot> originalDots, List<Dot> interpolatedDots, List<Dot> startDots){
        XYSeries originalFunction = new XYSeries("Original function");
        XYSeries interpolatedFunction = new XYSeries("Interpolated function");
        for (Dot i : originalDots){
            originalFunction.add(i.getX(), i.getY());
        }
        for (Dot i : interpolatedDots){
            interpolatedFunction.add(i.getX(), i.getY());
        }
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(originalFunction);
        collection.addSeries(interpolatedFunction);
        JFreeChart chart = ChartFactory.createXYLineChart("Interpolation", "x", "y", collection, PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = chart.getXYPlot();

        plot.getRenderer().setSeriesPaint(1, Color.BLACK);

        XYSplineRenderer renderer = new XYSplineRenderer(10000);
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(5.0f));
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));

        for (int i = 0; i < startDots.size(); i++){
            XYSeries dot = new XYSeries("dot " + (i + 1));
            dot.add(startDots.get(i).getX(), startDots.get(i).getY());
            XYSeriesCollection pointCollection = new XYSeriesCollection();
            pointCollection.addSeries(dot);
            plot.setDataset(i + 1, pointCollection);
            plot.setRenderer(i + 1, renderer);
        }

        ChartFrame frame = new ChartFrame("", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
