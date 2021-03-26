package Mechanics.Gen;
import Mechanics.Mine.MineGenerator;
import Mechanics.Mine.Tile;
import Utility.SettingsManager;
import java.awt.*;

public class Agent {
    Chromosome chromosome;
    public Point position;
    int score;
    Tile[][]localMine;

    public Agent(){
        position=new Point(0,0);
        chromosome = new Chromosome(SettingsManager.chromosomeLength);
        score=0;
        InitializeLocalMine();
    }

    /***
     * Executes all actions stored in agent's chromosome.
     */
    public void ExecuteAllActions(){
        for(int i=0; i<chromosome.chromosome.length;i++){
            Action.values()[chromosome.chromosome[i]].ExecuteAction(this);
        }
    }

    /***
     * Modifies the score of the agent depending on the actions.
     * @param score The additional or subtractive score.
     */
    public void ModifyScore(int score) {
        this.score=this.score+score;
    }

    /***
     * Initializes the local mine of every agent.
     */
    private void InitializeLocalMine(){
        localMine=new Tile[SettingsManager.height][SettingsManager.width];
        for(int i=0; i<SettingsManager.height; i++) {
            for (int j = 0; j < SettingsManager.width; j++) {
                localMine[i][j] = new Tile(MineGenerator.getInstance().getTiles()[i][j]);
            }
        }
    }

    public int getScore() {
        return score;
    }

    public Chromosome getChromosome() {
        return chromosome;
    }
}
