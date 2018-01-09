package sheikh.linkedlists;

class Link {
	public Object data;
	public Link next;

	public Link(Object o) {
		this.data = o;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}
}

public class LinkList {
	private Link head;

	public LinkList() {
		head = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		newLink.next = head;
		head = newLink;
	}

	public Object removeFirst() {
		Object res = head.data;
		head = head.next;
		return res;
	}

	public Object getFirst() {
		return head.data;
	}

	public void insertLast(Object o) {
		Link newLink = new Link(o);
		if (head == null) {
			head = newLink;
			return;
		}
		Link current = head;
		while (current.next != null)
			current = current.next;
		current.next = newLink;
	}

	public void insertLastRec(Object obj) {
		if (head == null)
			head = new Link(obj);
		else
			insertLastRec(head, obj);
	}

	private void insertLastRec(Link head2, Object obj) {
		if (head.next == null)
			head.next = new Link(obj);
		else
			insertLastRec(head.next, obj);
	}

	public Object removeLast() {
		if (head.next == null) {
			Object res = head.data;
			head = null;
			return res;
		}
		Link current = head;
		while (current.next.next != null)
			current = current.next;
		Object res = current.next.data;
		current.next = null;
		return res;
	}

	public void reverse() {
		LinkList revList = new LinkList();
		Link current = head;
		while (current != null) {
			Link l = new Link(current.data);
			l.next = revList.head;
			revList.head = l;
			current = current.next;
		}
		head = revList.head;
	}

	public Object getLast() {
		Link current = head;
		while (current.next != null)
			current = current.next;
		return current.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		int count = 0;
		Link x = head;
		while (x.next != null) {
			x = x.next;
			count++;
		}
		return count;
	}

	public int countRec() {
		return countRecHlp(head);
	}

	public int countRecHlp(Link l) {
		if (l == null)
			return 0;
		else
			return 1 + countRecHlp(l.next);
	}
	
	public void cutList() {
		// TODO: Implement 7-7b
	}

	public String toString() {
		if (head == null)
			return "[ ]";
		String res = "[ " + head.data;
		Link current = head.next;
		while (current != null) {
			res += ", " + current.data;
			current = current.next;
		}
		res += " ]";
		return res;
	}

}
