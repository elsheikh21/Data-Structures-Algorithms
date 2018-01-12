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

@SuppressWarnings({ "unchecked", "rawtypes" })
public class DoublyLinkedList {
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

	public void insertToSorted(Comparable x) {
		Link current = first;
		Link temp = new Link(x);
		if (first == null) {
			first = temp;
			last = temp;
			return;
		}
		while (current != null) {
			if (x.compareTo(current.data) < 0) {
				temp.next = current;
				temp.previous = current.previous;
				if (current.previous != null) {
					current.previous.next = temp;
				} else {
					first = temp;
				}
				current.previous = temp;
				break;
			}
			if (current.next == null) {
				current.next = temp;
				temp.previous = current;
				last = temp;
				break;
			}
			current = current.next;
		}
	}

	public void insertionSort() {
		DoublyLinkedList dll = new DoublyLinkedList();
		Link curr = first;
		while (curr != null) {
			dll.insertToSorted((Comparable) curr.data);
			curr = curr.next;
		}
		// There was an error with my approach, did not refer to dll after finishing.
		first = dll.first;
		last = dll.last;
	}

	// Without using pointers
	public void reverse() {
		DoublyLinkedList dll = new DoublyLinkedList();
		while (!this.isEmpty())
			dll.insertLast(this.removeLast());
		first = dll.first;
		last = dll.last;
	}

	// With using of pointers
	public void rev() {
		Link current = first;
		while (current != null) {
			if (current.previous == null)
				last = current;
			if (current.next == null)
				first = current;
			Link temp = current.previous;
			current.previous = current.next;
			current.next = temp;
			temp = temp.previous;
		}
	}

	public void reverseRecHelper(Link curr) {
		if (curr != null) {
			if (curr.previous != null)
				last = curr;
			if (curr.next != null)
				first = curr;
			Link temp = curr.previous;
			curr.previous = curr.next;
			curr.next = temp;
			reverseRecHelper(curr.previous);
		}
	}

	public void reverseRec() {
		reverseRecHelper(first);
	}

	/*
	 * public static void main(String[] args) { DoublyLinkedList dll = new
	 * DoublyLinkedList(); dll.insertLast((Integer) 112); dll.insertLast((Integer)
	 * 23); dll.insertLast((Integer) 3); dll.insertLast((Integer) 452);
	 * dll.insertLast((Integer) 5); dll.insertLast((Integer) 653);
	 * dll.insertLast((Integer) 7234); dll.insertLast((Integer) 8);
	 * dll.insertLast((Integer) 951); dll.insertLast((Integer) 10);
	 * 
	 * // System.out.println(dll.contain((Integer) 21));
	 * 
	 * // dll.insertAfter((Integer) 5, (Integer) 21); // dll.displayForward();
	 * 
	 * // dll.insertBefore((Integer) 10, (Integer) 21); // dll.displayForward();
	 * 
	 * // dll.delete((Integer) 9); // dll.displayForward();
	 * 
	 * // System.out.println(dll.size()); // System.out.println(dll.countRec());
	 * 
	 * // dll.displayForward(); // dll.insertToSorted((Integer) 11); //
	 * dll.displayForward(); // dll.insertToSorted((Integer) 0); //
	 * dll.displayForward(); // dll.insertToSorted((Integer) 953); // Could not
	 * solve it on my own. // dll.displayForward();
	 * 
	 * // dll.displayForward(); // dll.insertionSort(); // dll.displayForward();
	 * 
	 * // dll.displayForward(); // dll.reverse(); // dll.displayForward();
	 * 
	 * // dll.displayForward(); // dll.reverseRec(); // dll.displayForward(); }
	 */
}
