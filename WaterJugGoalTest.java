package waterjug;

import aima.core.search.framework.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class WaterJugGoalTest implements GoalTest {
	int[] goal = new int[] {2,0};

	public boolean isGoalState(Object state) {
		/*WaterJugBoard thisState =  (WaterJugBoard) state;
		System.out.println("thisState: " + thisState);*/
		int[] thisState = (int[]) state;
		System.out.println("State:" + thisState[0] + " " + thisState[1]);
		System.out.flush();
		if(thisState[0] == goal[0] && thisState[1] == goal[1]) {
			return true;
		} else {
			return false;
		}
		
		//return thisState.equals(goal);
	}
}
