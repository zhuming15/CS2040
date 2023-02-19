import java.util.*;

public class CD {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		int numOfCD = io.getInt() + io.getInt();

		while (numOfCD-- > 0) {
			int currCD = io.getInt();
			if (!hashTable.containsKey(currCD))
				hashTable.put(currCD, 1);
			else
				hashTable.put(currCD, hashTable.get(currCD) + 1);
		}
		int output = 0;
		for (int i : hashTable.values()) {
			if (i != 1)
				output++;
		}
		io.println(output);
		io.close();
	}
}
