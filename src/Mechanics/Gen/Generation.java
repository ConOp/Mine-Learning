package Mechanics.Gen;
import Utility.SettingsManager;

import java.util.Arrays;
import java.util.Comparator;

public class Generation {
    Agent[] agents;
    int index;

    public Generation(){
        agents= new Agent[SettingsManager.agentsPerGeneration];
        index=0;
    }

    /***
     * Executes all the actions of all the agents present in the current generation.
     */
    public void ExecuteAllAgentActions(){
        for (Agent agent : agents) {
            agent.ExecuteAllActions();
        }
        Arrays.sort(agents, Comparator.comparing(Agent::getScore));
    }

    public float GetMean(){
        float sum =0;
        for (Agent agent : agents) {
            sum += agent.getScore();
        }
        return  sum/agents.length;
    }

    /***
     * Generate all new agents of the generation.
     */
    public void GenerateAgents(){
        for(int i=0;i<SettingsManager.agentsPerGeneration;i++){
            agents[i]=new Agent();
        }
    }
    /***
     * Gets the best agent depending on the score in the current generation.
     * @return The best agent in generation.
     */
    public Agent GetBestAgent(){
        int maxScore=agents[0].getScore();
        int index=0;
        for(int i=0; i<SettingsManager.agentsPerGeneration;i++){
            if(maxScore<agents[i].getScore()){
                maxScore=agents[i].getScore();
                index=i;
            }
        }
        return agents[index];
    }
    public void AddAgent(Agent agent){
        agents[index]=agent;
        index++;
    }

    public Agent[] getAgents() {
        return agents;
    }
}
