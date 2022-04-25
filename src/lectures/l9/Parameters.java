package lectures.l9;

import java.util.Random;

public class Parameters {

    public int numberOfItems = 10;

    //Suppose these are inclusive bounds (first is lower, second is upper bounds)
    public int[] boundsForWeights = {10, 20}; // for example this might be in kgs
    public int[] boundsForKnapsackSize = {70, 80}; // in kgs

    public int[] boundsForValues = {1500, 2500}; // in TL, USD etc.


    // for data generaiton
    public int seedNumber = 1;
    public Random rng;

    // for the random solution
    public Random rngForSolution;
    public int seedForSolution = 13;
    public int numberOfRandomSolns=99099;
    public Parameters(){
        this.rng = new Random();
        rng.setSeed(this.seedNumber);
    }

}
