package sheikh.utils;

//import sheikh.objects.Palindrome;
import sheikh.objects.Student;
import sheikh.stacks.ArrayStack;
//import sheikh.stacks.PostFixEv;
import sheikh.stacks.StackObject;

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
		if (size % 2 != 0)
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
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arrayStack.pop();
		}
		arr = sortArray(arr);
		for (int i = 0; i < arr.length; i++) {
			arrayStack.push(arr[i]);
		}
		Utilities u = new Utilities();
		return u.reverse3(arrayStack);
	}

	////////////////// STACK OF OBJECTS //////////////////

	public StackObject reverseStackObject(StackObject stackObject) {
		int size = stackObject.size();
		StackObject temp = new StackObject(size);
		StackObject temp1 = new StackObject(size);
		while (!stackObject.isEmpty())
			temp.push(stackObject.pop());
		while (!temp.isEmpty())
			temp1.push(temp.pop());
		while (!temp1.isEmpty())
			stackObject.push(temp1.pop());
		return stackObject;
	}

	public static String reverseString(String str) {
		StackObject stk = new StackObject(str.length() + 1);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			stk.push(ch);
		}
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char charFromStack = ((Character) stk.pop()).charValue();
			ret.append(charFromStack);
		}
		return ret.toString();
	}

	public String averageGPA(StackObject stack) {
		int size = stack.size();
		StackObject temp = new StackObject(size);
		double sum = 0.0;
		while (!stack.isEmpty()) {
			Student student = (Student) stack.pop();
			sum += student.getGPA();
			temp.push(student);
		}
		while (!temp.isEmpty())
			stack.push(temp.pop());

		return String.format("The average GPA for the selected students is: (%1$.3f)",
				Math.round((sum / size) * 1000.0) / 1000.0);
	}

	private static int getPriority(char operator) {
		if (operator == '*')
			return 1;
		else if (operator == '+')
			return 2;
		else
			return 3;
	}

	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		ArrayStack stack = new ArrayStack(infix.length());
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (c >= '0' && c <= '9') {
				postfix.append(c);
			} else {
				if (stack.isEmpty())
					stack.push(c);
				else {
					int currentP = getPriority(c);
					int stackP = getPriority((char) stack.top());
					while (stackP <= currentP) {
						postfix.append((char) stack.pop());
						if (stack.isEmpty())
							break; // break to exit the loop
						stackP = getPriority((char) stack.top());
					}
					stack.push(c);
				}
			}
		}
		while (!stack.isEmpty())
			postfix.append((char) stack.pop());
		return String.format("The expression in infix notation is (%1s) in reverse polish notation is (%2s)", infix,
				postfix);
	}

	public StackObject duplicate(StackObject strings, StackObject integers) {
		int size = numbersOfDuplications(integers);
		StackObject result = new StackObject(size);
		StackObject intTemp = new StackObject(integers.size());
		StackObject stringsTemp = new StackObject(strings.size());
		while (!strings.isEmpty()) {
			String popped = (String) strings.pop();
			int poppedInt = (Integer) integers.pop();
			for (int i = 0; i < poppedInt; i++) {
				result.push(popped);
			}
			intTemp.push(poppedInt);
			stringsTemp.push(popped);
		}
		while (!stringsTemp.isEmpty()) {
			integers.push((Integer) intTemp.pop());
			strings.push((String) stringsTemp.pop());
		}
		return result;
	}

	private int numbersOfDuplications(StackObject integers) {
		StackObject temp = new StackObject(integers.size());
		int sum = 0;
		while (!integers.isEmpty()) {
			int tempVal = (Integer) integers.pop();
			sum += tempVal;
			temp.push(tempVal);
		}
		while (!temp.isEmpty())
			integers.push((Integer) temp.pop());
		return sum;
	}
	/*
	 * public static void main(String[] args) { // StackObject stack = new
	 * StackObject(5); // // Student a = new Student("Ahmed", "ElSheikh", 283067,
	 * 1.19); // Student b = new Student("Ahmed", "ElSheikh", 283067, 3.11); //
	 * Student x = new Student("Ahmed", "ElSheikh", 283067, 3.1); // Student y = new
	 * Student("Ahmed", "ElSheikh", 283067, 2.3); // Student z = new
	 * Student("Ahmed", "ElSheikh", 283067, 4.53); // // stack.push(x); //
	 * stack.push(y); // stack.push(z); // stack.push(a); // stack.push(b); // //
	 * Utilities utilities = new Utilities(); // // // Exercise #01 // String print
	 * = utilities.averageGPA(stack); // System.out.println(print); // // //
	 * Exercise #02 // // I copied its solution, was not able to solve it. // print
	 * = Utilities.infixToPostfix("1+2*3-4"); // System.out.println(print); // // //
	 * Exercise #03 // // I copied its solution, was not able to solve it. // print
	 * = PostFixEv.evaluate("1 2 3 * + 4 -"); // System.out.println(print); // // //
	 * Exercise #04 is duplicated, removeNthElement // // Exercise #05 is Browsing
	 * History and Link files // // // Exercise #06 // StackObject strings = new
	 * StackObject(5); // StackObject integers = new StackObject(5); // //
	 * strings.push((String) "Ahmed"); // strings.push((String) "Sheikh"); //
	 * strings.push((String) "Farah"); // strings.push((String) "Hesham"); //
	 * strings.push((String) "Eman"); // // integers.push((Integer) 1); //
	 * integers.push((Integer) 4); // integers.push((Integer) 3); //
	 * integers.push((Integer) 2); // integers.push((Integer) 3); // // StackObject
	 * duplicate = utilities.duplicate(strings, integers); //
	 * utilities.reverseStackObject(duplicate).printStack();
	 * 
	 * // Exercise #07, Class palindrome Palindrome palindrome = new Palindrome();
	 * String toPrint = palindrome.isPalindrome("mom") ? "It is a palindrome" :
	 * "It is not a palindrome"; System.out.println(toPrint);
	 * 
	 * toPrint = palindrome.isPalindrome("car") ? "It is a palindrome" :
	 * "It is not a palindrome"; System.out.println(toPrint);
	 * 
	 * toPrint = palindrome.
	 * isPalindrome("Are we not drawn onward we few drawn onward to new era") ?
	 * "It is a palindrome" : "It is not a palindrome"; System.out.println(toPrint);
	 * 
	 * toPrint = palindrome.
	 * isPalindrome("Then it comes to be that the soothing light at the end of your tunnel\r\n"
	 * + "Is just a freight train coming your way") ? "It is a palindrome" :
	 * "It is not a palindrome"; System.out.println(toPrint);
	 * 
	 * // Extra Exercise on Palindrome, check if word is palindrome
	 * System.out.println(palindrome.wordIsPalindrome("car"));
	 * System.out.println(palindrome.wordIsPalindrome("Radar")); // Extra Exercise
	 * on arrays, reverse a string System.out.println(palindrome.reverse("Sheikh"));
	 * 
	 * // Exercise #08, MySet.class
	 * 
	 * 
	 * }
	 */
}