class MyListNode {
	public MyListNode next;
	public MyListNode tail;
	public String word;

	MyListNode(String word) {
		this.next = null;
		this.tail = null;
		this.word = word;
	}

	void addBack(MyListNode node) {
		if (this.tail == null) { 
			this.tail = node;
			this.next = node;
			return;
		}
		this.tail.next = node;
		this.tail = node.getTail();
	}

	MyListNode getTail() {
		return this.tail == null ? this : this.tail;
	}

	@Override
	public String toString() {
		return this.word;
	}
}
