class Problem2 {
	public int size;
	public ListNode head;
	public ListNode tail;

	public void addFirst(int elem) {
		size++;
		head = new ListNode(elem, head);
		if (tail == null) 
			tail = head;
		tail.setNext(head);
	}

	
}
