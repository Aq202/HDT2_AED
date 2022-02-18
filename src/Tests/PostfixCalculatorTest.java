package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hojaTrabajo2.PostfixCalculator;

class PostfixCalculatorTest {

	private PostfixCalculator calculator;
	
	public PostfixCalculatorTest() {
		calculator = new PostfixCalculator();
	}
	
	/**
	 * Test para verificar la acertividad de la calculadora.
	 */
	@Test
	void operationsTest() {
		
		assertEquals(15, calculator.Evaluate("1 2 + 4 * 3 +"));
		assertEquals(30, calculator.Evaluate("6 2 3 + *"));
		assertEquals(10, calculator.Evaluate("4 5 2 * + 5 + 1 + 2 /"));

	}
	
	/**
	 * Test para verificar el comportamiento del programa ante una expresion invalida.
	 */
	@Test
	void invalidExpresionTest() {
		String message = "";
		
		try {
			calculator.Evaluate("1 2 3 + 5 M +");
			
		}catch(IllegalArgumentException ex) {
			message = ex.getMessage();
		}
		
		assertEquals("La expresion ingresada no se encuentra en un formato valido.", message);
	}
	
	/**
	 * Test para verificar el comportamiento del programa ante falta de operandos.
	 */
	@Test
	void insufficientOperandsTest() {
		String message = "";
		
		try {
			calculator.Evaluate("6 2 + *");
			
		}catch(IllegalArgumentException ex) {
			message = ex.getMessage();
		}
		
		assertEquals("Cantidad de operandos insuficiente.", message);
	}
	
	

}
