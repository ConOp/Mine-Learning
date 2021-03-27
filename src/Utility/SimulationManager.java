package Utility;
import Mechanics.Gen.*;
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
    Generation[] generations;
    int currentGeneration;

    /***
     * Starts the whole simulation.
     */
    public void StartSimulation(){
        generations=new Generation[SettingsManager.generations];
        currentGeneration=0;
        generations[0]=new Generation();
        generations[0].GenerateAgents();
        generations[0].ExecuteAllAgentActions();
        for(int i=1; i<SettingsManager.generations;i++){
            generations[i]=new Generation();
            currentGeneration++;
            for(int j=0; j<SettingsManager.agentsPerGeneration/2;j++) {
                Agent[] children =CrossOver.SINGLE_POINT.ApplyCrossOver(ParentSelection.TOURNAMENT_SELECTION.SelectParents(currentGeneration-1));
                generations[i].AddAgent(MutateAgent(children[0]));
                generations[i].AddAgent(MutateAgent(children[1]));
            }
            generations[i].ExecuteAllAgentActions();
            if(i%10==0) {
                System.out.println("Best agent fitness generation: " + currentGeneration + " fitness: " + generations[i].GetBestAgent().getScore()+" Mean Fitness: "+generations[i].GetMean());
            }
        }
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

    public Generation[] getGenerations() {
        return generations;
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }
}
