package sheikh.utils;

import sheikh.stacks.StackObject;

public class QueueUsingStacks {
	private StackObject stack;
	private int maxSize;

	public QueueUsingStacks(int maxSize) {
		this.maxSize = maxSize;
		stack = new StackObject(maxSize);
	}

	public int size() {
		return stack.size();
	}

	public Object peek() {
		return stack.top();
	}

	public void enqueue(Object el) {
		StackObject temp = new StackObject(stack.size());
		while (!stack.isEmpty())
			temp.push(stack.pop());
		temp.push(el);
		while (!temp.isEmpty())
			stack.push(temp.pop());
	}

	public Object dequeue() {
		return stack.pop();
	}

	public boolean isFull() {
		return stack.isFull();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public void displayQueue() {
		stack.printStack();
	}
}
