package sheikh.utils;

import sheikh.objects.Palindrome;
import sheikh.queues.QueueObject;
import sheikh.stacks.StackObject;

public class QueueUtilities {

	public static void main(String[] args) {
		QueueObject qObject = new QueueObject(10);

		qObject.enqueue((Integer) 5);
		qObject.enqueue((Integer) 0);
		qObject.enqueue((Integer) 1);
		qObject.enqueue((Integer) 4);
		qObject.enqueue((Integer) 3);
		qObject.enqueue((Integer) 0);
		qObject.enqueue((Integer) 0);
		qObject.enqueue((Integer) 6);
		qObject.enqueue((Integer) 1);
		qObject.enqueue((Integer) 0);

		qObject.printQueue();

		QueueUtilities queueUtilities = new QueueUtilities();
		qObject.printQueue();
		queueUtilities.mirror(qObject).printQueue();

		// I was not able to solve this problem, so I copied the solution
		System.out.println(queueUtilities.prefixEval("+ 10 * 2 3"));

		QueueUtilities.shiftZeroes(qObject).printQueue();

		QueueObject qObj = new QueueObject(10);

		qObj.enqueue('a');
		qObj.enqueue('b');
		qObj.enqueue('c');
		qObj.enqueue('d');
		qObj.enqueue('e');
		qObj.enqueue('f');
		qObj.enqueue('g');
		qObj.enqueue('h');
		qObj.enqueue('i');
		qObj.enqueue('j');

		qObj.printQueue();
		queueUtilities.everyThirdElement(qObj).printQueue();

		// I was not able to solve this problem, so I copied the solution
		String print = queueUtilities.isAnagram("stoc", "cost") ? "The words are anagrams"
				: "The words are not anagrams";
		System.out.println(print);

		Palindrome palindrome = new Palindrome();
		print = palindrome.isPal("mom") ? "It is palindrome" : "It is not palindrome";
		System.out.println(print);
		print = palindrome.isPal("crm") ? "It is palindrome" : "It is not palindrome";
		System.out.println(print);
	}

	public QueueObject mirror(QueueObject queueObj) {
		int size = queueObj.size() * 2;
		QueueObject queObj = new QueueObject(size);
		QueueObject temp = new QueueObject(size / 2);
		while (!queueObj.isEmpty()) {
			int dequeue = (Integer) queueObj.dequeue();
			temp.enqueue(dequeue);
			queObj.enqueue(dequeue);
		}
		reverseQueue(queObj);
		while (!temp.isEmpty()) {
			Object deQ = temp.dequeue();
			queObj.enqueue(deQ);
			queueObj.enqueue(deQ);
		}
		return queObj;
	}

	private QueueObject reverseQueue(QueueObject queueObj) {
		Object[] rev = new Object[queueObj.size()];
		for (int i = 0; i < rev.length; i++) {
			int j = i + 1;
			rev[rev.length - j] = queueObj.dequeue();
		}
		for (int k = 0; k < rev.length; k++)
			queueObj.enqueue(rev[k]);
		return queueObj;
	}

	public int prefixEval(String exp) {
		String[] array = exp.split(" ");
		QueueObject items = new QueueObject(array.length);
		// filling the queue with the strings
		for (int i = 0; i < array.length; i++)
			items.enqueue(array[i]);
		while (items.size() > 1) {
			String first = (String) items.dequeue();
			if (isOperator(first)) {
				String second = (String) items.peek();
				if (!isOperator(second)) {
					items.dequeue(); // removing second from queue
					String third = (String) items.peek();
					if (!isOperator(third)) // operator is followed by TWO operands
					{
						items.dequeue(); // removing third from queue
						int result = calculate(first, second, third);
						items.enqueue("" + result);// added as a String not Integer
					} else // operator is followed by only ONE operand
					{
						items.enqueue(first);
						items.enqueue(second);
					}
				} else // first is operator NOT followed by any operands
					items.enqueue(first);
			} else // first is an operand
				items.enqueue(first);
		}
		return Integer.parseInt((String) items.dequeue());
	}

	private boolean isOperator(String s) {
		return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
	}

	private int calculate(String operator, String operand1, String operand2) {
		int op1 = Integer.parseInt(operand1);
		int op2 = Integer.parseInt(operand2);
		if ("+".equals(operator))
			return op1 + op2;
		if ("-".equals(operator))
			return op1 - op2;
		if ("*".equals(operator))
			return op1 * op2;
		else // operator.equals("/")
			return op1 / op2;
	}

	public static QueueObject shiftZeroes(QueueObject qObj) {
		QueueObject temp = new QueueObject(qObj.size());
		int size = countZeros(qObj);
		if (size == 0)
			return qObj;
		StackObject temp1 = new StackObject(size);
		while (!qObj.isEmpty()) {
			Object deQ = qObj.dequeue();
			if (Integer.valueOf((Integer) deQ) == 0)
				temp1.push(deQ);
			else
				temp.enqueue(deQ);
		}
		while (!temp1.isEmpty())
			temp.enqueue(temp1.pop());
		return temp;
	}

	private static int countZeros(QueueObject qObj) {
		int count = 0;
		QueueObject q = new QueueObject(qObj.size());
		while (!qObj.isEmpty()) {
			Object deQ = qObj.dequeue();
			if (Integer.valueOf((Integer) deQ) == 0)
				count++;
			q.enqueue(deQ);
		}
		while (!q.isEmpty())
			qObj.enqueue(q.dequeue());
		return count;
	}

	public QueueObject everyThirdElement(QueueObject qObj) {
		int size = qObj.size();
		int count = 0;
		StackObject stack = new StackObject(size);
		for (int i = 0; i < size; i++) {
			Object deQ = qObj.dequeue();
			if (i % 3 == 0) {
				count++;
				stack.push(deQ);
			}
			qObj.enqueue(deQ);
		}
		QueueObject qO = new QueueObject(count);
		while (!stack.isEmpty())
			qO.enqueue(stack.pop());
		return qO;
	}

	public boolean isAnagram(String firstWord, String secondWord) {
		QueueObject qA = new QueueObject(firstWord.length());
		QueueObject qB = new QueueObject(secondWord.length());
		for (int i = 0; i < firstWord.length(); i++) {
			qA.enqueue(firstWord.charAt(i));
			qB.enqueue(secondWord.charAt(i));
		}
		while (!qA.isEmpty()) {
			Character currA = (Character) qA.dequeue();
			Character headB = (Character) qB.dequeue();
			Character currB = headB;
			while (currA.charValue() != currB.charValue()) {
				qB.enqueue(currB);
				currB = (Character) qB.dequeue();
				if (currB.equals(headB))
					return false;
			}
		}
		return true;
	}
}
