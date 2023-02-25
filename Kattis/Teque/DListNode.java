class DListNode {
	public int element;
	public DListNode next;
	public DListNode prev;

	public DListNode(int item) {
		this(item, null, null);
	}

	public DListNode(int item, DListNode p, DListNode n) {
		this.element = item;
		this.prev = p;
		this.next = n;
	}

	// Getter
	public DListNode getPrev() {
		return this.prev;
	}

	public DListNode getNext() {
		return this.next;
	}

	public int getItem() {
		return this.element;
	}

	// Setter
	public void setPrev(DListNode p) {
		this.prev = p;
	}

	public void setNext(DListNode n) {
		this.next = n;
	}
}
