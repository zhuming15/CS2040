import java.util.*;

public class BackSpace {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Deque<Character> dq = new LinkedList<Character>();

		String input = io.getWord();

		for (int counter = 0; counter < input.length(); counter++) {
			char c = input.charAt(counter);
			if (c == '<') {
				dq.pop();
			}
			else {
				dq.push(c);
			}
		}

		while (dq.size() != 0) {
			io.print(dq.pollLast());
		}
		io.println("");
		io.close();
	}
}
