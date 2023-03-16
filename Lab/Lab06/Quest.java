import java.util.*;

class Quest {
	public int energy;
	public int gold;
	public int repitition = 1;

	Quest(int energy, int gold) {
		this.energy = energy;
		this.gold = gold;
	}

	void addRepitition() {
		repitition += 1;
	}

	void subtractRepitition() {
		repitition -= 1;
	}

	@Override
	public String toString() {
		return String.format("[%d : %d]", energy, gold);
	}
}
