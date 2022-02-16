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
	void test() {
		
		String expresion = "1 2 + 4 * 3 +";
		assertEquals(15, calculator.Evaluate(expresion));
	}
	
	@Test
	void secondTest() {
		
		String expresion = "8 2 2 2 /";
		assertEquals(1, calculator.Evaluate(expresion));
	}

}
