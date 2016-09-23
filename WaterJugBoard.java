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
	private static int[] state;
	
	static int JUG_1_MAX = 4;
	static int JUG_2_MAX = 3;
	
	public WaterJugBoard() {
		state = new int[] {0,0};
	}
	
	public WaterJugBoard(int a, int b) {
		state = new int[] {0,0};
		
		setJug1Val(a);
		setJug2Val(b);
	}
	
	public int[] getState() {
		return state;
	}
	
	public int getJug1Val() {
		return state[0];
	}
	
	public int getJug2Val() {
		return state[1];
	}
	
	public static void setJug1Val(int val) {
		state[0] = val;
	}
	
	public static void setJug2Val(int val) {
		state[1] = val;
	}

	public void fill1() {
		System.out.println("Fill 1");
		setJug1Val(4);
	}

	public void fill2() {
		System.out.println("Fill 2");
		setJug2Val(3);
	}

	public void empty1() {
		System.out.println("Empty 1");
		setJug1Val(0);
	}

	public void empty2() {
		System.out.println("Empty 2");
		setJug2Val(0);
	}

	public void emptyTo1() {
		System.out.println("Empty to 1");
		if(getJug2Val() > JUG_1_MAX - getJug1Val()) {
			setJug2Val(getJug2Val() - (JUG_1_MAX - getJug1Val()));
			setJug1Val(JUG_1_MAX);
		}
		else {
			setJug1Val(getJug1Val() + getJug2Val());
			setJug2Val(0);
		}
		
	}

	public void emptyTo2() {
		System.out.println("Empty to 2");
		if(getJug1Val() > JUG_2_MAX - getJug2Val()) {
			setJug1Val(getJug1Val() - (JUG_2_MAX - getJug2Val()));
			setJug2Val(JUG_2_MAX);
		} else {
			setJug2Val(getJug2Val() + getJug1Val());
			setJug1Val(0);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("Equals function: " + o);
		WaterJugBoard state = (WaterJugBoard) o;
		if(state.getJug1Val() == getJug1Val() && state.getJug2Val() == getJug2Val()) {
			return true;
		}
		return false;
	}
}
