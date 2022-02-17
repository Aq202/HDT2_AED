package hojaTrabajo2;

/**
 * Clase PostfixCalculator.
 * @author diego
 * Programado el 16/02/2022
 *
 */

public class PostfixCalculator implements IPosfixCalc {

	/**
	 * Metodo que se encarga de efectuar la operacion especificada en una expresion postfix.
	 * @param expresion String. Expresion en formato postfix.
	 * @return int. Resultado de la operacion.
	 */
	@Override
	public int Evaluate(String expresion) throws ArithmeticException {

		String[] values = expresion.split(" ");
		Stack_ArrayList<Integer> stack = new Stack_ArrayList<>();
		int result = 0;

		for (String value : values) {

			if (value.trim() != "") {

				Integer digit = parseDigit(value);

				// caracter es digito
				if (digit != null) {
					stack.push(digit);
				}
				// caracter es Signo
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

					//validar cantidad de operandos
					if (stack.count() < 2)
						throw new IllegalArgumentException("Cantidad de operandos insuficiente.");

					//realiza la operacion con todos los operandos almacenados
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

						//add result
						stack.push(result);
					}

				}
			}
		}

		return result;
	}

	/**
	 * Metodo que se encarga de convertir un String a Integer.
	 * @param value String. 
	 * @return Integer. Si el valor no es un int retorna null.
	 */
	private Integer parseDigit(String value) {

		try {
			return Integer.parseInt(value);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Metodo que se encarga de crear una nueva pila con los digitos invertidos.
	 * @param originalDigits. Pila con los digitos originales.
	 * @return Stack_ArrayList.
	 */
	private Stack_ArrayList<Integer> reverseDigits(Stack_ArrayList<Integer> originalDigits) {

		Stack_ArrayList<Integer> reversed = new Stack_ArrayList<Integer>();
		while (!originalDigits.isEmpty()) {
			reversed.push(originalDigits.pull());
		}
		return reversed;

	}

}
