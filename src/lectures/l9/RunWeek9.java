package lectures.l9;

public class RunWeek9 {
    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        KnapsackProblemInstance knapsackProblemInstance = new KnapsackProblemInstance(parameters);
        knapsackProblemInstance.print();
        RandomKnapsackSolution randomKnapsackSolution = new RandomKnapsackSolution(knapsackProblemInstance,parameters.rngForSolution, parameters.seedForSolution, parameters.numberOfRandomSolns);
    }
}
