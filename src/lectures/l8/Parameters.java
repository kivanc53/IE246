package lectures.l8;

import java.util.Random;

public class Parameters {

    public int numberOfItems = 5;

    //Suppose these are inclusive bounds (first is lower, second is upper bounds)
    public int[] boundsForWeights = {10, 20}; // for example this might be in kgs
    public int[] boundsForKnapsackSize = {70, 80}; // in kgs

    public int[] boundsForValues = {1500, 2500}; // in TL, USD etc.
    public int seedNumber = 1;

    public Random rng;

    public Parameters(){
        this.rng = new Random();
        rng.setSeed(this.seedNumber);
    }

}
