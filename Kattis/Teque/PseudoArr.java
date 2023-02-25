import java.util.*;

public class PseudoArr {
	public HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();
	public int head = 0;
	public int tail = 0;
	public int numOfItems = 0;

	public int size() { return numOfItems; }

	public int get(int index) { return arr.get(head + index); }

	public void pushFront(int item) {
		numOfItems++;
		if (arr.isEmpty()) {
			arr.put(head, item);
			return;
		}
		head--;
		arr.put(head, item);
	}

	public void pushBack(int item) {
		numOfItems++;
		if (arr.isEmpty()) {
			arr.put(tail, item);
			return;
		}
		tail++;
		arr.put(tail, item);
	}

	public int removeBack() {
		numOfItems--;
		int backItem = arr.get(tail);
		arr.remove(tail);
		if (numOfItems == 0) {
			tail = 0;
			head = 0;
			return backItem;
		}
		tail--;
		return backItem;
	}

	public int removeFront() {
		numOfItems--;
		int frontItem = arr.get(head);
		arr.remove(head);
		if (numOfItems == 0) {
			tail = 0;
			head = 0;
			return frontItem;
		}
		head++;
		return frontItem;
	}

	@Override
	public String toString() {
		return arr.toString();
	}
}
