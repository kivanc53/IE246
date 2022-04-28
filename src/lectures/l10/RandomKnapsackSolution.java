package lectures.l10;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomKnapsackSolution {

	private KnapsackProblemInstance knapsackProblemInstance;
	private Random rng = new Random();
	private HashMap<Item,Boolean> solution = new HashMap<Item,Boolean>();
	private int bestObjFound = 0;
	String splitChar;
	
	public RandomKnapsackSolution(KnapsackProblemInstance knapsackProblemInstance, Random rngForSolution, int seedForSolution, int numberOfRandomSolns, String splitChar) throws IOException {
		this.knapsackProblemInstance=knapsackProblemInstance;
		this.rng = rng;
		this.splitChar = splitChar;
		this.rng.setSeed(seedForSolution);
		this.resetSolutionDict();
		for(int i=0;i<numberOfRandomSolns;i++)
			this.solve();
		this.printBestSoln(numberOfRandomSolns);
	}
	
	private void printBestSoln(int numberOfRandomSolns) throws IOException {
		// Let's write the output of the algo to a file...
		this.knapsackProblemInstance.bufferedWriter.write("Best obj upon "+numberOfRandomSolns+" random trials: "+ this.bestObjFound+"\n");
		for(Item i:this.solution.keySet())
		{
			if(this.solution.get(i))
			{
				System.out.println(this.splitChar);
				this.knapsackProblemInstance.bufferedWriter.write(i.id + this.splitChar+ i.value +this.splitChar+ i.weight+ " \n");
			}
		}
		this.knapsackProblemInstance.bufferedWriter.close();
		this.knapsackProblemInstance.fileWriter.close();
	}

	private void CopySelectionToHashMap(ArrayList<Item> selection) {
		// given list of selection, update solution HashMap
		this.resetSolutionDict(); // resets everything to false to be on the safe side
		for(Item i:selection)
		{
			this.solution.put(i,true);
		}
	}
	
	private void resetSolutionDict() {
		for(Item i: this.knapsackProblemInstance.items)
		{
			this.solution.put(i, false);
		}		
	}
	
	private void solve() {
		ArrayList<Item> selection = new ArrayList<Item>();
		ArrayList<Item> candidates = new ArrayList<Item>();
        //DO NOT DO THE FOLLOWING!
		//Item[] candidates  = this.knapsackProblemInstance.items;
		for(Item i:this.knapsackProblemInstance.items)
		{
			candidates.add(i);
		}
		int totalValue = 0;
		int remainingCapacity = this.knapsackProblemInstance.backpack.capacity;
		
		while(!candidates.isEmpty())
		{
			Item i = pickOneRandomly(candidates);
			
			// Item ij = new Item(1,1504,16);
			// candidates.remove(ij); 
			// this would not remove the object, 
			// even with same properties 
			// because it is not "THAT" object
			// It is some sort of a copy
			
			candidates.remove(i);
			if(i.weight <= remainingCapacity)
			{
				selection.add(i);
				remainingCapacity=remainingCapacity - i.weight;
				totalValue+=i.value;
			}
		}
		if(totalValue>this.bestObjFound)
		{
			this.bestObjFound=totalValue;
			this.CopySelectionToHashMap(selection);
		}
	}
	
	private Item pickOneRandomly(ArrayList<Item> setOfItems) {
		int accessThis=this.rng.nextInt(setOfItems.size());
		return setOfItems.get(accessThis);
	}
	

}
