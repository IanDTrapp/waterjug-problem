package waterjug;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class WaterJug {

	public static Action EMPTY_1 = new DynamicAction("empty1");
	public static Action EMPTY_2 = new DynamicAction("empty2");
	public static Action FILL_1 = new DynamicAction("fill1");
	public static Action FILL_2 = new DynamicAction("fill2");
	public static Action EMPTY_TO_1 = new DynamicAction("fillto1");
	public static Action EMPTY_TO_2 = new DynamicAction("fillto2");
	
	public WaterJug() {
		
	}

	public static int[] fill1(int[] s) {
		s[0] = 4;
		return s;
	}

	public static int[] fill2(int[] s) {
		s[1] = 3;
		return s;
	}

	public static int[] empty1(int[] s) {
		s[0] = 0;
		return s;
	}

	public static int[] empty2(int[] s) {
		s[1] = 0;
		return s;
	}

	public static int[] emptyTo1(int[] s) {
		while(s[0] < 4 && s[1] > 0) {
			s[0]++;
			s[1]--;
		}
		return s;
	}

	public static int[] emptyTo2(int[] s) {
		while(s[1] < 3 && s[0] > 0) {
			s[1]++;
			s[0]--;
		}
		return s;
	}	
}
