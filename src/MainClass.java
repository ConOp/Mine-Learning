import Mechanics.Gen.Action;
import Mechanics.Gen.Agent;
import Mechanics.Mine.MineGenerator;
import UI.MainWindow;
import Utility.AgentsManager;
import Utility.SettingsManager;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        MainWindow.getInstance().InitializeWindow();
        MineGenerator.getInstance().GenerateMine();
        MineGenerator.getInstance().GenerateGems();
        AgentsManager.getInstance().GenerateAgents();
        AgentsManager.getInstance().ExecuteAllAgentActions();
    }
}
