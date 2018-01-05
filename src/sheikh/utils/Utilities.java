package sheikh.utils;

import sheikh.stacks.ArrayStack;

public class Utilities {

	public boolean checkParentheses(String word) {
		int size = word.length();
		if (size % 2 != 0)
			return false;
		ArrayStack arrayStack = new ArrayStack(size);
		for (int i = 0; i < size; i++) {
			char ch = word.charAt(i);
			switch (ch) {
			case '(':
			case '[':
				arrayStack.push(ch);
				break;
			case ')':
			case ']':
				if (arrayStack.isEmpty())
					return false;
				char ch0 = (char) arrayStack.pop();
				if (ch == ')' && ch0 != '(')
					return false;
				if (ch == ']' && ch0 != '[')
					return false;
				break;
			default:
				break;
			}
		}
		return arrayStack.isEmpty();
	}

	public int searchInStack(ArrayStack arrayStack, int number) {
		ArrayStack temp = new ArrayStack(arrayStack.getSize());
		int index = 0;
		int atIndex = -1;
		while (!arrayStack.isEmpty()) {
			int check = (int) arrayStack.pop();
			if (check != number) {
				index++;
				temp.push(check);
			} else {
				atIndex = index++;
				temp.push(check);
			}
		}
		while (!temp.isEmpty()) {
			arrayStack.push((int) temp.pop());
		}
		return atIndex;
	}

	public static ArrayStack decompose(ArrayStack arrayStack) {
		ArrayStack evenStack = new ArrayStack(10);
		ArrayStack oddStack = new ArrayStack(10);
		while (!arrayStack.isEmpty()) {
			int check = arrayStack.pop();
			if (check % 2 == 0)
				evenStack.push(check);
			else
				oddStack.push(check);
		}

		oddStack.printStack();
		evenStack.printStack();

		return evenStack;
	}

	public ArrayStack sort(ArrayStack arrayStack) {
		int[] array = new int[arrayStack.getSize()];
		int j = 0;
		while (!arrayStack.isEmpty()) {
			array[j] = arrayStack.pop();
			j++;
		}
		array = sortArray(array);
		for (int i = 0; i < array.length; i++) {
			arrayStack.push(array[i]);
		}
		return arrayStack;
	}

	public static boolean cubeGameCheck(ArrayStack arrayStack) {
		
		return false;
	}
	
	// The selection sort algorithm was borrowed from my University lectures 
	private int[] sortArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			int min = array[minIndex];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					minIndex = j;
					min = array[minIndex];
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}
}