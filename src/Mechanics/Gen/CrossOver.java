package Mechanics.Gen;
import Utility.SettingsManager;
import java.util.concurrent.ThreadLocalRandom;

public enum CrossOver {
    SINGLE_POINT{
        @Override
        public Agent[] ApplyCrossOver(Agent[] parents) {
            Agent[]children = new Agent[2];
            int[] firstChildChromosome=new int[SettingsManager.chromosomeLength];
            int[] secondChildChromosome=new int[SettingsManager.chromosomeLength];
            int randomPoint = ThreadLocalRandom.current().nextInt(1,SettingsManager.chromosomeLength);
            for(int i=0; i<randomPoint;i++){
                firstChildChromosome[i]=parents[0].getChromosome()[i];
                secondChildChromosome[i]=parents[1].getChromosome()[i];
            }
            for(int i=randomPoint; i<SettingsManager.chromosomeLength;i++){
                firstChildChromosome[i]=parents[1].getChromosome()[i];
                secondChildChromosome[i]=parents[0].getChromosome()[i];
            }
            children[0]=new Agent(firstChildChromosome);
            children[1]=new Agent(secondChildChromosome);
            return children;
        }

    };

    /***
     * Apply the selected Cross-Over operation.
     * @param parents The parents to get chromosomes from.
     * @return The children after the Cross-Over.
     */
    public abstract Agent[] ApplyCrossOver(Agent[] parents);
}
