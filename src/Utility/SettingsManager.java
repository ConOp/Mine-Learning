package MineLearning.Utility;


public class SettingsManager {

    public static int chromosomeLength=150;
    public static int agentsPerGeneration=2000;
    public static int generations=500;
    public static int moveScore=0;
    public static int obstacleScore=-10;
    public static int gemCollectScore=5;
    public static int invalidGemCollectScore=-5;
    public static int width=10;
    public static int height=10;
    public static int imageLabelOffset=5;
    public static int imageLabelWidth=64;
    public static int imageLabelHeight=64;
    public static float gemChance=0.3f;
    public static int tournamentContestantsNumber=3;
    public static float chanceMutationToHappen=1f;
    public static float chanceToMutate=0.009f;
    public static float chanceChromosomeFromBestParent=0.6f;

}
