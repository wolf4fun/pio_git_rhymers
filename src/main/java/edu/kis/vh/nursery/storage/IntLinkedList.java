package edu.kis.vh.nursery.storage;

public class IntLinkedList implements IntStorage {

	private class Node {

		public final int value;
		private Node prev;
		private Node next;
	
		public Node(final int i) {
			value = i;
		}
	}

	private Node last;
	private int size;

	public void push(final int i) {
		if (last == null)
			last = new Node(i);
		else {
			last.next = new Node(i);
			last.next.prev = last;
			last = last.next;
		}
		++size;
	}

	public boolean isEmpty() {
		return last == null;
	}

	public boolean isFull() {
		return false;
	}

	public int top() {
		if (isEmpty())
			return IS_EMPTY;
		return last.value;
	}

	public int pop() {
		if (isEmpty())
			return IS_EMPTY;
		final int ret = last.value;
		last = last.prev;
		--size;
		return ret;
	}

	@Override
	public int getTotal() {
		return size;
	}

}
