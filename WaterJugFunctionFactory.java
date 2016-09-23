package waterjug;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class WaterJugFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new WJActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new WJResultFunction();
		}
		return _resultFunction;
	}

	private static class WJActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			WaterJugBoard jugs = (WaterJugBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

		
				if(jugs.getJug1Val() < 4) {
					actions.add(WaterJugBoard.FILL_1);
				}
				if(jugs.getJug2Val() < 3) {
					actions.add(WaterJugBoard.FILL_2);
				}
				if(jugs.getJug1Val() > 0) {
					actions.add(WaterJugBoard.EMPTY_1);
				}
				if(jugs.getJug2Val() > 0) {
					actions.add(WaterJugBoard.EMPTY_2);
				}
				if(jugs.getJug1Val() > 0) {
					actions.add(WaterJugBoard.EMPTY_TO_2);
				}
				if(jugs.getJug2Val() > 0) {
					actions.add(WaterJugBoard.EMPTY_TO_1);
				}
			
			
			return actions;
		}
	}

	private static class WJResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			
			System.out.println("Action: " + a);
			if (WaterJugBoard.FILL_1.equals(a)) {
				WaterJugBoard newJug = new WaterJugBoard();
				newJug.fill1();
				return newJug;
				
			} else if (WaterJugBoard.FILL_2.equals(a)) {
				WaterJugBoard newJug = new WaterJugBoard();
				newJug.fill2();
				return newJug;
				
			} else if (WaterJugBoard.EMPTY_1.equals(a)) {
				WaterJugBoard newJug = new WaterJugBoard();
				newJug.empty1();
				return newJug;
				
			} else if (WaterJugBoard.EMPTY_2.equals(a)) {
				WaterJugBoard newJug = new WaterJugBoard();
				newJug.empty2();
				return newJug;
				
			} else if (WaterJugBoard.EMPTY_TO_1.equals(a)) {
				WaterJugBoard newJug = new WaterJugBoard();
				newJug.emptyTo1();
				return newJug;
				
			} else if (WaterJugBoard.EMPTY_TO_2.equals(a)) {
				WaterJugBoard newJug = new WaterJugBoard();
				newJug.emptyTo2();
				return newJug;
			}

			//System.out.println("Didnt choose an action");
			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}
