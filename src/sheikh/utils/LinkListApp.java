package sheikh.utils;

import sheikh.linkedlists.LinkList;

public class LinkListApp {

	public static void insertLast(LinkList linkedList, Object obj) {
		LinkList tempLinkList = new LinkList();
		while (!linkedList.isEmpty())
			tempLinkList.insertFirst(linkedList.removeFirst());
		tempLinkList.insertFirst(obj);
		while (!tempLinkList.isEmpty())
			linkedList.insertFirst(tempLinkList.removeFirst());
	}

	public static Object removeLast(LinkList linkedList) {
		LinkList tempLinkList = new LinkList();
		while (!linkedList.isEmpty())
			tempLinkList.insertFirst(linkedList.removeFirst());
		Object res = tempLinkList.removeFirst();
		while (!tempLinkList.isEmpty())
			linkedList.insertFirst(tempLinkList.removeFirst());
		return res;
	}

	public static LinkList mix(LinkList l) {
		LinkList temp = new LinkList();
		int count = 0;
		while (!l.isEmpty()) {
			if (count % 2 == 0)
				temp.insertFirst(l.removeFirst());
			else
				temp.insertFirst(l.removeLast());
			count++;
		}
		while (!temp.isEmpty())
			l.insertFirst(temp.removeFirst());
		return l;
	}

	public static LinkList cutList(LinkList linkList) {
		int size = linkList.size();
		for (int i = 0; i < size / 2; i++) {
			linkList.insertFirst(linkList.removeLast());
		}
		return linkList;
	}

	public static LinkList cutAList(LinkList linkList) {
		LinkList temp = new LinkList();
		while (!linkList.isEmpty()) {
			temp.insertLast(linkList.removeFirst());
			if (linkList.isEmpty())
				break;
			temp.insertFirst(linkList.removeLast());
		}
		while (!temp.isEmpty())
			linkList.insertFirst(temp.removeLast());

		return linkList;
	}

	public static void frontBackSplit(LinkList linkedList) {
		int count = linkedList.size();
		LinkList temp = new LinkList();
		LinkList front = new LinkList();
		LinkList back = new LinkList();
		int i = 0;
		while (i < ((count / 2) + (count % 2))) {
			Object obj = linkedList.removeLast();
			back.insertFirst(obj);
			temp.insertLast(obj);
			i++;
		}
		while (i <= count) {
			Object obj = linkedList.removeLast();
			front.insertFirst(obj);
			temp.insertLast(obj);
			i++;
		}
		while (!temp.isEmpty())
			linkedList.insertFirst(temp.removeFirst());
		System.out.println("The front linked list is: " + front.toString());
		System.out.println("The back linked list is: " + back.toString());
	}

	public static void alternateSplit(LinkList linkList) {
		int count = 0;
		LinkList temp = new LinkList();
		LinkList linkListA = new LinkList();
		LinkList linkListB = new LinkList();
		while (!linkList.isEmpty()) {
			Object obj = linkList.removeFirst();
			if (count % 2 == 0)
				linkListA.insertLast(obj);
			else
				linkListB.insertLast(obj);
			temp.insertLast(obj);
			count++;
		}
		while (!temp.isEmpty())
			linkList.insertFirst(temp.removeLast());
		System.out.println("First sublist is: " + linkListA.toString());
		System.out.println("Second sublist is: " + linkListB.toString());
	}

	public LinkList reverse(LinkList linkedList) {
		LinkList tempLinkedList = new LinkList();
		while (!linkedList.isEmpty())
			tempLinkedList.insertFirst(linkedList.removeLast());
		while (!tempLinkedList.isEmpty())
			linkedList.insertFirst(tempLinkedList.removeFirst());
		return linkedList;
	}

	public void print(LinkList linkList) {
		if (!linkList.isEmpty()) {
			StringBuilder stringBuilder = new StringBuilder("The LinkList elements are: [");
			LinkList temp = new LinkList();
			while (!linkList.isEmpty()) {
				Object o = linkList.removeFirst();
				stringBuilder.append(", " + o);
				temp.insertLast(o);
			}
			stringBuilder.append("]");
			System.out.println(stringBuilder.toString() + "\n");
			while (!temp.isEmpty())
				linkList.insertLast(temp.removeFirst());
		} else {
			System.out.println("The LinkList is empty.");
		}
	}

	public LinkList removeDuplicates(LinkList linkedList) {
		LinkList temp = new LinkList();
		while (!linkedList.isEmpty()) {
			Object objA = linkedList.removeFirst();
			if (linkedList.isEmpty()) {
				temp.insertLast(objA);
				break;
			}
			Object objB = linkedList.getFirst();
			if (objA.equals(objB)) {
				linkedList.removeFirst();
				linkedList.insertFirst(objA);
				continue;
			}
			temp.insertLast(objA);
		}
		while (!temp.isEmpty())
			linkedList.insertFirst(temp.removeLast());
		return linkedList;
	}

	// for generic types.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object theMax(LinkList linkList) {
		LinkList temp = new LinkList();
		if (linkList.isEmpty())
			return null;
		Object obj = linkList.removeFirst();
		Comparable max = (Comparable) obj;
		while (!linkList.isEmpty()) {
			Object o = linkList.removeFirst();
			Comparable item = (Comparable) o;
			if (max.compareTo(item) < 0) {
				max = item;
			}
			temp.insertFirst(o);
		}
		temp.insertFirst(obj);
		while (!temp.isEmpty())
			linkList.insertFirst(temp.removeLast());
		return max;
	}

	// in case of integers.
	public int getMax(LinkList linkList) {
		int max = 0;
		LinkList temp = new LinkList();
		while (!linkList.isEmpty()) {
			Integer obj1 = Integer.valueOf((Integer) linkList.removeFirst());
			if (linkList.isEmpty())
				break;
			Integer obj2 = Integer.valueOf((Integer) linkList.removeFirst());
			if (obj1.compareTo(obj2) > 0)
				max = obj1;
			else if (obj1.compareTo(obj2) < 0)
				max = obj2;
			temp.insertFirst(obj1);
			temp.insertFirst(obj2);
		}
		while (!temp.isEmpty())
			linkList.insertFirst(temp.removeFirst());
		return max;
	}

	public LinkList union(LinkList linkListA, LinkList linkListB) {
		LinkList union = new LinkList();
		while (!linkListA.isEmpty())
			union.insertLast(linkListA.removeFirst());
		while (!linkListB.isEmpty())
			union.insertLast(linkListB.removeFirst());
		return union;
	}

	public boolean equals(LinkList linkListA, LinkList linkListB) {
		if (linkListA.size() != linkListB.size())
			return false;
		while (!linkListA.isEmpty()) {
			Object objA = linkListA.removeFirst();
			Object objB = linkListB.removeFirst();
			if (!objA.equals(objB))
				return false;
		}
		return true;
	}

	public LinkList merge(LinkList linkListA, LinkList linkListB) {
		LinkList merged = new LinkList();
		while (true) {
			if (!linkListA.isEmpty())
				merged.insertFirst(linkListA.removeLast());
			if (!linkListB.isEmpty())
				merged.insertFirst(linkListB.removeLast());
			if (linkListA.isEmpty() && linkListB.isEmpty())
				break;
		}
		return merged;
	}

	public LinkList difference(LinkList linkListA, LinkList linkListB) {
		LinkList difference = new LinkList();
		LinkList tempA = new LinkList();
		LinkList tempB = new LinkList();
		while (!linkListA.isEmpty()) {
			Object objA = linkListA.removeFirst();
			Object objB = null;
			boolean none = true;
			while (!linkListB.isEmpty()) {
				objB = linkListB.removeFirst();
				tempB.insertLast(objB);
				if (objA.equals(objB)) {
					none = false;
					break;
				}
			}
			if (none)
				difference.insertLast(objA);
			while (!tempB.isEmpty())
				linkListB.insertLast(tempB.removeFirst());
			tempA.insertLast(objA);
		}
		while (!tempA.isEmpty())
			linkListA.insertLast(tempA.removeFirst());
		return difference;
	}

	public LinkList intersection(LinkList linkListA, LinkList linkListB) {
		LinkList intersection = new LinkList();
		LinkList tempA = new LinkList();
		LinkList tempB = new LinkList();
		while (!linkListA.isEmpty()) {
			Object objA = linkListA.removeFirst();
			while (!linkListB.isEmpty()) {
				Object objB = linkListB.removeFirst();
				if (objA.equals(objB))
					intersection.insertLast(objB);
				tempB.insertLast(objB);
			}
			while (!tempB.isEmpty())
				linkListB.insertLast(tempB.removeFirst());
			tempA.insertLast(objA);
		}
		while (!tempA.isEmpty())
			linkListA.insertLast(tempA.removeFirst());
		return intersection;
	}

	public static void main(String[] args) {

	}

	/*
	 * public static void main(String[] args) { LinkList lA = new LinkList();
	 * lA.insertLast((Character) 'a'); lA.insertLast((Character) 'b');
	 * lA.insertLast((Character) 'c'); lA.insertLast((Character) 'd');
	 * lA.insertLast((Character) 'e'); lA.insertLast((Character) 'f');
	 * 
	 * LinkList l = new LinkList(); l.insertLast((Integer) 2);
	 * l.insertLast((Integer) 4); l.insertLast((Integer) 6); l.insertLast((Integer)
	 * 8);
	 * 
	 * LinkList temporary = new LinkList(); temporary.insertLast((Integer) 1);
	 * temporary.insertLast((Integer) 3); temporary.insertLast((Integer) 5);
	 * temporary.insertLast((Integer) 7);
	 * 
	 * // LinkListApp linkListApp = new LinkListApp(); // // linkListApp.print(l);
	 * // linkListApp.print(linkListApp.reverse(l)); // // linkListApp.print(l); //
	 * LinkListApp.removeLast(l); // linkListApp.print(l); // //
	 * linkListApp.print(l); // LinkListApp.insertLast(l, 30); //
	 * linkListApp.print(l); // // linkListApp.print(l); //
	 * linkListApp.print(linkListApp.removeDuplicates(l)); // //
	 * System.out.println("The LinkList size is: " + l.size()); //
	 * System.out.println("The LinkList size is: " + l.countRec()); // //
	 * linkListApp.print(l); // linkListApp.print(LinkListApp.mix(l)); // //
	 * linkListApp.print(l); // linkListApp.print(LinkListApp.cutAList(l)); // The
	 * easy way // linkListApp.print(LinkListApp.cutList(l)); // //
	 * linkListApp.print(l); // l.cutList(); // linkListApp.print(l); // //
	 * LinkListApp.frontBackSplit(l); // // LinkListApp.alternateSplit(l); // //
	 * System.out.println(linkListApp.theMax(l)); //
	 * System.out.println(linkListApp.getMax(l)); // // System.out.println( //
	 * (l.contains((Integer) 2) ? "List contains this element" : "List doesn't //
	 * contain this element")); // // linkListApp.print(linkListApp.union(l, lA));
	 * // // System.out.println(linkListApp.equals(l, temporary)); // //
	 * linkListApp.print(linkListApp.merge(l, temporary)); // //
	 * linkListApp.print(linkListApp.difference(l, temporary)); // //
	 * linkListApp.print(linkListApp.intersection(l, temporary)); // //
	 * temporary.merge(l); // temporary.equal(l); // temporary.contain(5);
	 * 
	 * // temporary.intersection(l); // temporary.difference(l); //
	 * temporary.union(l); LinkList l = new LinkList(); l.insertLast((Integer) 1);
	 * l.insertLast((Integer) 21); l.insertLast((Integer) 132);
	 * l.insertLast((Integer) 5); l.insertLast((Integer) 4); l.insertLast((Integer)
	 * 2); l.insertLast((Integer) 41); l.insertLast((Integer) 12);
	 * System.out.println(l.containRec((Integer)
	 * 132));System.out.println(l.getMaxRec());System.out.println(l.insertLastRec((
	 * Integer) 30))); System.out.println(l.sizeRec());}
	 * 
	 */
}