package Mechanics.Gen;
import UI.MainWindow;
import Utility.SettingsManager;

import javax.swing.*;

public enum Action {
    MOVE_UP{
        public boolean isValidAction(Agent agent) {return agent.position.y + 1 < SettingsManager.height;}
        @Override
        public void ExecuteAction(Agent agent) {
           if(isValidAction(agent)) {
               agent.position.y += 1;
               agent.ModifyScore(SettingsManager.moveScore);
           }
           else {
               agent.ModifyScore(SettingsManager.obstacleScore);
           }
        }

        @Override
        public void ExecuteVisualAction(Agent agent) {
            if(isValidAction(agent)) {
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setPrevIcon();
                agent.position.y += 1;
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setIcon(new ImageIcon("Resources/agent.png"));
            }
        }
    },
    MOVE_DOWN{
        public boolean isValidAction(Agent agent) {return agent.position.y - 1 >= 0;}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent)) {
                    agent.position.y -= 1;
                    agent.ModifyScore(SettingsManager.moveScore);
            }
            else {
                agent.ModifyScore(SettingsManager.obstacleScore);
            }
        }

        @Override
        public void ExecuteVisualAction(Agent agent) {
            if(isValidAction(agent)) {
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setPrevIcon();
                agent.position.y -= 1;
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setIcon(new ImageIcon("Resources/agent.png"));
            }
        }
    },
    MOVE_LEFT{
        public boolean isValidAction(Agent agent) {return agent.position.x - 1 >= 0;}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent)) {
                agent.position.x -= 1;
                agent.ModifyScore(SettingsManager.moveScore);
            }
            else {
                agent.ModifyScore(SettingsManager.obstacleScore);
            }
        }
        @Override
        public void ExecuteVisualAction(Agent agent) {
            if(isValidAction(agent)) {
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setPrevIcon();
                agent.position.x -= 1;
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setIcon(new ImageIcon("Resources/agent.png"));
            }
        }
    },
    MOVE_RIGHT{
        public boolean isValidAction(Agent agent) {return agent.position.x + 1 < SettingsManager.width;}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent)) {
                agent.position.x += 1;
                agent.ModifyScore(SettingsManager.moveScore);
            }
            else {
                agent.ModifyScore(SettingsManager.obstacleScore);
            }
        }
        @Override
        public void ExecuteVisualAction(Agent agent) {
            if(isValidAction(agent)) {
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setPrevIcon();
                agent.position.x += 1;
                MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setIcon(new ImageIcon("Resources/agent.png"));
            }
        }
    },
    MINE_GEM{
        public boolean isValidAction(Agent agent) {return agent.localMine[agent.position.x][agent.position.y].isContainingGem();}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent)) {
                agent.ModifyScore(SettingsManager.gemCollectScore);
                agent.localMine[agent.position.x][agent.position.y].RemoveGem();

            }
            else {
                agent.ModifyScore(SettingsManager.invalidGemCollectScore);
            }
        }
        @Override
        public void ExecuteVisualAction(Agent agent) {
            MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setIcon(null);
            MainWindow.getInstance().getLabelGrid()[agent.position.x][agent.position.y].setIcon(new ImageIcon("Resources/agent.png"));
        }
    };

    /***
     * Executes the selected agent action.
     * @param agent The agent that executes the action.
     */
    public abstract void ExecuteAction(Agent agent);
    /***
     * Executes the selected agent action visible to the user.
     * @param agent The agent that executes the action.
     */
    public abstract void ExecuteVisualAction(Agent agent);
}
