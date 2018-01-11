package sheikh.linkedlists;

class CircularLinkList {
	private Link last;

	public CircularLinkList() {
		last = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		if (last == null)
			last = new Link(o);
		else
			newLink.next = last.next;
		last.next = newLink;
	}

	public Object removeFirst() {
		Object temp = null;
		if (last.next == last) {
			temp = last.data;
			last = null;
		} else {
			temp = last.next.data;
			last.next = last.next.next;
		}
		return temp;
	}

	public void insertLast(Object o) {
		Link newLink = new Link(o);
		if (last == null) {
			last = newLink;
			last.next = newLink;
		} else {
			newLink.next = last.next;
			last.next = newLink;
			last = newLink;
		}
	}

	public Object removeLast() {
		Object temp = last.data;
		if (last.next == last)
			last = null;
		else {
			Link current = last;
			while (current.next != last)
				current = current.next;
			current.next = current.next.next;
			last = current;
		}
		return temp;
	}

	public boolean isEmpty() {
		return last == null;
	}

	public void appendElement(Object o) {
		this.insertLast(o);
	}

	public void append(CircularLinkList circularLinkList) {
		if (isEmpty()) {
			last = circularLinkList.last;
		} else {
			Link first = last.next;
			last.next = circularLinkList.last.next;
			circularLinkList.last.next = first;
			last = circularLinkList.last;
		}
	}

	public String toString() {
		if (last == null)
			return "[ ]";
		StringBuilder res = new StringBuilder("[" + last.data);
		Link current = last.next;
		while (current != null) {
			res.append(", " + current.data);
			current = current.next;
		}
		res.append("]");
		return res.toString();
	}
}
