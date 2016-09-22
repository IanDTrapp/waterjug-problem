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
			int[] jugs = (int[]) state;

			Set<Action> actions = new LinkedHashSet<Action>();

			if (jugs[0] <= 4) {
				actions.add(WaterJug.FILL_1);
			}
			if (jugs[1] <= 3) {
				actions.add(WaterJug.FILL_2);
			}
			if (jugs[0] != 0) {
				actions.add(WaterJug.EMPTY_1);
			}
			if (jugs[1] != 0) {
				actions.add(WaterJug.EMPTY_2);
			}
			if(jugs[0] > 0 && jugs[1] < 3) {
				actions.add(WaterJug.EMPTY_TO_2);
			}
			if(jugs[1] > 0 && jugs[0] < 4) {
				actions.add(WaterJug.EMPTY_TO_1);
			}
			
			
			return actions;
		}
	}

	private static class WJResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			
			int[] state = (int[]) s;
			
			if (WaterJug.FILL_1.equals(a)) {
				int[] thisState = WaterJug.fill1(state);
				return thisState;
				
			} else if (WaterJug.FILL_2.equals(a)) {
				int[] thisState = WaterJug.fill2(state);
				return thisState;
				
			} else if (WaterJug.FILL_1.equals(a)) {
				int[] thisState = WaterJug.empty1(state);
				return thisState;
				
			} else if (WaterJug.FILL_2.equals(a)) {
				int[] thisState = WaterJug.empty2(state);
				return thisState;
				
			} else if (WaterJug.EMPTY_TO_1.equals(a)) {
				int[] thisState = WaterJug.emptyTo1(state);
				return thisState;
				
			} else if (WaterJug.EMPTY_TO_2.equals(a)) {
				int[] thisState = WaterJug.emptyTo2(state);
				return thisState;
				
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}
