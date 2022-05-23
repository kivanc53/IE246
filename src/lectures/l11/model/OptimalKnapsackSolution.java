package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import gurobi.*;
import data.Item;

public class OptimalKnapsackSolution {
	
	private KnapsackProblemInstance knapsackProblemInstance;
	private int bestObjFound = 0;
	private ArrayList<Item> selection;
	String splitChar;
	
	public OptimalKnapsackSolution(KnapsackProblemInstance knapsackProblemInstance, String splitChar) throws IOException {
		this.knapsackProblemInstance=knapsackProblemInstance;
		this.splitChar = splitChar;
		runAlgorithm();
		printSoln();
	}

	private void printSoln() throws IOException {
		this.knapsackProblemInstance.bufferedWriter.write("OPTIMAL SOLUTION: "+ this.bestObjFound+"\n");
		for(Item i:this.selection)
		{
			this.knapsackProblemInstance.bufferedWriter.write(i.id + this.splitChar+ i.value +this.splitChar+ i.weight+ " \n");
		}
	}

	private void runAlgorithm() {
		try {
		      GRBEnv env = new GRBEnv(true);
		      env.set("logFile", "knapsack.log");
		      env.start();

		      // Create empty model
		      GRBModel model = new GRBModel(env);

		      // Create variables
		      HashMap<Item,GRBVar> X = new HashMap<Item,GRBVar>();
		      for(Item i : this.knapsackProblemInstance.items)
		      {
		    	  GRBVar newVar = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, "X("+i.id+")");
		    	  X.put(i, newVar);
		      }
		      		      
		      GRBLinExpr expr = new GRBLinExpr();
		      for(Item i : this.knapsackProblemInstance.items)
		      {
		    	  expr.addTerm(i.value, X.get(i));
		      }		      
		      model.setObjective(expr, GRB.MAXIMIZE);
		      		      
		      
		      expr = new GRBLinExpr();
		      for(Item i : this.knapsackProblemInstance.items)
		      {
		    	  expr.addTerm(i.weight, X.get(i));
		      }
		      model.addConstr(expr, GRB.LESS_EQUAL, this.knapsackProblemInstance.backpack.capacity, "CAPACITY");

		      model.write("knapsack.lp");
		      model.optimize();
		      

		      this.selection = new ArrayList<Item>();
		      for(Item i : this.knapsackProblemInstance.items)
		      {
		    	  if(X.get(i).get(GRB.DoubleAttr.X)>=.5) // if Xi>=0.5, then selected
		    	  {
		    		  this.selection.add(i);
		    	  }
		      }
		      this.bestObjFound = (int) model.get(GRB.DoubleAttr.ObjVal);

		      // Dispose of model and environment
		      model.dispose();
		      env.dispose();

		    } catch (GRBException e) {
		      System.out.println("Error code: " + e.getErrorCode() + ". " +
		                         e.getMessage());
		    }
	}

}
