package Utility;
import Mechanics.Gen.*;
import Mechanics.Mine.MineGenerator;
import UI.ChartManager;
import UI.MainWindow;

import java.util.ArrayList;
import java.util.Random;

public class SimulationManager {
    public static SimulationManager instance;
    public static SimulationManager getInstance(){
        if(instance==null){
            instance=new SimulationManager();
            return instance;
        }
        return instance;
    }
    ArrayList<Generation> generations;
    int currentGeneration;

    /***
     * Starts the whole simulation.
     */
    public void StartSimulation(){
        MainWindow.getInstance().chartButton.setEnabled(false);
        MainWindow.getInstance().simulateButton.setEnabled(false);
        ChartManager.Reset();
        generations=new ArrayList<>();
        currentGeneration=0;
        generations.add(new Generation());
        generations.get(0).GenerateAgents();
        generations.get(0).ExecuteAllAgentActions();
        ChartManager.AddToBestPerGeneration(generations.get(0).GetBestAgent().getScore());
        ChartManager.AddToMean(generations.get(0).GetMean());
        for(int i=1; i<SettingsManager.generations;i++){
            generations.add(new Generation());
            currentGeneration++;
            for(int j=0; j<(SettingsManager.agentsPerGeneration/2);j++) {
                Agent[] children = CrossOver.SINGLE_POINT.ApplyCrossOver(ParentSelection.TOURNAMENT_SELECTION.SelectParents(currentGeneration - 1));
                generations.get(1).AddAgent(MutateAgent(children[0]));
                generations.get(1).AddAgent(MutateAgent(children[1]));
            }
            generations.get(1).ExecuteAllAgentActions();
            if(i%10==0) {
                System.out.println("Best agent fitness generation: " + currentGeneration +
                        " fitness: " + generations.get(1).GetBestAgent().getScore()+
                        " Mean Fitness: "+generations.get(1).GetMean()+
                        " Efficiency: "+((float)generations.get(1).GetBestAgent().getScore()/(MineGenerator.getInstance().getSpawnedGems()*SettingsManager.gemCollectScore))*100+"%");
            }
            ChartManager.AddToBestPerGeneration(generations.get(1).GetBestAgent().getScore());
            ChartManager.AddToMean(generations.get(1).GetMean());
            generations.remove(0);
        }
        MainWindow.getInstance().startButton.setEnabled(true);
        MainWindow.getInstance().chartButton.setEnabled(true);
        MainWindow.getInstance().simulateButton.setEnabled(true);
    }

    /***
     * Mutates the chromosomes of an agent depending on the chances.
     * @param agent The agent to mutate chromosomes.
     * @return The agent after mutation.
     */
    public Agent MutateAgent(Agent agent){
        if(Math.random()<=SettingsManager.chanceMutationToHappen){
            Random random = new Random();
            for(int i=0;i<agent.getChromosome().length;i++){
                if(Math.random()<=SettingsManager.chanceToMutate){
                    agent.getChromosome()[i]= random.nextInt(Action.values().length);
                }
            }
        }
        return agent;
    }

    public ArrayList<Generation> getGenerations() {
        return generations;
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }

}
