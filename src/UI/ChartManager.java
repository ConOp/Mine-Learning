package UI;

import Mechanics.Mine.MineGenerator;
import Utility.SettingsManager;
import Utility.SimulationManager;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;

public class ChartManager {
    static int i=0;
    static double[]best;
    static double[]mean;
    /***
     * Generates fitness graph.
     */
    public static void GenerateChart(){
        double[]generation = new double[SettingsManager.generations];
        double[]bestScore = new double[SettingsManager.generations];
        for(int i=0;i<SettingsManager.generations;i++){
            generation[i]=i;
            bestScore[i]= MineGenerator.getInstance().getSpawnedGems()*SettingsManager.gemCollectScore;
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
        chart.addSeries("Best Possible Fitness",generation,bestScore);
        new SwingWrapper<>(chart).displayChart().setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }
    public static void AddToBestPerGeneration(int bestScore){
        best[i]=bestScore;
    }
    public static void AddToMean(float meanScore){
        mean[i]=meanScore;
        i++;
    }
    public static void Reset(){
        i=0;
        best=new double[SettingsManager.generations];
        mean = new double[SettingsManager.generations];
    }
}
