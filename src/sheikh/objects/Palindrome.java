package sheikh.objects;

import sheikh.queues.QueueObject;
import sheikh.stacks.StackObject;

public class Palindrome {

	public boolean isPalindrome(String str) {
		String word = str.toLowerCase().replace(" ", "");
		int mid = word.length() / 2;
		StackObject stack = new StackObject(mid);
		for (int i = 0; i < mid; i++)
			stack.push(String.valueOf(word.charAt(i)));
		if (word.length() % 2 == 1)
			mid++;
		for (int i = mid; i < word.length(); i++) {
			String toCheck = (String) stack.pop();
			String toCheckWith = String.valueOf(word.charAt(i));
			if (!toCheck.equals(toCheckWith))
				return false;
		}
		return true;
	}

	public String reverse(String str) {
		String word = str.toLowerCase();
		int size = word.length();
		String rev = "";
		char[] ch = new char[size];
		for (int i = 0; i < size; i++) {
			int j = i + 1;
			ch[size - j] = word.charAt(i);
		}
		for (int i = 0; i < ch.length; i++)
			rev += ch[i];
		return rev;
	}

	public boolean checkWord(String word) {
		return !(wordIsPalindrome(word)).contains("not");
	}

	public String wordIsPalindrome(String str) {
		String word = str.toLowerCase();
		int middle = word.length() / 2;
		StackObject stack = new StackObject(middle);
		for (int i = 0; i < middle; i++)
			stack.push(String.valueOf(word.charAt(i)));
		if (word.length() % 2 == 1)
			middle++;
		for (int i = middle; i < word.length(); i++)
			if ((String.valueOf(word.charAt(i)).compareTo((String) stack.pop()) != 0))
				return "Word is not palindrome";
		return "Word is palindrome";
	}

	public boolean isPal(String str) {
		String word = str.toLowerCase().replace(" ", "");
		int mid = word.length() / 2;
		StackObject stack = new StackObject(mid);
		QueueObject queue = new QueueObject(mid);
		for (int i = 0; i < mid; i++)
			stack.push((Character) word.charAt(i));
		int size = word.length();
		if (size % 2 == 1)
			mid++;
		for (int j = mid; j < size; j++)
			queue.enqueue((Character) word.charAt(j));
		while (!stack.isEmpty())
			if (stack.pop() == queue.dequeue())
				continue;
			else
				return false;
		return true;
	}
}
