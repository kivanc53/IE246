package lectures.l10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class HeuristicKnapsackSolution {
	
	private KnapsackProblemInstance knapsackProblemInstance;
	private int bestObjFound = 0;
	private ArrayList<Item> selection;
	String splitChar;
	
	public HeuristicKnapsackSolution(KnapsackProblemInstance knapsackProblemInstance, String splitChar) throws IOException {
		this.knapsackProblemInstance=knapsackProblemInstance;
		this.splitChar = splitChar;
		runAlgorithm();
		printSoln();
	}

	private void runAlgorithm() {

		// include one by one if it fits... 
		// This is based on descending value per weight
		// mostly copied from random algorithm
		
		ArrayList<Item> candidates = sortItems();
		selection = new ArrayList<Item>();

		int totalValue = 0;
		int remainingCapacity = this.knapsackProblemInstance.backpack.capacity;
		
		for(Item i : candidates) // sorted!
		{
			if(i.weight <= remainingCapacity)
			{
				selection.add(i);
				remainingCapacity=remainingCapacity - i.weight;
				totalValue+=i.value;
			}
		}
		this.bestObjFound=totalValue;
	}

	private ArrayList<Item> sortItems() {
		ArrayList<Item> result = new ArrayList<Item>();
		// Find the max value per weight among items not in the result array
		while(result.size() != this.knapsackProblemInstance.items.length)
		{
			double maxVpW = 0;
			Item best=null;
			for(Item i : this.knapsackProblemInstance.items)
			{	
				if(i.valuePerWeight>maxVpW && !result.contains(i))
				{
					maxVpW = i.valuePerWeight;
					best=i;
				}
			}
			result.add(best);
		}
		// Place it in the result array as the last item
		return result;
	}
	
	private void printSoln() throws IOException {
		// Let's write the output of the algo to a file...
		this.knapsackProblemInstance.bufferedWriter.write("Best obj based on value per weight: "+ this.bestObjFound+"\n");
		for(Item i:this.selection)
		{
			this.knapsackProblemInstance.bufferedWriter.write(i.id + this.splitChar+ i.value +this.splitChar+ i.weight+ " \n");
		}
	}

}
