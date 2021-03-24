package Utility;


public class SettingsManager {
    public static SettingsManager instance;
    public static SettingsManager getInstance(){
        if(instance==null){
            instance=new SettingsManager();
            return instance;
        }
        return instance;
    }
    SettingsManager(){
        chromosomeLength=10;
        agentsPerGeneration=200;
        generations=500;
        obstacleScore=-5;
    }
    int chromosomeLength;
    int agentsPerGeneration;
    int generations;
    int obstacleScore;

    public void setChromosomeLength(int chromosomeLength) {
        this.chromosomeLength = chromosomeLength;
    }

    public void setAgentsPerGeneration(int agentsPerGeneration) {
        this.agentsPerGeneration = agentsPerGeneration;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public void setObstacleScore(int obstacleScore) {
        this.obstacleScore = obstacleScore;
    }

    public int getChromosomeLength() {
        return chromosomeLength;
    }

    public int getAgentsPerGeneration() {
        return agentsPerGeneration;
    }

    public int getGenerations() {
        return generations;
    }

    public int getObstacleScore() {
        return obstacleScore;
    }
}
