import java.util.*;

class Teque {
	public ListUsingArray frontArr = new ListUsingArray();
	public ListUsingArray backArr = new ListUsingArray();

	public int size() {
		return frontArr.size() + backArr.size();
	}

	public void pushFront(int item) {
		frontArr.addFront(item);
	}

	public void pushBack(int item) {
		backArr.addBack(item);
	}

	public void pushMiddle(int item) {
		frontArr.addBack(item);
	}

	public int get(int index) {
		if (index < 0 || index > size()-1) {
			System.out.println(index);
			System.out.println("from Teque get");
			System.out.println("invalid index");
			System.exit(1);
		}
		if (index < frontArr.size()) 
			return frontArr.getItemAtIndex(index);
		else
			return backArr.getItemAtIndex(index-frontArr.size());
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Teque tq = new Teque();
		int numOfOperations = io.getInt();
		while (numOfOperations-- > 0) {
			String command = io.getWord();
			int input = io.getInt();
			if (command.equals("push_back"))
				tq.pushBack(input);
			else if (command.equals("push_front"))
				tq.pushFront(input);
			else if (command.equals("push_middle"))
				tq.pushMiddle(input);
			else
				io.println(tq.get(input));
		}
		io.close();
	}
}
