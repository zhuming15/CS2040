import java.util.*;

class Classy {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfTest = io.getInt();
		Person.updateStaticVariable();
		while (numOfTest-- > 0) {
			int numOfPerson = io.getInt();
			PriorityQueue<Person> q = new PriorityQueue<Person>();
			for (int i = 0; i < numOfPerson; i++) {
				String name = io.getWord().replace(":", "");
				String title = io.getWord();
				io.getWord();
				q.add(new Person(name, title));
			}
			while (!q.isEmpty()) {
				io.println(q.poll().toString());
			}
			io.println("==============================");
		}
		io.flush();
		io.close();
	}
}
	
