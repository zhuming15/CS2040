class ListNode {
	public int item;
	public ListNode next;

	public ListNode(int val) { this(val, null); }

	public ListNode(int val, ListNode next) {
		this.item = val;
		this.next = next;
	}

	public ListNode getNext() { return this.next; }

	public void setNext(ListNode n) { this.next = n; }

	public int getItem() { return this.item; }

	public void setItem(int val) { this.item = val; }

	@Override
	public String toString() {
		return "" + this.item;
	}
}
