import java.util.*;

class ListUsingArray {
	public int capacity = 1000;
	public int num_items;
	public int[] arr = new int[capacity];

	public boolean isEmpty() { return num_items==0; }
	
	public int size()		 { return num_items; }

	public int indexOf(int item) {
		int index = 0;

		for (int i = 0; i < num_items; i++) {
			if (arr[i] == item)
				return index;
			else
				index++;
		}
		return -1;
	}

	public boolean contains(int item) {
		if (indexOf(item) != -1) 
			return true;
		return false;
	}

	public int getItemAtIndex(int index) {
//		if (index < 0 || index > size()-1) {
//			System.out.println("from ListUsingArray getItemAtIndex");
//			System.out.println("invalid index");
//			System.exit(1);
//		}
		return arr[index];
	}

	public int getFront() { return getItemAtIndex(0); }

	public int getBack() { return getItemAtIndex(size()-1); }

	public void addAtIndex(int index, int item) {
		if (index >= 0 && index <= size())
			insert(index, item);
		else {
			System.out.println("from ListUsingArray addAtIndex");
			System.out.println("invalid index");
			System.exit(1);
		}
	}

	public void addFront (int item) { addAtIndex(0, item); }

	public void addBack(int item) { addAtIndex(size(), item); }

	public void print() {
		if (num_items == 0)
			System.out.println("Nothing to print");
		else {
			System.out.print("List is : " + arr[0]);
			for (int i=1; i<num_items; i++)
				System.out.print(", " + arr[i]);
			System.out.println(".");
		}
	}

	public void insert(int index, int item) {
		if (num_items+1 > capacity)
			enlargeArr();
		for (int i=num_items-1; i >= index; i--) 
			arr[i+1] = arr[i];
		arr[index] = item;
		num_items++;
	}

	public void enlargeArr() {
		int newSize = capacity * 2;
		int[] temp = new int[newSize];

		if (temp == null) {
			System.out.println("run out of memory!");
			System.exit(1);
		}

		for (int j=0; j < num_items; j++)
			temp[j] = arr[j];
		arr = temp;
		capacity = newSize;
	}
}
