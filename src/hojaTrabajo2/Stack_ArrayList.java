package hojaTrabajo2;

import java.util.ArrayList;

/**
 * 
 * @author Diego Morales
 *
 * @param <T> 
 */
public class Stack_ArrayList<T> implements IStack<T>{
	
	private ArrayList<T> elements;

	public Stack_ArrayList() {
		elements = new ArrayList<T>();
	}
	
	/**
	 * Agrega un nuevo elemento al inicio de la pila.
	 */
	@Override
	public void push(T value) {		
		elements.add(0, value);		
	}

	/**
	 * Retorna el primer elemento y lo elimina.
	 * @return primer elemento.
	 */
	@Override
	public T pull() {
		return elements.remove(0);
	}

	/**
	 * Retorna el primer elemento sin eliminarlo.
	 * @return primer elemento.
	 */
	@Override
	public T peek() {
		return elements.get(0);
	}

	/**
	 * Retorna el tamano de la pila
	 * @return int
	 */
	@Override
	public int count() {
		return elements.size();
	}

	/**
	 * Verifica si la lista esta vacia
	 * @return boolean.
	 */
	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

}
