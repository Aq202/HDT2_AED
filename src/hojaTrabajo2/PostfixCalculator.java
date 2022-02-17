package hojaTrabajo2;

public class PostfixCalculator implements IPosfixCalc {

	@Override
	public int Evaluate(String expresion) throws ArithmeticException {

		String[] values = expresion.split(" ");
		Stack_ArrayList<Integer> stack = new Stack_ArrayList<>();
		int result = 0;

		for (String value : values) {

			if (value.trim() != "") {

				Integer digit = parseDigit(value);

				if (digit != null) {
					stack.push(digit);
				}
				// Signo
				else {

					final String sign = value.trim();
					final String validSigns = "+-*/";

					// validar signo
					if (!validSigns.contains(value))
						throw new IllegalArgumentException(
								"La expresion ingresada no se encuentra en un formato valido.");

					// reverse stack
					if (sign.equals("-") || sign.equals("/")) {
						stack = reverseDigits(stack);
					}

					if (stack.count() < 2)
						throw new IllegalArgumentException("Cantidad de operandos insuficiente.");

					while (stack.count() > 1) {

						int operatorA = stack.pull();
						int operatorB = stack.pull();

						switch (sign) {

						case "+":
							result = operatorA + operatorB;
							break;
						case "-":
							result = operatorA - operatorB;
							break;
						case "*":
							result = operatorA * operatorB;
							break;
						case "/":
							result = operatorA / operatorB;
							break;

						}

						stack.push(result);
					}

				}
			}
		}

		return result;
	}

	private Integer parseDigit(String value) {

		try {
			return Integer.parseInt(value);
		} catch (Exception ex) {
			return null;
		}
	}

	private Stack_ArrayList<Integer> reverseDigits(Stack_ArrayList<Integer> originalDigits) {

		Stack_ArrayList<Integer> reversed = new Stack_ArrayList<Integer>();
		while (!originalDigits.isEmpty()) {
			reversed.push(originalDigits.pull());
		}
		return reversed;

	}

}
