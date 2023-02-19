import java.util.*;

public class CD {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		int jackNumOfCD = io.getInt();
		int jillNumOfCD = io.getInt();
		int output = 0;

		while (jackNumOfCD-- > 0) {
			int currCD = io.getInt();
			if (!hashTable.containsKey(currCD))
				hashTable.put(currCD, 1);
		}

		while (jillNumOfCD-- > 0) {
			int currCD = io.getInt();
			if (hashTable.containsKey(currCD)) 
				output++;
		}

		io.println(output);
		io.close();
	}
}
