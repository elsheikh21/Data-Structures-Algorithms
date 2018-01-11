package sheikh.linkedlistsii;

class Link {
	public Object data;
	public Link next;
	public Link previous;

	public Link(Object o) {
		data = o;
	}

	public String toString() {
		return data.toString();
	}
}

class DoublyLinkedList {
	private Link first; // reference to first link on list
	private Link last; // reference to first link on list

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(Object d) {
		Link newLink = new Link(d);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(Object d) {
		Link newLink = new Link(d);
		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Object removeFirst() {
		Object temp = first.data;
		if (first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		return temp;
	}

	public Object removeLast() {
		Object temp = last.data;
		if (first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return temp;
	}

	public void displayForward() {
		System.out.print("[ ");
		Link current = first;
		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println("]");
	}

	public void displayBackward() {
		System.out.print("[ ");
		Link current = last;
		while (current != null) {
			System.out.print(current + " ");
			current = current.previous;
		}
		System.out.println("]");
	}

	public boolean contain(Object object) {
		if (!isEmpty()) {
			Link curr = first;
			do {
				if (curr.data.equals(object))
					return true;
				curr = curr.next;
			} while (curr != null);
		}
		return false;
	}

	public boolean insertAfter(Object key, Object obj) {
		if (!isEmpty() && contain(key)) {
			Link curr = first;
			if (last.data == key) {
				insertLast(obj);
				return true;
			} else {
				do {
					if ((curr.data).equals(key)) {
						Link newLink = new Link(obj);
						newLink.previous = curr;
						newLink.next = curr.next;
						curr.next.previous = newLink;
						curr.next = newLink;
						return true;
					}
					curr = curr.next;
				} while (curr != null);
			}
		}
		return false;

	}

	public boolean insertBefore(Object key, Object obj) {
		if (!isEmpty() && contain(key)) {
			Link curr = first;
			if (first.data.equals(key)) {
				insertFirst(obj);
				return true;
			} else if (last.data.equals(key)) {
				insertLast(obj);
				return true;
			} else {
				do {
					if ((curr.data).equals(key)) {
						Link newLink = new Link(obj);
						newLink.previous = curr.next;
						newLink.next = curr;
						curr.previous.next = newLink;
						curr.previous = newLink;
						return true;
					}
					curr = curr.next;
				} while (curr != null);
			}
		}
		return false;

	}

	public boolean delete(Object obj) {
		if (!isEmpty() && contain(obj)) {
			Link curr = first;
			if (first.data.equals(obj)) {
				removeFirst();
				return true;
			} else if (last.data.equals(obj)) {
				removeLast();
				return true;
			} else {
				do {
					if (curr.data.equals(obj)) {
						curr.next.previous = curr.previous;
						curr.previous.next = curr.next;
						return true;
					}
					curr = curr.next;
				} while (curr != null);
			}
		}
		return false;
	}

	public int size() {
		if (isEmpty())
			return -1;
		int count = 0;
		Link curr = first;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	public int countRec() {
		return countRec(first);
	}

	private int countRec(Link curr) {
		if (curr == null)
			return 0;
		return 1 + countRec(curr.next);
	}

	// TODO: reverse
	// TODO: Recursive reverse
	// TODO: sort using insert sort method
	// TODO: insertIntoSorted a comparable object
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertLast((Integer) 1);
		dll.insertLast((Integer) 2);
		dll.insertLast((Integer) 3);
		dll.insertLast((Integer) 4);
		dll.insertLast((Integer) 5);
		dll.insertLast((Integer) 6);
		dll.insertLast((Integer) 7);
		dll.insertLast((Integer) 8);
		dll.insertLast((Integer) 9);
		dll.insertLast((Integer) 10);
		// System.out.println(dll.contain((Integer) 21));
		// dll.insertAfter((Integer) 5, (Integer) 21);
		// dll.displayForward();
		// dll.insertBefore((Integer) 10, (Integer) 21);
		// dll.displayForward();
		// dll.delete((Integer) 9);
		// dll.displayForward();
		// System.out.println(dll.size());
		// System.out.println(dll.countRec());
	}
}
