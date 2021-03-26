package Mechanics.Gen;

import java.util.Random;

public class Chromosome {
    int[] chromosome;

    public Chromosome(int length){
        Random random = new Random();
        chromosome=new int[length];
        for(int i=0;i<length;i++){
            //At start generate a random chromosome.
            chromosome[i]= random.nextInt(Action.values().length);
        }
    }

    public int[] getChromosome() {
        return chromosome;
    }
}
