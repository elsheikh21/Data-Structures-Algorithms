package sheikh.objects;

class Deque {
	private Object[] elements;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;

	public Deque(int size) {
		maxSize = size;
		elements = new Object[maxSize];
		front = 0;
		rear = maxSize - 1;
		nItems = 0;
	}

	public void insertFirst(Object item) {
		front--;
		if (front == -1)
			front = maxSize - 1;
		elements[front] = item;
		nItems++;
	}

	public void insertLast(Object item) {
		rear++;
		if (rear == maxSize)
			rear = 0;
		elements[rear] = item;
		nItems++;
	}

	public Object removeFirst() {
		Object temp = elements[front];
		front++;
		if (front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	public Object removeLast() {
		Object temp = elements[rear];
		rear--;
		if (rear == -1)
			rear = maxSize - 1;
		nItems--;
		return temp;
	}

	public Object peekFront() {
		return elements[front];
	}

	public Object peekRear() {
		return elements[rear];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int size() {
		return nItems;
	}

	public void displayDeque() {
		System.out.print("The Deque elements are: ");
		for (int i = 0; i < nItems; i++)
			System.out.print(elements[i] + " ");
		System.out.println();
	}
}
