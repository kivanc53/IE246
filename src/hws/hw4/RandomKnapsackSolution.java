package hws.hw4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//Kıvanç Yılmaz S012733

public class RandomKnapsackSolution {

    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        KnapsackProblemInstance knapsackProblemInstance = new KnapsackProblemInstance(parameters);
        knapsackProblemInstance.print();
        System.out.println("şaskdşsakdşakdşa");
        RandomKnapsackSolution randomKnapsackSolution = new RandomKnapsackSolution(knapsackProblemInstance, parameters.rngForSolution, parameters.seedForSolution, parameters.numberOfRandomSolns);

        System.out.println("şaskdşsakdşakdşa");
        RandomKnapsackSolution smartRandomKnapsackSolution = new RandomKnapsackSolution(knapsackProblemInstance, parameters.rngForSolution, parameters.seedForSolution, parameters.numberOfRandomSolns, "smart");
    }

    private KnapsackProblemInstance knapsackProblemInstance;
    private Random rng = new Random();
    private HashMap<Item, Boolean> solution = new HashMap<Item, Boolean>();
    private int bestObjFound = 0;

    public RandomKnapsackSolution(KnapsackProblemInstance knapsackProblemInstance, Random rngForSolution, int seedForSolution, int numberOfRandomSolns) {
        this.knapsackProblemInstance = knapsackProblemInstance;
        this.rng = rng;
        this.rng.setSeed(seedForSolution);
        this.resetSolutionDict();
        for (int i = 0; i < numberOfRandomSolns; i++)
            this.solve();
        this.printBestSoln(numberOfRandomSolns);
    }

    public RandomKnapsackSolution(KnapsackProblemInstance knapsackProblemInstance, Random rngForSolution, int seedForSolution, int numberOfRandomSolns, String str) {
        this.knapsackProblemInstance = knapsackProblemInstance;
        this.rng = rng;
        this.rng.setSeed(seedForSolution);
        for (int i = 0; i < numberOfRandomSolns; i++)
            this.solve2();
        System.out.println("Best obj upon " + numberOfRandomSolns + " random trials: " + this.bestObjFound);
        for (Item i : this.solution.keySet()) {
            if (this.solution.get(i)) {
                System.out.println(i.id + " " + i.value + " " + i.weight + " ");
            }
        }
    }

    private void solve2() {
        ArrayList<Item> selection = new ArrayList<Item>();
        ArrayList<Item> candidates = new ArrayList<Item>();

        for (Item i : this.knapsackProblemInstance.items) {
            candidates.add(i);
        }
        int totalValue = 0;
        int remainingCapacity = this.knapsackProblemInstance.backpack.capacity;

        while (!candidates.isEmpty()) {
            Item i = pickMySelection(candidates);

            candidates.remove(i);
            if (i.weight <= remainingCapacity) {
                selection.add(i);
                remainingCapacity = remainingCapacity - i.weight;
                totalValue += i.value;
            }
        }
        if (totalValue > this.bestObjFound) {
            this.bestObjFound = totalValue;
            this.CopySelectionToHashMap(selection);
        }
    }

    private Item pickMySelection(ArrayList<Item> candidates){
        int weight = this.rng.nextInt(11) + 10;
        int min = Integer.MAX_VALUE, temp = 0, i = 0;
        for (Item item: candidates) {
            if (Math.abs(item.weight - weight) < min) {
                min = item.weight - weight;
                temp = i;
            }
            i++;
        }
        return candidates.get(temp);
    }

    private void printBestSoln(int numberOfRandomSolns) {
        System.out.println("Best obj upon " + numberOfRandomSolns + " random trials: " + this.bestObjFound);
        for (Item i : this.solution.keySet()) {
            if (this.solution.get(i)) {
                System.out.println(i.id + " " + i.value + " " + i.weight + " ");
            }
        }
    }

    private void CopySelectionToHashMap(ArrayList<Item> selection) {
        // given list of selection, update solution HashMap
        this.resetSolutionDict(); // resets everything to false to be on the safe side
        for (Item i : selection) {
            this.solution.put(i, true);
        }
    }

    private void resetSolutionDict() {
        for (Item i : this.knapsackProblemInstance.items) {
            this.solution.put(i, false);
        }
    }

    private void solve() {
        ArrayList<Item> selection = new ArrayList<Item>();
        ArrayList<Item> candidates = new ArrayList<Item>();
        //DO NOT DO THE FOLLOWING!
        //Item[] candidates  = this.knapsackProblemInstance.items;
        for (Item i : this.knapsackProblemInstance.items) {
            candidates.add(i);
        }
        int totalValue = 0;
        int remainingCapacity = this.knapsackProblemInstance.backpack.capacity;

        while (!candidates.isEmpty()) {
            Item i = pickOneRandomly(candidates);

            // Item ij = new Item(1,1504,16);
            // candidates.remove(ij);
            // this would not remove the object,
            // even with same properties
            // because it is not "THAT" object
            // It is some sort of a copy

            candidates.remove(i);
            if (i.weight <= remainingCapacity) {
                selection.add(i);
                remainingCapacity = remainingCapacity - i.weight;
                totalValue += i.value;
            }
        }
        if (totalValue > this.bestObjFound) {
            this.bestObjFound = totalValue;
            this.CopySelectionToHashMap(selection);
        }
    }

    private Item pickOneRandomly(ArrayList<Item> setOfItems) {
        int accessThis = this.rng.nextInt(setOfItems.size());
        return setOfItems.get(accessThis);
    }
}

class KnapsackProblemInstance {
    public Backpack backpack;
    public Item[] items;

    public KnapsackProblemInstance() {
        this.readFile();
    }

    private void readFile() {
        // This will be populated later, where we will read data from some file...
    }

    public KnapsackProblemInstance(Parameters parameters) {
        this.createRandomly(parameters);
    }

    private void createRandomly(Parameters parameters) {
        this.items = new Item[parameters.numberOfItems];
        this.backpack = new Backpack();
        this.randomlyCreateItems(parameters);
        this.randomlyCreateBackpack(parameters);
    }

    private void randomlyCreateBackpack(Parameters parameters) {
        this.backpack.capacity = randBetween(parameters.rng, parameters.boundsForKnapsackSize[0], parameters.boundsForKnapsackSize[1]);
    }

    private int randBetween(Random r, int lowerBound, int upperBound) {
        int x = 0;
        x = r.nextInt(upperBound - lowerBound + 1) + lowerBound;
        return x; // upperBound included, lowerBound included
    }

    private void randomlyCreateItems(Parameters parameters) {
        for (int i = 0; i < this.items.length; i++) {
            int value = randBetween(parameters.rng, parameters.boundsForValues[0], parameters.boundsForValues[1]);
            int weight = randBetween(parameters.rng, parameters.boundsForWeights[0], parameters.boundsForWeights[1]);
            items[i] = new Item(i + 1, value, weight);
        }
    }

    public void print() {
        for (Item i : this.items)
            System.out.println("Item " + i.id + " | Value " + i.value + " | Weight " + i.weight);
        System.out.println("Capacity of Backpack/knapsack: " + this.backpack.capacity);
    }
}

class Item {
    public int id;
    public int value;
    public int weight;

    public Item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
    }
}

class Parameters {

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
    public int numberOfRandomSolns = 99099;

    public Parameters() {
        this.rng = new Random();
        rng.setSeed(this.seedNumber);
    }
}

class Backpack {
    public int capacity;
}