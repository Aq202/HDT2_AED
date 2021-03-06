package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hojaTrabajo2.Stack_ArrayList;

class StackTest {

	private Stack_ArrayList<Integer> stack;

	public StackTest() {
		stack = new Stack_ArrayList<Integer>();
	}

	/**
	 * Test para probar el metodo peek de la pila
	 */
	@Test
	void peekTest() {

		stack.push(1);
		stack.push(2);
		stack.push(3);

		assertEquals(3, stack.peek()); // verificar que sea el ultimo
		assertEquals(3, stack.peek()); // verificar que no se haya eliminado

	}

	/**
	 * Test para probar el metodo pull de la pila
	 */
	void pullTest() {
		stack.pull();
		assertEquals(2, stack.count()); // verificar que se elimino el anterior
	}

	/**
	 * Test para probar el metodo isEmpty de la pila
	 */
	void emptyTest() {
		assertEquals(false, stack.isEmpty()); // verificar que no este vacia

		stack.pull();
		stack.pull();
		assertEquals(true, stack.isEmpty()); // verificar vaciado
	}

}
