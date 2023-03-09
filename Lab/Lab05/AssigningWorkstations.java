import java.util.*;

class AssigningWorkstations {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfResearchers = io.getInt();
		int autoLockPeriod = io.getInt();

		PriorityQueue<Integer> computerQ = new PriorityQueue<Integer>();
		PriorityQueue<Researcher> researchersQ = new PriorityQueue<Researcher>(
				numOfResearchers, new ResearcherComparator());

		computerQ.add(-autoLockPeriod);

		for (int ithResearcher = 0; ithResearcher < numOfResearchers; ithResearcher++) {
			researchersQ.add(new Researcher(io.getInt(), io.getInt()));
		}
		
		int numOfUnlockSaved = 0;

		while (!researchersQ.isEmpty()) {
			Researcher curResearcher = researchersQ.poll();
			int mostFreeComputer = computerQ.poll();
			int researcherArrTime = curResearcher.arrivalTime;
			if (researcherArrTime < mostFreeComputer) {
				computerQ.add(curResearcher.computeFinishTime());
				computerQ.add(mostFreeComputer);
			} else if (researcherArrTime <= mostFreeComputer + autoLockPeriod) {
				numOfUnlockSaved++;
				computerQ.add(curResearcher.computeFinishTime());
			} else {
				computerQ.add(curResearcher.computeFinishTime());
			}
		}
		io.println(numOfUnlockSaved);
		io.close();
	}
}

