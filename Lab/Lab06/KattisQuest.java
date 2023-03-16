import java.util.*;

class KattisQuest {
	public TreeSet<Quest> pool = new TreeSet<Quest>(new QuestComparator());
	public int N;
	private int largestGold = 0;
	private static Kattio io = new Kattio(System.in, System.out);

	KattisQuest(int N) {
		this.N = N;
	}

	void add(int energy, int gold) {
		if (gold > largestGold) largestGold = gold + 1;
		Quest temp = new Quest(energy, gold);
		if (pool.contains(temp)) { pool.ceiling(temp).addRepitition(); }
		else { pool.add(temp); }
	}

	void query(int energy) {
		Quest temp = pool.floor(new Quest(energy, largestGold));
		long totalGold = 0;
		while (temp != null) {
			totalGold += temp.gold;
			energy -= temp.energy;
			if (temp.repitition == 1) { pool.remove(temp); }
			else { temp.subtractRepitition(); } 
			temp = pool.floor(new Quest(energy, largestGold));
		}
		io.println(totalGold);
	}

	public static void main(String[] args) {
		KattisQuest test = new KattisQuest(io.getInt());
		for (int i = 0; i < test.N; i++) {
			String command = io.getWord();
			if (command.equals("add")) {
				test.add(io.getInt(), io.getInt());
			} else {
				test.query(io.getInt());
			}
		}
		io.close();
	}
}

		



