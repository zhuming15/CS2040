import java.util.*;

class Arr {
	public int capacity = 6;
	public int[] arr = new int[capacity];
	public int headIndex = capacity/2;
	public int tailIndex = capacity/2;
	public int numOfItems = 0;

	public boolean isEmpty() { return numOfItems == 0; }

	public int size() { return numOfItems; }

	public int get(int index) { return arr[headIndex+index]; }

	public void pushFront(int item) {
		if (headIndex < 1) 
			enlargeArr();
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
		if (tailIndex+1 > capacity-1)
			enlargeArr();
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

	private void updateAllAttributes(int newSize) {
		this.headIndex = capacity;
		this.tailIndex = headIndex + numOfItems - 1;
		this.capacity = newSize;
	}

	public void enlargeArr() {
		int newSize = capacity * 2; // double size
		int[] temp = new int[newSize];
		int oldHeadIndex = headIndex;
		this.updateAllAttributes(newSize);

		// copy the original array to the new array
		for (int j=0; j < numOfItems; j++)
			temp[headIndex+j] = arr[oldHeadIndex+j];
		arr = temp; // point arr to the new array
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}


