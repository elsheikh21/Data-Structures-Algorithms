package sheikh.stacks;

import sheikh.utils.Utilities;

public class ArrayStack {
	private int size;
	private char[] arrayStack;
	private int top;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char[] getArrayStack() {
		return arrayStack;
	}

	public void setArrayStack(char[] arrayStack) {
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
		arrayStack = new char[size];
		top = -1;
	}

	public void push(char x) {
		top++;
		arrayStack[top] = x;
	}

	public char pop() {
		char result = arrayStack[top];
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

	public static void main(String[]args) {
		String word = "(([()[]][])[])";
		Utilities utilities = new Utilities();
		if(utilities.checkParentheses(word))
			System.out.println(String.format("This word '%s' is matching Parentheses", word));
		else 
			System.out.println(String.format("This word '%s' is not a matching Parentheses", word));
	}
}