import java.util.*;

class ResearcherComparator implements Comparator<Researcher> {
	@Override
	public int compare(Researcher r1, Researcher r2) {
		return Integer.compare(r1.arrivalTime, r2.arrivalTime);
	}
}
