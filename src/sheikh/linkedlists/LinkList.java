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

@SuppressWarnings({ "rawtypes", "unchecked" })
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

	private void insertLastRec(Link curr, Object obj) {
		if (curr.next == null)
			curr.next = new Link(obj);
		else
			insertLastRec(curr.next, obj);
	}

	public void insertLastRec(Object obj) {
		if (head == null)
			head = new Link(obj);
		else
			insertLastRec(head, obj);
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

	public Object getMax() {
		if (head == null)
			return head;
		Comparable max = (Comparable) head.data;
		Link current;
		for (current = head; current.next != null; current = current.next) {
			Comparable item = (Comparable) current.next.data;
			if (max.compareTo(item) < 0)
				max = item;
		}
		return max;
	}

	public Object getMaxRec() {
		if (head == null)
			return null;
		Comparable max = (Comparable) head.data;
		if (head.next == null)
			return head;
		else
			return getMaxRec(head.next, max);
	}

	private Object getMaxRec(Link curr, Comparable max) {
		if (curr.next == null)
			return max;
		else if (max.compareTo(curr.data) < 0)
			return getMaxRec(curr.next, (Comparable) curr.data);

		return getMaxRec(curr.next, max);
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		int count = 0;
		Link x = head;
		while (x != null) {
			count++;
			x = x.next;
		}
		return count;
	}

	public int sizeRec() {
		return sizeRec(head);
	}

	private int sizeRec(Link curr) {
		if (curr == null)
			return 0;
		else
			return 1 + sizeRec(curr.next);
	}

	public void cutList() {
		if (head == null)
			return;
		int count = 1;
		Link current;
		for (current = head; current.next != null; current = current.next)
			count++;

		current = head;
		for (int i = 1; i < ((count / 2) + (count % 2)); i++)
			current = current.next;

		Link previous = current;
		while (current.next != null)
			current = current.next;
		current.next = head;
		head = previous.next;
		previous.next = null;
	}

	public boolean containRec(Object obj) {
		return containsRecHelper(head, obj);
	}

	private boolean containsRecHelper(Link curr, Object obj) {
		if (curr == null)
			return false;
		if (curr.data.equals(obj))
			return true;
		else
			return containsRecHelper(curr.next, obj);
	}

	public boolean contain(Object obj) {
		if (head == null)
			return false;
		Link current = head;
		while (current.next != null) {
			if (current.data.equals(obj))
				return true;
			current = current.next;
		}
		return false;
	}

	public boolean contains(Object obj) {
		boolean contains = false;
		LinkList temp = new LinkList();
		while (!this.isEmpty()) {
			Object o = this.removeFirst();
			if (o.equals(obj))
				contains = true;
			temp.insertLast(o);
		}
		while (!temp.isEmpty())
			this.insertLast(temp.removeFirst());
		return contains;
	}

	public LinkList merge(LinkList l) {
		LinkList temp = new LinkList();
		while (!l.isEmpty()) {
			Object obj = l.removeFirst();
			this.insertLast(obj);
			temp.insertLast(obj);
		}
		while (!temp.isEmpty())
			l.insertFirst(temp.removeLast());
		return this;
	}

	public boolean equal(LinkList l) {
		boolean isEqual = true;
		LinkList temp = new LinkList();
		LinkList tempThis = new LinkList();
		if (this.size() != l.size())
			return false;
		while (!l.isEmpty()) {
			Object objL = l.removeFirst();
			Object objT = this.removeFirst();
			if (!objL.equals(objT)) {
				isEqual = false;
			}
			temp.insertLast(objL);
			tempThis.insertLast(objT);
		}
		while (!temp.isEmpty())
			l.insertFirst(temp.removeLast());
		while (!tempThis.isEmpty())
			this.insertFirst(tempThis.removeLast());
		return isEqual;
	}

	public LinkList union(LinkList l) {
		LinkList res = new LinkList();
		Link currT = this.head;
		Link currL = l.head;
		while (true) {
			if (currT != null) {
				res.insertLast(currT.data);
				currT = currT.next;
			}
			if (currL != null) {
				res.insertLast(currL.data);
				currL = currL.next;
			}
			if (currT == null && currL == null)
				break;
		}
		return res;
	}

	public LinkList intersection(LinkList l) {
		System.out.println(this.toString());
		System.out.println(l.toString());

		LinkList result = new LinkList();
		Link currT;
		for (currT = this.head; currT != null; currT = currT.next)
			if (l.contains(currT.data))
				result.insertLast(currT.data);
		System.out.println(result.toString());
		return result;
	}

	public LinkList difference(LinkList l) {
		System.out.println(this.toString());
		System.out.println(l.toString());

		if (this.head == null)
			return l;
		if (l.head == null)
			return this;
		Link currT = this.head;
		while (currT != null) {
			if (!l.contains(currT.data))
				l.insertLast(currT.data);
			currT = currT.next;
		}
		return l;
	}

	public String toString() {
		if (head == null)
			return "[ ]";
		StringBuilder res = new StringBuilder("[" + head.data);
		Link current = head.next;
		while (current != null) {
			res.append(", " + current.data);
			current = current.next;
		}
		res.append("]");
		return res.toString();
	}
}