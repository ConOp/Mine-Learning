package UI;

import Utility.SettingsManager;
import Utility.SimulationManager;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class ChartManager {
    /***
     * Generates fitness graph.
     */
    public static void GenerateChart(){
        double[]mean = new double[SettingsManager.generations];
        double[]best = new double[SettingsManager.generations];
        double[]generation = new double[SettingsManager.generations];
        for(int i=0;i<SettingsManager.generations;i++){
            mean[i]=SimulationManager.getInstance().getGenerations()[i].GetMean();
            best[i]=SimulationManager.getInstance().getGenerations()[i].GetBestAgent().getScore();
            generation[i]=i;
        }
        // Create Chart
        XYChart chart =new XYChartBuilder()
                .width(1000)
                .height(800)
                .title("Fitness Chart")
                .xAxisTitle("Generation")
                .yAxisTitle("Fitness")
                .theme(Styler.ChartTheme.GGPlot2)
                .build();
        chart.addSeries("Mean Fitness",generation,mean);
        chart.addSeries("Best Agent Fitness",generation,best);

        new SwingWrapper<>(chart).displayChart();

    }
}
