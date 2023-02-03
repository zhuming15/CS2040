import java.util.ArrayList;
import java.io.*;

public class BestRelayTeam {
	private ArrayList<Sprinter> sprinterList;

	BestRelayTeam() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfSprinters = Integer.parseInt(br.readLine());
		ArrayList<Sprinter> sprinterList = new ArrayList<Sprinter>();

		for (int counter = 0; counter < numOfSprinters; counter++) {
			String[] strarr = br.readLine().split(" ");
			String name = strarr[0];
			double firstRunTime = Double.parseDouble(strarr[1]);
			double secondRunTime = Double.parseDouble(strarr[2]);
			sprinterList.add(new Sprinter(name, firstRunTime, secondRunTime));
		}
		this.sprinterList = sprinterList;
	}

	public void computeBestTeam() {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
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
		pw.println(bestRecord);

		for (Sprinter s : bestTeam) pw.println(s);

		pw.flush();
		pw.close();
	}

	public static void main(String[] args) throws IOException {
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
