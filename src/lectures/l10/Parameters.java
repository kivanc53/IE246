package lectures.l10;

import java.util.Random;

public class Parameters {

	public int numberOfItems = 25;
	
	public boolean isRandom = true;
	public String inputFileName = "in.csv";
	public String outputFileName = "out.csv";
	
	//Suppose these are inclusive bounds (first is lower, second is upper bounds)
	public int[] boundsForWeights = {10, 20}; // for example this might be in kgs
	public int[] boundsForKnapsackSize = {90, 110}; // in kgs
	
	public int[] boundsForValues = {150, 250}; // in TL, USD etc.
	
	public String splitChar = ",";
	// for data generaiton
	public int seedNumber = 1;
	public Random rng;
	
	// for the random solution
	public Random rngForSolution;
	public int seedForSolution = 13;
	public int numberOfRandomSolns=9999;
	
	public Parameters(){
		this.rng = new Random();
		rng.setSeed(this.seedNumber);
	}
	
}
