package waterjug;

import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;

public class WaterJugProblem {

	public static void main(String[] args) {
		System.out.println("\nWater Jugs Iterative DS  -->");
		
		int[] initialState = new int[] {0,0};

		try {
			Problem problem = new Problem(initialState,
					WaterJugFunctionFactory.getActionsFunction(),
					WaterJugFunctionFactory.getResultFunction(),
					new WaterJugGoalTest()); 
			
			Search search = new DepthLimitedSearch(3);
			SearchAgent agent = new SearchAgent(problem, search);

			System.out.println();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}

}

