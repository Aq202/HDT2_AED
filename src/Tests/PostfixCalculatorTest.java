package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hojaTrabajo2.PostfixCalculator;

class PostfixCalculatorTest {

	private PostfixCalculator calculator;
	
	public PostfixCalculatorTest() {
		calculator = new PostfixCalculator();
	}
	
	@Test
	void operationsTest() {
		
		assertEquals(15, calculator.Evaluate("1 2 + 4 * 3 +"));
		assertEquals(11, calculator.Evaluate("8 2 4 + 7 / 6 * 2 2 / 6 5 + 2 1 -"));
		assertEquals(6, calculator.Evaluate("64     2    2 2 / 5 + 4      2 1 -"));

	}
	
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
	
	@Test
	void insufficientOperandsTest() {
		String message = "";
		
		try {
			calculator.Evaluate("6 2 3 + *");
			
		}catch(IllegalArgumentException ex) {
			message = ex.getMessage();
		}
		
		assertEquals("Cantidad de operandos insuficiente.", message);
	}
	
	

}
