package sheikh.queues;

public class PriorityQueue {

	private Comparable<Object>[] elements;
	private int nItems;
	private int maxSize;

	@SuppressWarnings("unchecked")
	public PriorityQueue(int size) {
		maxSize = size;
		elements = new Comparable[maxSize];
		nItems = 0;
	}

	// we keep the most important item at index nItem-1
	// and the least important item at index 0
	public void insert(Comparable<Object> item) {
		int i;
		for (i = nItems - 1; i >= 0 && item.compareTo(elements[i]) >= 0; i--)
			elements[i + 1] = elements[i];

		elements[i + 1] = item;
		nItems++;
	}

	public Comparable<Object> remove() {
		nItems--;
		return elements[nItems];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public Comparable<Object> peekMin() {
		return elements[nItems - 1];
	}

	public int size() {
		return nItems;
	}

	public void printPriorityQueue() {
		if (nItems == 0) {
			System.out.println("The priority queue is empty!");
		} else {
			System.out.println("Items in the priority queue (from highest to lowest priority) = ");
			for (int i = nItems - 1; i >= 0; i--) {
				System.out.print(elements[i] + " ");
			}
			System.out.println();
		}
	}
}