package sheikh.linkedlistsii;

class Node {
	public Object data;
	public Node next, prev;

}

public class SortedDoublyLinkedList {

	private Node head, tail;

	public SortedDoublyLinkedList() {

	}

	public void insert(Object data) {

		Node current;
		if (head == null) {
			insertFirst(data);
			return;
		}

		if (((Comparable) head.data).compareTo(data) > 0) {
			insertFirst(data);
		} else {
			current = findNodeAfter(data);
			if (current == tail)
				insertLast(data);
			else
				insertMiddle(data, current);
		}

	}

	private Node findNodeAfter(Object data) {

		Node current;
		current = head;
		while (current != null && ((Comparable) current.data).compareTo(data) < 0)
			current = current.next;

		if (current == null)
			return tail;

		return current.prev;
	}

	private void insertFirst(Object data) {
		Node n = new Node();
		n.data = data;
		n.next = head;
		if (head != null) {
			head.prev = n;
		} else {
			tail = n;
		}
		head = n;
	}

	private void insertLast(Object data) {
		Node n = new Node();
		n.data = data;
		n.prev = tail;
		if (tail != null)
			tail.next = n;
		else
			head = n;
		tail = n;
	}

	private void insertMiddle(Object data, Node afterNode) {
		Node n = new Node();
		n.data = data;
		n.prev = afterNode;
		n.next = afterNode.next;
		afterNode.next.prev = n;
		afterNode.next = n;
	}

	public void printAll() {

		Node current;
		current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	public void printBeautified() {
		Node current;
		current = head;
		while (current != null) {
			System.out.print("||");
			System.out.print("|prev=");
			System.out.print(current.prev);
			System.out.print("|data=");
			System.out.print(current.data);
			System.out.print("|next=");
			System.out.print(current.next);
			System.out.print("|| ");
			current = current.next;
		}

		System.out.println("");
		System.out.println(" head = " + head);
		System.out.println(" tail = " + tail);

	}

	public void delete(Object dataTarget) {

		Node current;
		current = findNode(dataTarget);
		if (current == head) {
			deleteFirst();
			return;
		}
		if (current == tail) {
			deleteLast();
			return;
		}
		deleteMiddle(current);
	}

	private void deleteMiddle(Node target) {
		target.prev.next = target.next;
		target.next.prev = target.prev;
	}

	private void deleteFirst() {
		head = head.next;
		head.prev = null;
	}

	private void deleteLast() {
		tail = tail.prev;
		tail.next = null;
	}

	private Node findNode(Object data) {
		Node current;
		current = head;
		while (current != null)
			if (((Comparable) current.data).compareTo(data) == 0)
				return current;
			else
				current = current.next;

		return null;
	}

	public static void main(String[] args) {

		SortedDoublyLinkedList dList;
		dList = new SortedDoublyLinkedList();
		dList.insert(25);
		dList.insert(15);
		dList.insert(2);
		dList.insert(1);
		System.out.print(" after inserting 25,15,2,1------------");
		dList.printAll();
		System.out.println("");

		dList.delete(15);
		System.out.print(" after delete 15----------------------");
		dList.printAll();
		System.out.println("");

		dList.delete(1);
		System.out.print(" after delete 1-----------------------");
		dList.printAll();
		System.out.println("");

		dList.delete(25);
		System.out.print(" after delete 25----------------------");
		dList.printAll();
		System.out.println("");

		dList.insert(30);
		System.out.print(" after insert 30----------------------");
		dList.printAll();
		System.out.println("");

		dList.insert(1);
		System.out.print(" after insert 1----------------------");
		dList.printAll();
		System.out.println("");

		System.out.println(" printing linked list with references");
		dList.printBeautified();
	}

}
