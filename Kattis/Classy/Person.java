import java.util.*;

class Person implements Comparable<Person> {
	static Hashtable<String, Integer> hierarchy = new Hashtable<String, Integer>();
	String name;
	int[] rank = new int[10];
	int numOfWords;

	Person(String name, String title) {
		String[] titleList = title.split("-");
		int index = 0;
		this.numOfWords = titleList.length;
		this.name = name;
		for (int i = numOfWords - 1; i >= 0; i--) {
			rank[index] = hierarchy.get(titleList[i]);
			++index;
		}
	}

	public static void updateStaticVariable() {
		Person.hierarchy.put("upper" , 3);
		Person.hierarchy.put("middle", 2);
		Person.hierarchy.put("lower" , 1);
	}

	@Override
	public int compareTo(Person other) {
		int loopNum = Math.min(other.numOfWords, this.numOfWords);
		for (int i = 0; i < loopNum; i++) {
			if (this.rank[i] == other.rank[i]) { 
				continue;  
			} else if (this.rank[i] >  other.rank[i]) { 
				return -1; 
			} else if (this.rank[i] < other.rank[i]) {
				return 1;
			}
		}
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
