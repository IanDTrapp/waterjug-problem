package waterjug;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class WaterJugBoard {

	public static Action EMPTY_1 = new DynamicAction("empty1");
	public static Action EMPTY_2 = new DynamicAction("empty2");
	public static Action FILL_1 = new DynamicAction("fill1");
	public static Action FILL_2 = new DynamicAction("fill2");
	public static Action EMPTY_TO_1 = new DynamicAction("emptyTo1");
	public static Action EMPTY_TO_2 = new DynamicAction("emptyTo2");
	
	public WaterJugBoard() {
		
	}

	public static int[] fill1(int[] s) {
		System.out.println("Fill 1");
		s[0] = 4;
		return s;
	}

	public static int[] fill2(int[] s) {
		System.out.println("Fill 2");
		s[1] = 3;
		return s;
	}

	public static int[] empty1(int[] s) {
		System.out.println("Empty 1");
		s[0] = 0;
		return s;
	}

	public static int[] empty2(int[] s) {
		System.out.println("Empty 2");
		s[1] = 0;
		return s;
	}

	public static int[] emptyTo1(int[] s) {
		System.out.println("Empty to 1");
		while(s[0] < 4 && s[1] > 0) {
			s[0]++;
			s[1]--;
		}
		return s;
	}

	public static int[] emptyTo2(int[] s) {
		System.out.println("Empty to 2");
		while(s[1] < 3 && s[0] > 0) {
			s[1]++;
			s[0]--;
		}
		
		//System.out.println("s: " + s);
		return s;
	}

}
