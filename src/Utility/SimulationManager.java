package Utility;

import Mechanics.Gen.Generation;

public class SimulationManager {
    public static SimulationManager instance;
    public static SimulationManager getInstance(){
        if(instance==null){
            instance=new SimulationManager();
            return instance;
        }
        return instance;
    }
    Generation[] generations;
    int currentGeneration;

    /***
     * Starts the whole simulation.
     */
    public void StartSimulation(){
        currentGeneration=-1;
        generations=new Generation[SettingsManager.generations];
        for(int i=0; i<SettingsManager.generations;i++){
            generations[i]=new Generation();
            generations[i].ExecuteAllAgentActions();
            currentGeneration++;
        }
    }

    public Generation[] getGenerations() {
        return generations;
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }
}
