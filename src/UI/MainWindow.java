package UI;
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

    /***
     * Initializes the main window of the simulation.
     */
    public void InitializeWindow(){
        mainFrame = new JFrame("Mine Learning");
        mainFrame.setSize(1024,760);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        GenerateSettings();
    }

    /***
     * Generates the settings of the simulation in the main window.
     */
    void GenerateSettings(){
        JButton simulateButton = new JButton("Simulate Best Agent");
        simulateButton.setBounds(700,110,200,50);
        simulateButton.setVisible(true);
        simulateButton.addActionListener(e -> {
            VisualOperationManager.getInstance().ShowMine();
            VisualOperationManager.getInstance().SimulateAgentsActions(SimulationManager.getInstance().getGenerations()[SimulationManager.getInstance().getCurrentGeneration()].GetBestAgent());
        });
        mainFrame.add(simulateButton);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public CustomLabel[][] getLabelGrid() {
        return labelGrid;
    }
}
