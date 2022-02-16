package hojaTrabajo2;

public class PostfixCalculator implements IPosfixCalc {

	@Override
	public int Evaluate(String expresion) {

		String[] values = expresion.split(" ");
		Stack_ArrayList<Integer> stack = new Stack_ArrayList<>();
		int result = 0;

		for (String value : values) {

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
					throw new IllegalArgumentException("La expresion ingresada no se encuentra en un formato valido.");

				while (stack.count() > 1) {

					int operatorB = stack.pull();
					int operatorA = stack.pull();

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

		return result;
	}

	private Integer parseDigit(String value) {

		try {
			return Integer.parseInt(value);
		} catch (Exception ex) {
			return null;
		}
	}

}
