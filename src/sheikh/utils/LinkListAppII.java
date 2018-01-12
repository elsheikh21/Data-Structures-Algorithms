package sheikh.utils;

import sheikh.linkedlistsii.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LinkListAppII {

	public static int count(DoublyLinkedList l) {
		int count = 0;
		DoublyLinkedList dll = new DoublyLinkedList();
		while (!l.isEmpty()) {
			dll.insertFirst(l.removeFirst());
			count++;
		}
		while (!dll.isEmpty())
			l.insertFirst(dll.removeFirst());

		return count;
	}
	
	// Could not solve on my own.
	public DoublyLinkedList insertionSort(DoublyLinkedList list) {
		DoublyLinkedList sorted = new DoublyLinkedList();
		while (!list.isEmpty()) {
			if (sorted.isEmpty()) {
				sorted.insertFirst(list.removeFirst());
			} else {
				Object tempValue = list.removeFirst();
				DoublyLinkedList tempList = new DoublyLinkedList();
				boolean added = false;
				while (!added) {
					if (sorted.isEmpty()) {
						sorted.insertFirst(tempValue);
						added = true;
						break;
					}
					Comparable removed = (Comparable) sorted.removeFirst();
					if (removed.compareTo(tempValue) < 0) {
						tempList.insertLast(removed);
					} else {
						sorted.insertFirst(removed);
						sorted.insertFirst(tempValue);
						added = true;
					}
				}
				while (!tempList.isEmpty()) {
					sorted.insertFirst(tempList.removeLast());
				}
			}
		}
		return sorted;
	}

}
