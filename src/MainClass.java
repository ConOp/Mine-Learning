import Mechanics.Mine.MineGenerator;
import UI.MainWindow;
import Utility.SimulationManager;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        MainWindow.getInstance().InitializeWindow();
        MineGenerator.getInstance().GenerateMine();
        MineGenerator.getInstance().GenerateGems();
        SimulationManager.getInstance().StartSimulation();
    }
}
