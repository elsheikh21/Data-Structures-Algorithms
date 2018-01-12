package sheikh.linkedlistsii;

public class QueueUsingDoubly {
	private DoublyLinkedList dll;
	
	public QueueUsingDoubly() {
		dll = new DoublyLinkedList();
	}
	
	public void enqueue(Object d) {
		dll.insertLast(d);
	}
	
	public Object dequeue() {
		return dll.removeFirst();
	}
	
	public boolean isEmpty() {
		return dll.isEmpty();
	}
	
	public int size() {
		return dll.size();
	}
	
	public Object peek() {
		Object obj = dll.removeFirst();
		dll.insertFirst(obj);
		return obj;
	}

}
