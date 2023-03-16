import java.util.*;

class Quest {
	public int energy;
	public int gold;

	Quest(int energy, int gold) {
		this.energy = energy;
		this.gold = gold;
	}

	@Override
	public String toString() {
		return String.format("[%d : %d]", energy, gold);
	}
}
