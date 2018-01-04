package sheikh.stack;

public class ArrayStack {
	int size;
	int[] arrayStack;
	int top;

	public ArrayStack() {
		super();
	}

	public ArrayStack(int maxSize) {
		size = maxSize;
		arrayStack = new int[size];
		top = -1;
	}

	public void push(int x) {
		top++;
		arrayStack[top] = x;
	}

	public int pop() {
		int result = arrayStack[top];
		top--;
		return result;
	}

	public int top() {
		return arrayStack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == size - 1;
	}
}
