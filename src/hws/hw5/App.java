package hws.hw5;




/*
Q1 (100 pts) Assume that you need to assign 7 workers to 14 shifts.
Names of the shifts are "Mon1", "Tue2", "Wed3", "Thu4", "Fri5", "Sat6", "Sun7", "Mon8", "Tue9", "Wed10", "Thu11", "Fri12", "Sat13", "Sun14". ok
For each shift, there is a minimum required number of workers of 3, 2, 4, 4, 5, 6, 5, 2, 2, 3, 4, 6, 7, 5, respectively. ok
Workers you need to assign are Amy, Bob, Cathy, Dan, Ed, Fred, and Gu.
The amount you pay to each of these workers for a shift that they are assigned to is 10, 12, 10, 8, 8, 9, 11, respectively.
Not every worker is available for every shift. The availability matrix is as follows, where rows represent workers and columns represent shifts:
int availability[] =
{{ 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 },
{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
{ 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1 },
{ 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1 },
{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};
Formulate a model where you try to minimize the total payment amount. Obtain the optimal solution using Gurobi.
For each shift, print out the names of the workers that are assigned to that shift.
BONUS (20 pts)  Read the necessary data from a csv file and write the solution on another csv file.
You must submit an example file in the format that you have written the read data code.
 */


import gurobi.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        HashMap<String, Integer> myShifts = new HashMap<>();
        myShifts.put("Mon1", 3);
        myShifts.put("Tue2", 2);
        myShifts.put("Wed3", 4);
        myShifts.put("Thu4", 4);
        myShifts.put("Fri5", 5);
        myShifts.put("Sat6", 6);
        myShifts.put("Sun7", 5);
        myShifts.put("Mon8", 2);
        myShifts.put("Tue9", 2);
        myShifts.put("Wed10", 3);
        myShifts.put("Thu11", 4);
        myShifts.put("Fri12", 6);
        myShifts.put("Sat13", 7);
        myShifts.put("Sun14", 5);

        HashMap<String, Integer> myWorkers = new HashMap<>();
        myWorkers.put("Amy", 10);
        myWorkers.put("Bob", 12);
        myWorkers.put("Cathy", 10);
        myWorkers.put("Dan", 8);
        myWorkers.put("Ed", 8);
        myWorkers.put("Fred", 9);
        myWorkers.put("Gu", 11);

        int[][] availability = new int[][]{
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        run(myShifts, myWorkers, availability);


    }

    public static void run(HashMap<String, Integer> shifts, HashMap<String, Integer> workers, int[][] available) {
        try {
            int lengthWorkers = workers.size(), lengthShifts = shifts.size();

            GRBEnv environment = new GRBEnv();
            GRBModel model = new GRBModel(environment);
            model.set(GRB.StringAttr.ModelName, "assignment");

            GRBVar[][] matrix = new GRBVar[lengthWorkers][lengthShifts];
            for (int i = 0; i < lengthWorkers; i++) {
                for (int j = 0; j < lengthShifts; j++) {
                    matrix[i][j] = model.addVar(0, available[i][j], workers.get(new ArrayList<>(workers.keySet()).get(i)),
                            GRB.CONTINUOUS, new ArrayList<>(workers.keySet()).get(i) + "." + new ArrayList<>(shifts.keySet()).get(j));
                }
            }

            GRBVar[] slacks = new GRBVar[lengthShifts];
            for (int s = 0; s < lengthShifts; ++s) {
                slacks[s] =
                        model.addVar(0, GRB.INFINITY, 0, GRB.CONTINUOUS,
                                new ArrayList<>(shifts.keySet()).get(s) + "Slack");
            }

            GRBVar totSlack = model.addVar(0, GRB.INFINITY, 0, GRB.CONTINUOUS,"totSlack");

            GRBVar[] totShifts = new GRBVar[lengthWorkers];
            for (int w = 0; w < lengthWorkers; ++w) {
                totShifts[w] = model.addVar(0, GRB.INFINITY, 0, GRB.CONTINUOUS,
                        new ArrayList<>(workers.keySet()).get(w) + "TotShifts");
            }

            model.set(GRB.IntAttr.ModelSense, GRB.MINIMIZE);
            for (int i = 0; i < lengthShifts; i++) {
                GRBLinExpr linExpr = new GRBLinExpr();
                for (int j = 0; j < lengthWorkers; j++) {
                    linExpr.addTerm(1.0, matrix[j][i]);
                }
                model.addConstr(linExpr, GRB.EQUAL, new ArrayList<>(shifts.values()).get(i), new ArrayList<>(shifts.keySet()).get(i));
            }

            model.optimize();
            int status = model.get(GRB.IntAttr.Status);
            switch (status){
                case GRB.Status.UNBOUNDED -> {
                    System.out.println("model cannot be solved");
                    return;
                }
                case GRB.Status.OPTIMAL -> {
                    System.out.println("The optimal objective is " + model.get(GRB.DoubleAttr.ObjVal));

                    System.out.println("\nTotal slack required: " + totSlack.get(GRB.DoubleAttr.X));
                    for (int w = 0; w < lengthWorkers; ++w) {
                        System.out.println(new ArrayList<>(workers.keySet()).get(w) + " worked " + totShifts[w].get(GRB.DoubleAttr.X) + " shifts");
                    }
                    System.out.println("\n");

                    return;
                }
                default -> {
                    if (status != GRB.Status.INF_OR_UNBD && status != GRB.Status.INFEASIBLE) {
                        System.out.println("Optimization was stopped with status " + status);
                        return;
                    } else{
                        System.out.println("The model is infeasible; computing IIS");
                        model.computeIIS();
                        System.out.println("\nThe following constraint(s) "
                                + "cannot be satisfied:");
                        for (GRBConstr c : model.getConstrs()) {
                            if (c.get(GRB.IntAttr.IISConstr) == 1) {
                                System.out.println(c.get(GRB.StringAttr.ConstrName));
                            }
                        }
                        model.dispose();
                        environment.dispose();
                    }
                }
            }


        } catch (GRBException e) {
            e.printStackTrace();
        }
    }
}
