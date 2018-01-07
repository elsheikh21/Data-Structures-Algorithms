package sheikh.objects;

import sheikh.stacks.StackObject;

public class Palindrome {

	public boolean isPalindrome(String word) {
		word = word.toLowerCase().replace(" ", "");
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

	public String reverse(String word) {
		word = word.toLowerCase();
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
		String res = wordIsPalindrome(word);
		if (res.contains("not"))
			return false;
		return true;
	}

	public String wordIsPalindrome(String word) {
		word = word.toLowerCase();
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

}
