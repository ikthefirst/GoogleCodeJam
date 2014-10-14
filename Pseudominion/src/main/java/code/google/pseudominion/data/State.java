package code.google.pseudominion.data;

public class State {

	public final int hand;
	public final int turns;
	public final int t;
	public final int c1;
	public final int c2;

	public State(int hand, int turns, int t, int c1, int c2) {
		super();
		this.hand = hand;
		this.turns = turns;
		this.t = t;
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c1;
		result = prime * result + c2;
		result = prime * result + hand;
		result = prime * result + t;
		result = prime * result + turns;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		State other = (State) obj;
		if (c1 != other.c1) {
			return false;
		}
		if (c2 != other.c2) {
			return false;
		}
		if (hand != other.hand) {
			return false;
		}
		if (t != other.t) {
			return false;
		}
		if (turns != other.turns) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "State [hand=" + hand + ", turns=" + turns + ", t=" + t
				+ ", c1=" + c1 + ", c2=" + c2 + "]";
	}

}
