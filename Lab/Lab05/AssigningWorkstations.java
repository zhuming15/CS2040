import java.util.*;

class AssigningWorkstations {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
//		int numOfResearchers = io.getInt();
//		int autoLockPeriod = io.getInt();
//
//		PriorityQueue<Integer> computerQ = new PriorityQueue<Integer>();
//		PriorityQueue<Researcher> researchersQ = new PriorityQueue<Researcher>(
//				numOfResearchers, new ResearcherComparator());
//
//		computerQ.add(-autoLockPeriod);
//
//		for (int ithResearcher = 0; ithResearcher < numOfResearchers; ithResearcher++) {
//			researchersQ.add(new Researcher(io.getInt(), io.getInt()));
//		}
//		
//		int numOfUnlockSaved = 0;
//
//		while (!researchersQ.isEmpty()) {
//			Researcher curResearcher = researchersQ.peek();
//			int rArrTime = curResearcher.arrivalTime;
//			int mostFreeComputer = computerQ.peek();
//			while (computerQ.size() != 0 && mostFreeComputer + autoLockPeriod < rArrTime) {
//				computerQ.poll();
//			}
//			if (rArrTime < mostFreeComputer) { // Case 1: workstation is occupied by someone
//				io.println("Case1");
//				computerQ.add(curResearcher.computeFinishTime());
//				computerQ.add(mostFreeComputer);
//			} else if (rArrTime <= mostFreeComputer + autoLockPeriod) { // Case 2: workstation is NOT occupied and unlock
//				io.println("Case2");
//				numOfUnlockSaved++;
//				computerQ.add(curResearcher.computeFinishTime());
//			} else { // Case 3: workstation is locked
//				io.println("Case3");
//				computerQ.add(curResearcher.computeFinishTime());
//			}
//			researchersQ.poll();
//		}
		int n = io.getInt();
		int m = io.getInt();

		PriorityQueue<Integer> arrTime = new PriorityQueue<Integer>();
		PriorityQueue<Integer> totalTime = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			int arr = io.getInt();
			int stay = io.getInt();
			arrTime.add(arr);
			totalTime.add(arr+stay);
		}

		int numOfUnlockSaved = 0;

		while (!arrTime.isEmpty()) {
			int curArr = arrTime.poll();
			io.println("f " + curArr + " " + totalTime.peek());
			while (curArr - totalTime.peek() > m) {
				totalTime.poll();
			}
			if (totalTime.peek() <= curArr) {
				totalTime.poll();
				numOfUnlockSaved++;
			}
		}
		io.println(numOfUnlockSaved);
		io.close();
	}
}

