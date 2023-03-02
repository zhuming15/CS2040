import java.util.*;

class Conformity {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfInputs = io.getInt();
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		int popular = 0;
		while (numOfInputs-- > 0) {
			int firstC = io.getInt();
			int secondC = io.getInt();
			int thirdC = io.getInt();
			int fourthC = io.getInt();
			int fifthC = io.getInt();
			int[] arr = {firstC, secondC, thirdC, fourthC, fifthC};
			Arrays.sort(arr);
			String s = "" + arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
			int key = table.containsKey(s) ? table.get(s) + 1 : 1;
			table.put(s, key);
			popular = popular < key ? key : popular;
		}
		int counter = 0;
		for (Map.Entry<String, Integer> entry : table.entrySet()) {
			int curr = entry.getValue();
			if (curr == popular)
				counter += popular;
		}
		io.println(counter);
		io.close();
	}
}
