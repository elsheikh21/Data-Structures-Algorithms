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
		ArrayStack temp = new ArrayStack(10);
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
		int[] array = new int[10];
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
		int size = arrayStack.getSize();
		ArrayStack temp = new ArrayStack(size);
		int sum1 = 0;
		int sum2 = 0;
		int toPop;
		for (int i = 0; i < size / 2; i++) {
			toPop = arrayStack.pop();
			sum1 += toPop;
			temp.push(toPop);
		}
		if (size % 2 == 1)
			arrayStack.pop();
		for (int i = 0; i < size / 2; i++) {
			toPop = arrayStack.pop();
			sum2 += toPop;
			temp.push(toPop);
		}
		while (!temp.isEmpty())
			arrayStack.push(temp.pop());
		return sum1 == sum2;
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

	public ArrayStack reverse1(ArrayStack arrayStack) {
		int size = arrayStack.getSize();
		ArrayStack rev = new ArrayStack(size);
		for (int i = 0; i < size; i++) {
			rev.push(arrayStack.pop());
		}
		return rev;
	}

	public ArrayStack reverse2(ArrayStack arrayStack) {
		int size = arrayStack.getSize();
		ArrayStack rev = new ArrayStack(size);
		ArrayStack temp = new ArrayStack(size);
		int pop;
		for (int i = 0; i < size; i++) {
			pop = arrayStack.pop();
			rev.push(pop);
			temp.push(pop);
		}
		while (!temp.isEmpty())
			arrayStack.push(temp.pop());
		return rev;
	}

	public ArrayStack reverse3(ArrayStack arrayStack) {
		int size = arrayStack.getSize();
		ArrayStack temp = new ArrayStack(size);
		ArrayStack temp1 = new ArrayStack(size);
		while (!arrayStack.isEmpty())
			temp.push(arrayStack.pop());
		while (!temp.isEmpty())
			temp1.push(temp.pop());
		while (!temp1.isEmpty())
			arrayStack.push(temp1.pop());
		return arrayStack;
	}

	public static ArrayStack removeTheNth(ArrayStack arrayStack, int nthElement) {
		ArrayStack temp = new ArrayStack(arrayStack.getSize());
		ArrayStack temp1 = new ArrayStack(arrayStack.getSize() - 1);
		while (!arrayStack.isEmpty())
			temp.push(arrayStack.pop());
		int i = 1;
		while (!temp.isEmpty()) {
			if (i == nthElement) {
				temp.pop();
				i++;
				continue;
			}
			arrayStack.push(temp.pop());
			i++;
		}
		while (!arrayStack.isEmpty())
			temp1.push(arrayStack.pop());
		Utilities u = new Utilities();
		return u.reverse3(temp1);
	}

	public static ArrayStack removeNth(ArrayStack arrayStack, int nth) {
		int size = arrayStack.getSize();
		ArrayStack temp = new ArrayStack(size - nth);
		ArrayStack temp1 = new ArrayStack(size - nth);
		for (int i = 0; i < size - nth; i++) {
			temp.push(arrayStack.pop());
		}
		while (!temp.isEmpty())
			temp1.push(temp.pop());
		return temp1;
	}

	public ArrayStack stackSort(ArrayStack arrayStack) {
		int[] arr = new int[arrayStack.getSize()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arrayStack.pop();
		}
		arr = sortArray(arr);
		for(int i = 0; i < arr.length; i++) {
			arrayStack.push(arr[i]);
		}
		Utilities u = new Utilities();
		return u.reverse3(arrayStack);
	}

}