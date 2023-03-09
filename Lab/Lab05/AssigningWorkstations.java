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
		
		int numOfUnlock = 0;

		while (!researchersQ.isEmpty()) {
			Researcher curResearcher = researchersQ.poll();
			int bestComputer = computerQ.poll();
			if (curResearcher.arrivalTime < bestComputer) {
				numOfUnlock++;
				computerQ.add(curResearcher.computeFinishTime());
				computerQ.add(bestComputer);
			} else if (curResearcher.arrivalTime < bestComputer + autoLockPeriod) {
				computerQ.add(curResearcher.computeFinishTime());
			} else {
				numOfUnlock++;
				computerQ.add(curResearcher.computeFinishTime());
			}
		}
		io.println(numOfUnlock);
		io.close();
	}
}

