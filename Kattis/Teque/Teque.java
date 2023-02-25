import java.util.*;

class Teque {
	public Arr frontArr = new Arr();
	public Arr backArr = new Arr();

	public int size() { return frontArr.size() + backArr.size(); }

	public void pushFront(int item) {
		if (frontArr.size() > backArr.size()) {
			int shiftItem = frontArr.removeBack();
			backArr.pushFront(shiftItem);
		}
		frontArr.pushFront(item);
	}

	public void pushBack(int item) {
		if (backArr.size() > frontArr.size()) {
			int shiftItem = backArr.removeFront();
			frontArr.pushBack(shiftItem);
		}
		backArr.pushBack(item);
	}

	public void pushMiddle(int item) {
		int insertionIndex = (this.size() + 1) / 2;
		while (frontArr.size() != insertionIndex) {
			frontArr.pushBack(backArr.removeFront());
		}
		backArr.pushFront(item);
	}

	public int get(int index) {
		if (index < frontArr.size()) {
			return frontArr.get(index);
		}
		return backArr.get(index-frontArr.size());
	}

	public void print() {
		System.out.println(frontArr.toString());
		System.out.println(backArr.toString());
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Teque tq = new Teque();
		int numOfOperations = io.getInt();
		while(numOfOperations-- > 0) {
			String command = io.getWord();
			int input = io.getInt();
			if (command.equals("push_front"))
				tq.pushFront(input);
			else if (command.equals("push_back"))
				tq.pushBack(input);
			else if (command.equals("push_middle"))
				tq.pushMiddle(input);
			else
				io.println(tq.get(input));
		}
		io.close();
	}
}
