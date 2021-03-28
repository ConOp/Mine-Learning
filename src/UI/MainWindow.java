package UI;
import Mechanics.Mine.MineGenerator;
import Utility.SimulationManager;
import javax.swing.*;

public class MainWindow {

    public static MainWindow instance;
    public static MainWindow getInstance(){
        if(instance==null){
            instance=new MainWindow();
            return instance;
        }
        return instance;
    }

    JFrame mainFrame;
    CustomLabel[][] labelGrid;
    public JButton startButton;
    public JButton simulateButton;
    public JButton chartButton;

    /***
     * Initializes the main window of the simulation.
     */
    public void InitializeWindow(){
        mainFrame = new JFrame("Mine Learning");
        mainFrame.setSize(1024,760);
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        GenerateSettings();
    }

    /***
     * Generates the settings of the simulation in the main window.
     */
    void GenerateSettings(){
        startButton = new JButton("Start Simulation");
        startButton.setBounds(700,30,200,50);
        startButton.setVisible(true);
        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            new Thread(() -> {
                MineGenerator.getInstance().GenerateMine();
                MineGenerator.getInstance().GenerateGems();
                SimulationManager.getInstance().StartSimulation();
            }).start();
        });
        simulateButton = new JButton("Simulate Best Agent");
        simulateButton.setBounds(700,100,200,50);
        simulateButton.setVisible(true);
        simulateButton.setEnabled(false);
        simulateButton.addActionListener(e -> {
            VisualOperationManager.getInstance().ShowMine();
            VisualOperationManager.getInstance().SimulateAgentsActions(SimulationManager.getInstance().getGenerations().get(0).GetBestAgent());
        });
        chartButton = new JButton("Show Chart");
        chartButton.setBounds(700,170,200,50);
        chartButton.setVisible(true);
        chartButton.setEnabled(false);
        chartButton.addActionListener(e -> {
            new Thread(ChartManager::GenerateChart).start();
        });

        mainFrame.add(startButton);
        mainFrame.add(simulateButton);
        mainFrame.add(chartButton);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public CustomLabel[][] getLabelGrid() {
        return labelGrid;
    }
}
