package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import data.*;

public class KnapsackProblemInstance {
	public Backpack backpack;
	public Item[] items;
	public String splitChar;
	public FileWriter fileWriter;
	public BufferedWriter bufferedWriter;
	public String outputFile;
	
	
	private void readFile(String inputFileName) throws FileNotFoundException {
		// This will be populated later, where we will read data from some file...
		FileReader fileReader = new FileReader(inputFileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Item> tempItems=new ArrayList<Item>();
		
		
		try {
			String w = bufferedReader.readLine(); 
			// don't do anything with the first line
			
			while(true)
			{
				w = bufferedReader.readLine();
				String [] wa = w.split(this.splitChar);
				if(wa.length==3)
				{
					Item i = new Item(wa[0], wa[1], wa[2]);
					tempItems.add(i);
				}
				else
				{
					String[] capacityLine = wa[0].split(" ");
					this.backpack = new Backpack();
					this.backpack.capacity=Integer.parseInt(capacityLine[capacityLine.length-1]);
					break;				
				}				
			}
			this.items = new Item[tempItems.size()];
			for(int i=0;i<tempItems.size();i++)
			{
				this.items[i]=tempItems.get(i);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public KnapsackProblemInstance(Parameters parameters) throws FileNotFoundException {
		this.splitChar = parameters.splitChar;
		
		if(parameters.isRandom)
			this.createRandomly(parameters);
		else
			this.readFile(parameters.inputFileName);
		
		this.outputFile = parameters.outputFileName;
	}

	private void createRandomly(Parameters parameters) {
		this.items = new Item[parameters.numberOfItems];
		this.backpack = new Backpack();
		this.randomlyCreateItems(parameters);
		this.randomlyCreateBackpack(parameters);
	}

	private void randomlyCreateBackpack(Parameters parameters) {
		this.backpack.capacity = randBetween(parameters.rng, parameters.boundsForKnapsackSize[0],parameters.boundsForKnapsackSize[1]);
	}

	private int randBetween(Random r, int lowerBound, int upperBound) {
		int x = 0;
		x= r.nextInt(upperBound-lowerBound+1)+lowerBound;
		return x; // upperBound included, lowerBound included
	}

	private void randomlyCreateItems(Parameters parameters) {
		for(int i=0;i<this.items.length;i++)
		{
			int value = randBetween(parameters.rng, parameters.boundsForValues[0],parameters.boundsForValues[1]);
			int weight = randBetween(parameters.rng, parameters.boundsForWeights[0],parameters.boundsForWeights[1]);
			items[i] = new Item(i+1, value, weight);
		}
	}

	public void print() throws IOException {
		// Print this on a file
		// BufferedWriter
		
		this.fileWriter = new FileWriter(this.outputFile);
		this.bufferedWriter = new BufferedWriter(fileWriter);
		
		bufferedWriter.write("Item"+ this.splitChar+"Value"+this.splitChar+"Weight"+"\n");
		
		for(Item i : this.items)
			bufferedWriter.write(i.id +this.splitChar+ i.value+this.splitChar+i.weight+"\n");
		bufferedWriter.write("Capacity of Backpack/knapsack: " + this.backpack.capacity+"\n");
		
	}

}
