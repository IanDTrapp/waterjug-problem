package waterjug;

import aima.core.search.framework.GoalTest;

public class WaterJugGoalTest implements GoalTest {
	WaterJugBoard goal = new WaterJugBoard(2,0);
	public boolean isGoalState(Object state) {
		System.out.println(state);
		WaterJugBoard jugs = (WaterJugBoard) state;
		return jugs.equals(goal);
	}
}
	