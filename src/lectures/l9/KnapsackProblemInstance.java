package lectures.l9;

import java.util.Random;

public class KnapsackProblemInstance {
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
