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
			System.out.print("The LinkList elements are: ");
			LinkList temp = new LinkList();
			while (!linkList.isEmpty()) {
				Object o = linkList.removeFirst();
				System.out.print(o + " ");
				temp.insertLast(o);
			}
			System.out.println();
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

	// public static void main(String[] args) {
	// LinkList l = new LinkList();
	// l.insertLast((Integer) 1);
	// l.insertLast((Integer) 2);
	// l.insertLast((Integer) 3);
	// l.insertLast((Integer) 4);
	// l.insertLast((Integer) 5);
	// l.insertLast((Integer) 6);
	// l.insertLast((Integer) 7);
	//
	// LinkListApp linkListApp = new LinkListApp();
	//
	// linkListApp.print(l);
	// linkListApp.print(linkListApp.reverse(l));
	//
	// linkListApp.print(l);
	// LinkListApp.removeLast(l);
	// linkListApp.print(l);
	//
	// linkListApp.print(l);
	// LinkListApp.insertLast(l, 30);
	// linkListApp.print(l);
	//
	// linkListApp.print(l);
	// linkListApp.print(linkListApp.removeDuplicates(l));
	//
	// System.out.println("The LinkList size is: " + l.size());
	// System.out.println("The LinkList size is: " + l.countRec());
	//
	// linkListApp.print(l);
	// linkListApp.print(LinkListApp.mix(l));
	//
	// linkListApp.print(l);
	// linkListApp.print(LinkListApp.cutAList(l)); // The easy way
	// linkListApp.print(LinkListApp.cutList(l));
	//
	// }

}