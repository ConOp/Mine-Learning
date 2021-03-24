package UI;
import Mechanics.Mine.MineGenerator;

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
        JButton generateButton = new JButton("Generate");
        generateButton.setBounds(900,50,100,50);
        generateButton.setVisible(true);
        generateButton.addActionListener(e -> {
            MineGenerator.getInstance().GenerateGems();
        });
        mainFrame.add(generateButton);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
