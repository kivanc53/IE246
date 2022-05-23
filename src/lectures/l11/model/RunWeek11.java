package model;
import java.io.IOException;
import gurobi.*;

import algorithm.*;

public class RunWeek11 {
	public static void main(String[] args) throws IOException {
		Parameters parameters = new Parameters();
		KnapsackProblemInstance knapsackProblemInstance = new KnapsackProblemInstance(parameters);
		knapsackProblemInstance.print();	
		HeuristicKnapsackSolution heuristicKnapsackSolution = new HeuristicKnapsackSolution(knapsackProblemInstance, parameters.splitChar);
		OptimalKnapsackSolution optimalKnapsackSolution = new OptimalKnapsackSolution(knapsackProblemInstance, parameters.splitChar);
		RandomKnapsackSolution randomKnapsackSolution = new RandomKnapsackSolution(knapsackProblemInstance,parameters.rngForSolution, parameters.seedForSolution, parameters.numberOfRandomSolns, parameters.splitChar);
		
		/* -- GUROBI GUIDE -- 
		    try {

		      // Create empty environment, set options, and start
		      GRBEnv env = new GRBEnv(true);
		      env.set("logFile", "mip1.log");
		      env.start();

		      // Create empty model
		      GRBModel model = new GRBModel(env);

		      // Create variables
		      GRBVar x = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, "X_"); // knapsack var's
		      GRBVar y = model.addVar(0.0, 10.0, 0.0, GRB.INTEGER, "Y_");
		      GRBVar z = model.addVar(-GRB.INFINITY, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "Z_"); // all variables in IE201 are in this class. Z_>=0

		      // Set objective: maximize x + y + 2 z
		      GRBLinExpr expr = new GRBLinExpr(); // expr = 0
		      expr.addTerm(1.0, x);  // expr = x
		      expr.addTerm(1.0, y);  // expr = x+y 
		      expr.addTerm(2.0, z); // expr = x+y+2z
		      model.setObjective(expr, GRB.MAXIMIZE);
		      
		      // The note below is not my suggested routine. 
		      // I recommend introducing an expression and setting objective as shown above.
		      
		      // if you use the third input of addVar to provide the objective coefficients,
		      // then you specify if it's a max or min problem as follows:
		      // model.set(GRB.IntAttr.ModelSense , GRB.MAXIMIZE);

		      
		      
		      // Add constraint: x + 2 y + 3 z <= 4
		      GRBLinExpr expr2 = new GRBLinExpr(); // expr2 = 0
		      expr2.addTerm(1.0, x); 
		      expr2.addTerm(2.0, y); 
		      expr2.addTerm(3.0, z); // expr2 = x+2y+3z
		      model.addConstr(expr2, GRB.LESS_EQUAL, 4.0, "c0");

		      // Add constraint: x + y >= 1
		      expr = new GRBLinExpr(); // expr = 0
		      expr.addTerm(1.0, x); 
		      expr.addTerm(1.0, y);
		      model.addConstr(expr, GRB.GREATER_EQUAL, 1.0, "c1");

		      // Next line is optional to verify the math model
		      model.write("model.lp");
		      
		      // Optimize model
		      model.optimize();
		      

		      System.out.println(x.get(GRB.StringAttr.VarName)
		                         + " " +x.get(GRB.DoubleAttr.X)); // X indicates optimality
		      System.out.println(y.get(GRB.StringAttr.VarName)
		                         + " " +y.get(GRB.DoubleAttr.X));
		      System.out.println(z.get(GRB.StringAttr.VarName)
		                         + " " +z.get(GRB.DoubleAttr.X));

		      System.out.println("Obj: " + model.get(GRB.DoubleAttr.ObjVal));

		      // Dispose of model and environment
		      model.dispose();
		      env.dispose();

		    } catch (GRBException e) {
		      System.out.println("Error code: " + e.getErrorCode() + ". " +
		                         e.getMessage());
		    }
		  */
		// Problem instance (read from file, random)
		// A few solution algorithms
		// Analysis
		
		// input
		// random -> input
		// output_random
		// output_exactSoln
		// output_heur
		
	}
}
