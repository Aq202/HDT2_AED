package hojaTrabajo2;

import java.io.IOException;
import java.util.Iterator;

/**
 * Clase Main.
 * @author diego
 * Programado el 16/02/2022
 *
 */

public class Main {

	/**
	 * Metodo principal del programa.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("\n***** CALCULADORA POSTFIX *****\n");

		PostfixCalculator calculator = new PostfixCalculator();

		try {

			String[] expresions = FileController.readFile();

			// Ejecuta todas las operaciones en el archivo
			for (int i = 0; i < expresions.length; i++) {
				
				System.out.print(String.format("Resultado %s: ", i+1));

				try {
					
					//Realiza la operacion 
					System.out.println(calculator.Evaluate(expresions[i]));

				} catch (ArithmeticException e) {
					System.out.println("No puedes dividir un número por cero.");
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

		} catch (IOException e) {
			System.out.println(
					"El archivo no existe.\nPorfavor agregarlo en la siguiente ubicacion: " + FileController.PATH);
		}
	}

}
