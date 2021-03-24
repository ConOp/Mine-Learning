package Utility;

import Mechanics.Gen.Agent;

public class AgentsManager {
    public static AgentsManager instance;
    public static AgentsManager getInstance(){
        if(instance==null){
            instance=new AgentsManager();
            return instance;
        }
        return instance;
    }
    AgentsManager(){
        agents=new Agent[SettingsManager.getInstance().getAgentsPerGeneration()];
    }
    Agent[] agents;

    /***
     * Generates all the agents of the generation depending on agents per generation setting.
     */
    public void GenerateAgents(){
        for(int i=0; i<agents.length;i++){
            agents[i]= new Agent();
        }
    }

    /***
     * Executes all the actions of all the agents present in the current generation.
     */
    public void ExecuteAllAgentActions(){
        for(int i=0; i<agents.length;i++){
            agents[i].ExecuteAllActions();
        }
    }
}
