import java.util.*;

class Arr {
	public int capacity = 10;
	public int[] arr = new int[capacity];
	public int headIndex = capacity/2;
	public int tailIndex = capacity/2;
	public int numOfItems = 0;

	public boolean isEmpty() { return numOfItems == 0; }

	public int size() { return numOfItems; }

	public int get(int index) { return arr[headIndex+index]; }
	
	public void pushFront(int item) {
		if (this.isEmpty()) {
			numOfItems++;
			arr[headIndex] = item;
			return;
		}
		numOfItems++;
		headIndex--;
		arr[headIndex] = item;
	}

	public void pushBack(int item) {
		if (this.isEmpty()) {
			numOfItems++;
			arr[tailIndex] = item;
			return;
		}
		numOfItems++;
		tailIndex++;
		arr[tailIndex] = item;
	}

	public int removeFront() {
		numOfItems--;
		if (this.isEmpty())
			return arr[headIndex];
		int temp = arr[headIndex];
		headIndex++;
		return temp;
	}

	public int removeBack() {
		numOfItems--;
		if (this.isEmpty())
			return arr[tailIndex];
		int temp = arr[tailIndex];
		tailIndex--;
		return temp;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}


