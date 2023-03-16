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
		pool.add(new Quest(energy, gold));
	}

	void query(int energy) {
		Quest temp = pool.floor(new Quest(energy, largestGold));
		long totalGold = 0;
		while (temp != null) {
			totalGold += temp.gold;
			pool.remove(temp);
			energy -= temp.energy;
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

		



