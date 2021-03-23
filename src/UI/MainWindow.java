package UI;
import Mechanics.MineGenerator;
import Mechanics.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    public void InitializeWindow(){
        mainFrame = new JFrame("Mine Learning");
        mainFrame.setSize(1024,760);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        GenerateSettings();
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
    void GenerateSettings(){
        JButton generateButton = new JButton("Generate");
        generateButton.setBounds(900,50,100,50);
        generateButton.setVisible(true);
        generateButton.addActionListener(e -> {
            MineGenerator.getInstance().GenerateGems();
        });
        mainFrame.add(generateButton);

    }
}
