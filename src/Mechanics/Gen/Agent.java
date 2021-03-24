package Mechanics.Gen;

import Utility.SettingsManager;

import java.awt.*;
public class Agent {
    Chromosome chromosome;
    Point position;
    int score;

    public Agent(){
        position=new Point(0,0);
        chromosome = new Chromosome(SettingsManager.getInstance().getChromosomeLength());
        score=0;
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
     * @param score
     */
    public void ModifyScore(int score) {
        this.score+=score;
    }

    public int getScore() {
        return score;
    }
}
