package Mechanics.Gen;

import Utility.SettingsManager;

public class Generation {
    Agent[] agents;

    public Generation(){
        agents= new Agent[SettingsManager.agentsPerGeneration];
        GenerateAgents();
    }

    /***
     * Executes all the actions of all the agents present in the current generation.
     */
    public void ExecuteAllAgentActions(){
        for (Agent agent : agents) {
            agent.ExecuteAllActions();
        }
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

}
