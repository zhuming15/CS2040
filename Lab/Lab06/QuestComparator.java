import java.util.*;

class QuestComparator implements Comparator<Quest> {
	@Override
	public int compare(Quest q1, Quest q2) {
		int temp = Integer.compare(q1.energy, q2.energy);
		if (temp == 0) 
			return Integer.compare(q1.gold, q2.gold);
		return temp;
	}
}
