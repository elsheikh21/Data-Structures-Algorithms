package sheikh.stacks;

public class PostFixEv {

	public static String evaluate(String postfixExp) {
		String[] values = postfixExp.split(" ");
		StackObject numbers = new StackObject(values.length);
		int operand1;
		int operand2;
		for (int i = 0; i < values.length; i++) {
			char cur = values[i].charAt(0);
			if (cur >= '0' && cur <= '9') {
				int n = Integer.parseInt(values[i]);
				numbers.push(Integer.valueOf(n));
			} else {
				operand1 = ((Integer) numbers.pop()).intValue();
				operand2 = ((Integer) numbers.pop()).intValue();
				switch (cur) {
				// order is crucial for the - and / operators
				// since they are not commutative
				case '+':
					numbers.push(Integer.valueOf(operand2 + operand1));
					break;
				case '-':
					numbers.push(Integer.valueOf(operand2 - operand1));
					break;
				case '*':
					numbers.push(Integer.valueOf(operand2 * operand1));
					break;
				case '/':
					numbers.push(Integer.valueOf(operand2 / operand1));
					break;
				default:
					System.out.println("Invalid Operator");
					break;
				}
			}
		}
		return String.format("The evaluation for your postfix expression (%1s) is (%d)", postfixExp,
				((Integer) numbers.pop()).intValue());
	}

}
