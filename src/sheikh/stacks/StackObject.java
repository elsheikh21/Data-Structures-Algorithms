package sheikh.stacks;

public class StackObject {
	private Object[] theStack;
	private int maxSize;
	private int top;

	public StackObject(int s) {
		maxSize = s;
		theStack = new Object[maxSize];
		top = -1;
	}

	public void push(Object obj) {
		top++;
		theStack[top] = obj;
	}

	public Object top() {
		return theStack[top];
	}

	public Object pop() {
		Object obj = theStack[top];
		top--;
		return obj;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public int size() {
		return top + 1;
	}

	public void printStack() {
		if (top == -1) {
			System.out.println("The stack is empty");
		} else {
			System.out.print("The stack elements are: ");
			for (int i = 0; i < theStack.length; i++)
				System.out.print(theStack[i] + " ");
			System.out.println();
		}
	}
	
	public Object[] reverse(Object[] toRev) {
		Object[] rev = new Object[toRev.length];
		for(int i = 0; i < rev.length; i++)
			rev[rev.length - (i + 1)] = toRev[i];
		return rev;
	}
}
