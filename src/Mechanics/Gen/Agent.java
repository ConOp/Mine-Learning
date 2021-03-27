package Mechanics.Gen;
import Mechanics.Mine.MineGenerator;
import Mechanics.Mine.Tile;
import Utility.SettingsManager;
import java.awt.*;
import java.util.Random;

public class Agent {
    int[] chromosome;
    public Point position;
    int score;
    Tile[][]localMine;

    public Agent(){
        position=new Point(0,0);
        Random random = new Random();
        //Generate Random chromosomes for the first generation.
        chromosome=new int[SettingsManager.chromosomeLength];
        for(int i = 0; i< SettingsManager.chromosomeLength; i++){
            chromosome[i]= random.nextInt(Action.values().length);
        }
        score=0;
        InitializeLocalMine();
    }
    public Agent(int[] chromosome){
        position=new Point(0,0);
        this.chromosome = chromosome;
        score=0;
        InitializeLocalMine();
    }

    /***
     * Executes all actions stored in agent's chromosome.
     */
    public void ExecuteAllActions(){
        for(int i=0; i<chromosome.length;i++){
            Action.values()[chromosome[i]].ExecuteAction(this);
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

    public int[] getChromosome() {
        return chromosome;
    }
}
