import Mechanics.MineGenerator;
import UI.MainWindow;

public class MainClass {
    public static void main(String[] args) {
        MainWindow.getInstance().InitializeWindow();
        MineGenerator.getInstance().GenerateMine();
        MineGenerator.getInstance().GenerateGems();
    }
}
