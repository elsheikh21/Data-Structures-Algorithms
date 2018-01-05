package sheikh.stacks;

import sheikh.utils.Utilities;

public class ArrayStack {
	private int size;
	private int[] arrayStack;
	private int top;

	public int getSize() {
		return top + 1;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getArrayStack() {
		return arrayStack;
	}

	public void setArrayStack(int[] arrayStack) {
		this.arrayStack = arrayStack;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public ArrayStack() {
		super();
	}

	public ArrayStack(int maxSize) {
		size = maxSize;
		arrayStack = new int[size];
		top = -1;
	}

	public void push(int i) {
		top++;
		arrayStack[top] = i;
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

	public void printStack() {
		if (top == -1) {
			System.out.println("The array is empty");
		}
		System.out.print("Stack elements are: ");
		for (int i = 0; i < arrayStack.length; i++)
			System.out.print(arrayStack[i] + " ");
		System.out.println();
	}

	public int searchInStack(int number) {
		int index = 0;
		int atIndex = -1;
		for (int i = 0; i < arrayStack.length; i++) {
			if (arrayStack[i] != number) {
				index++;
			} else {
				atIndex = index++;
			}
		}
		return atIndex;
	}

	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(10);
		arrayStack.push(6);
		arrayStack.push(9);
		arrayStack.push(3);
		arrayStack.push(5);
		arrayStack.push(4);
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(7);
		arrayStack.push(72);
		arrayStack.push(17);

		Utilities utilities = new Utilities();
		
//		String word = "(([()[]][])[])";
//		String print = utilities.checkParentheses(word)
//				? String.format("This word '%s' is matching Parentheses", word)
//				: String.format("This word '%s' is not a matching Parentheses", word);
//		System.out.println(print);
//
//		int atIndex = utilities.searchInStack(arrayStack, 3);
//		print = (atIndex == -1) ? "The number you are searching for is not found"
//				: String.format("The number is found at index of (%1$d)", atIndex);
//		System.out.println(print);
//
//		atIndex = arrayStack.searchInStack(6);
//		print = (atIndex == -1) ? "The number you are searching for is not found"
//				: String.format("The number is found at index of (%1$d)", atIndex);
//		System.out.println(print);
//		
//		Utilities.decompose(arrayStack);
//		
//		utilities.sort(arrayStack).printStack();
	}
}