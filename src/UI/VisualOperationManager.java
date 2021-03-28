package UI;
import Mechanics.Gen.Action;
import Mechanics.Gen.Agent;
import Mechanics.Mine.MineGenerator;
import Utility.SettingsManager;
import javax.swing.*;
import java.awt.*;

public class VisualOperationManager {

    public static VisualOperationManager instance;
    public static VisualOperationManager getInstance(){
        if(instance==null){
            instance=new VisualOperationManager();
            return instance;
        }
        return instance;
    }

    /***
     * Shows the actions of the agent in the grid to the user.
     * @param agent The agent to show the actions of.
     */
    public void SimulateAgentsActions(Agent agent) {
        agent.position = new Point(0, 0);
        new Thread(() -> {
            MainWindow.getInstance().getLabelGrid()[0][0].setIcon(new ImageIcon("Resources/agent.png"));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < agent.getChromosome().length; i++) {
                Action.values()[agent.getChromosome()[i]].ExecuteVisualAction(agent);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /***
     * Visually represent the mine to the user.
     */
    public void ShowMine(){
        MainWindow.getInstance().labelGrid=new CustomLabel[SettingsManager.height][SettingsManager.width];
        int y= 5;//MainWindow.getInstance().getMainFrame().getHeight()-SettingsManager.imageLabelHeight-50;
        for ( int i = 0; i < SettingsManager.height; i++, y +=SettingsManager.imageLabelHeight + SettingsManager.imageLabelOffset) {
            for (int x = 10, j = 0; j < SettingsManager.width; j++, x += SettingsManager.imageLabelWidth + SettingsManager.imageLabelOffset) {
                CustomLabel newTile = new CustomLabel();
                newTile.setBackground(Color.lightGray);
                newTile.setOpaque(true);
                newTile.setBounds(x, y, SettingsManager.imageLabelWidth, SettingsManager.imageLabelHeight);
                newTile.setVisible(true);
                if(MineGenerator.getInstance().getTiles()[i][j].isContainingGem()){
                newTile.setIcon(new ImageIcon("Resources/gem.png"));
                }
                MainWindow.getInstance().labelGrid[i][j]=newTile;
                MainWindow.getInstance().getMainFrame().add(newTile);
            }
        }
        for(int i=0; i<SettingsManager.height;i++){
            for(int j=0; j<SettingsManager.width;j++){
                MainWindow.getInstance().getLabelGrid()[i][j].repaint();
            }
        }
    }



}
