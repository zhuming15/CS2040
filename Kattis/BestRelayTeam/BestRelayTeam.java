import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;

public class BestRelayTeam {
	private ArrayList<Sprinter> sprinterList;

	BestRelayTeam() {
		Scanner sc = new Scanner(System.in);
		int numOfSprinters = Integer.valueOf(sc.nextLine());
		ArrayList<Sprinter> sprinterList = new ArrayList<Sprinter>();

		for (int counter = 0; counter < numOfSprinters; counter++) {
			String name = String.valueOf(sc.next());
			double firstRunTime = Double.valueOf(sc.next());
			double secondRunTime = Double.valueOf(sc.next());
			sprinterList.add(new Sprinter(name, firstRunTime, secondRunTime));
			//sc.nextLine();
		}
		this.sprinterList = sprinterList;
	}

	public void computeBestTeam() {
		ArrayList<Sprinter> bestTeam = new ArrayList<Sprinter>();
		double bestRecord = 21.0 * 4;

		sprinterList.sort((s1, s2) -> (Double.compare(s1.getSecondRunTime(), s2.getSecondRunTime())));

		for (Sprinter firstLeg : this.sprinterList) {
			double currRecord = firstLeg.getFirstRunTime();
			ArrayList<Sprinter> currTeam = new ArrayList<Sprinter>();
			currTeam.add(firstLeg);
			int pointer = 0;

			while (currTeam.size() < 4) {
				Sprinter nextSprinter = sprinterList.get(pointer);
				if (!firstLeg.equals(nextSprinter)) {
					currRecord += nextSprinter.getSecondRunTime();
					currTeam.add(nextSprinter);
				}
				pointer++;
			}

			if (currRecord < bestRecord) {
				bestRecord = currRecord;
				bestTeam = currTeam;
			}
		}
		System.out.println(bestRecord);

		for (Sprinter s : bestTeam) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		BestRelayTeam BRT = new BestRelayTeam();
		BRT.computeBestTeam();
	}
}

class Sprinter {
	private final String name;
	final double firstRunTime;
	final double secondRunTime;

	Sprinter(String name, double firstRunTime, double secondRunTime) {
		this.name = name;
		this.firstRunTime = firstRunTime;
		this.secondRunTime = secondRunTime;
	}

	protected double getFirstRunTime() {
		return this.firstRunTime;
	}

	protected double getSecondRunTime() {
		return this.secondRunTime;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
