package sheikh.utils;

public class Recursion {

	public static void main(String[] args) {
		// Recursion.countdown(10); // Exercise # 01
		// System.out.println(Recursion.power(5, 5)); // Exercise # 02
		// System.out.println(Recursion.factorial(5));
		// System.out.println(Recursion.naturalLogarithm(5)); // Exercise #03
		// System.out.println(Recursion.multiply(5, 9)); // Exercise #04
		// System.out.println(Recursion.divide(7, 6)); // Exercise #05
		// System.out.println(Recursion.modulus(7, 6)); // Exercise #06
		// System.out.println(Recursion.sum(51624)); // Exercise #07
		// System.out.println(Recursion.count(12351624)); // Exercise #08
		// System.out.println(Recursion.isPrime(13)); // Exercise #09
		// System.out.println(Recursion.cube(5)); // Exercise #10
		// System.out.println(Recursion.binomialCoeff(10, 5)); // Exercise #11
		// System.out.println(Recursion.countRec("sheikh", 'h')); // Exercise #12
		// System.out.println(Recursion.reverse("sheikh")); // Exercise #13
		// System.out.println(Recursion.replace("sheikh", 'h')); // Exercise #14
		// System.out.println(Recursion.delete("sheikh", 'h')); // Exercise #15
		// System.out.println(Recursion.search("sheikh", 'h')); // Exercise #19
	}

	public static void countdown(int num) {
		if (num < 0)
			return;
		if (num == 0) {
			System.out.println("Blast off!!!");
		} else {
			System.out.println(num);
			countdown(num - 1);
		}
	}

	public static int power(int base, int exponenet) {
		int result = 1;
		if (exponenet == 0)
			return result;
		else
			return base * result * power(base, exponenet - 1);
	}

	public static int factorial(int num) {
		if (num <= 1) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}

	public static double naturalLogarithm(int num) {
		if (num == 0)
			return 1.0;
		else
			return naturalLogarithm(num - 1) + (1.0 / factorial(num));
	}

	public static int multiply(int operator1, int operator2) {
		if (operator2 <= 1)
			return operator1;
		else
			return operator1 + multiply(operator1, operator2 - 1);
	}

	public static double divide(int operator1, int operator2) {
		if (operator2 < 0) {
			System.out.println("Division by a negative number is prohibited.");
		} else {
			if (operator1 < operator2)
				return 0;
			else
				return 1.0 + divide(operator1 - operator2, operator2);
		}
		return -1;
	}

	public static int modulus(int operator1, int operator2) {
		if (operator1 == 0)
			return 0;
		else if (operator1 < operator2)
			return operator1;
		else
			return modulus(operator1 - operator2, operator2);
	}

	public static int sum(int num) {
		if (num / 10 == 0)
			return num;
		else
			return (num % 10) + sum(num / 10);
	}

	public static int count(int num) {
		if (num / 10 == 0)
			return 1;
		else
			return 1 + count(num / 10);
	}

	public static boolean isPrime(int num) {
		return isPrimeHelper(num, num - 1);
	}

	private static boolean isPrimeHelper(int num, int divisor) {
		if (divisor == 1)
			return true;
		else if (num % divisor == 0)
			return false;
		else
			return isPrimeHelper(num, divisor - 1);
	}

	public static int cube(int num) {
		if (num == 1)
			return 1;
		else
			return cube(num - 1) + (3 * square(num)) - (3 * num) + 1;
	}

	private static int square(int num) {
		if (num == 1)
			return 1;
		else
			return square(num - 1) + (2 * num) - 1;
	}

	public static long binomialCoeff(int n, int k) {
		if (k == 0 || n == k)
			return 1l;
		else
			return binomialCoeff(n - 1, k) + binomialCoeff(n - 1, k - 1);
	}

	public static int countRec(String word, char ch) {
		String str = word.toLowerCase();
		if (str.length() == 0)
			return 0;
		else if (str.charAt(0) == ch)
			return 1 + countRec(str.substring(1), ch);
		else
			return countRec(str.substring(1), ch);
	}

	public static String reverse(String word) {
		if (word.length() == 0)
			return "";
		else
			return "" + word.charAt(word.length() - 1) + reverse(word.substring(0, word.length() - 1));
	}

	public static String replace(String word, char ch) {
		String str = word.toLowerCase();
		if (str.length() == 0) {
			return "";
		} else {
			if (str.charAt(str.length() - 1) == ch)
				return replace(str.substring(0, str.length() - 1), ch) + "*";
			else
				return replace(str.substring(0, str.length() - 1), ch) + str.charAt(str.length() - 1);
		}
	}

	public static String delete(String word, char ch) {
		String str = word.toLowerCase();
		if (str.length() == 0)
			return "";
		else if (str.charAt(str.length() - 1) == ch)
			return delete(str.substring(0, str.length() - 1), ch) + " ";
		else
			return delete(str.substring(0, str.length() - 1), ch) + str.charAt(str.length() - 1);

	}

	public static int search(String word, char ch) {
		String str = word.toLowerCase();
		if (str.length() == 0)
			return -1;
		else if (str.charAt(str.length() - 1) == ch)
			return str.length() - 1;
		else
			return search(str.substring(0, str.length() - 1), ch);
	}
}
