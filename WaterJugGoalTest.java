package waterjug;

import aima.core.search.framework.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class WaterJugGoalTest implements GoalTest {
	int[] goal = new int[] {2,0};

	public boolean isGoalState(Object state) {
		int[] thisState =  (int[]) state;
		return thisState.equals(goal);
	}
}
