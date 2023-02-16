class CircularLinkedList {
	public int size;
	public ListNode head;
	public ListNode tail;

	CircularLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void addNode(int elem) {
		size++;
		ListNode newNode = new ListNode(elem, head);
		this.tail.setNext(newNode);
		this.tail = newNode;
	}

	public void addFirst(int elem) {
		size++;
		head = new ListNode(elem, head);
		if (tail == null) 
			tail = head;
		tail.setNext(head);
	}

	public void removeBack() {
		size--;
		ListNode temp = this.head;
		while (!temp.getNext().equals(this.tail)) {
			temp = temp.getNext();
		}
		temp.setNext(head);
		tail = temp;
	}

//	public void swap(int index) {
	
	@Override
	public String toString() {
		String res = "[";
		int counter = 0;
		ListNode temp = this.head;
		while (counter != this.size) {
			res += "" + temp.getItem() + ", ";
			temp = temp.getNext();
			counter++;
		}
		res += "]";
		return res;
	}

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.addFirst(0);
		cll.addNode(1);
		cll.addNode(2);
		System.out.println("size: " + cll.size);
		System.out.println(cll.toString());

		cll.removeBack();
		System.out.println("size: " + cll.size);
		System.out.println(cll.toString());
	}

}
