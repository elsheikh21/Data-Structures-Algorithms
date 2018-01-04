package sheikh.utils;

import sheikh.stacks.ArrayStack;

public class Utilities {

	public Utilities() {
		super();
	}

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
				char ch0 = arrayStack.pop();
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

}
