package Mechanics.Gen;
import Utility.SettingsManager;
import Utility.SimulationManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public enum ParentSelection {
    TOURNAMENT_SELECTION{
        @Override
        public Agent[]  SelectParents(int i) {
            Agent[] parents =new Agent[2];
            ArrayList<Agent> contestants = new ArrayList<>();
            Random random = new Random();
            int parentIndex=0;
            while (parentIndex<2){
                while(contestants.size()<SettingsManager.tournamentContestantsNumber) {
                    int randomIndex=random.nextInt(SettingsManager.agentsPerGeneration);
                    if(!contestants.contains(SimulationManager.getInstance().getGenerations()[i].getAgents()[randomIndex])){
                        contestants.add(SimulationManager.getInstance().getGenerations()[i].getAgents()[randomIndex]);
                    }
                }
                contestants.sort(Comparator.comparing(Agent::getScore));
                parents[parentIndex]=contestants.get(contestants.size()-1);
                contestants.clear();
                parentIndex++;
            }
            return parents;
        }
    };

    /***
     * Selects parents for cross-over depending on the way.
     * @param i The index to the generation to select parents from.
     */
    public abstract Agent[] SelectParents(int i);

}
