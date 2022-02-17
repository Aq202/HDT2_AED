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

		PostfixCalculator calculator = new PostfixCalculator();

		try {

			String[] expresions = FileController.readFile();

			// Ejecuta todas las operaciones en el archivo
			for (int i = 0; i < expresions.length; i++) {

				try {
					
					//Realiza la operacion 
					System.out.println(String.format("Resultado %s: %s", i + 1, calculator.Evaluate(expresions[i])));

				} catch (ArithmeticException e) {
					System.out.println("No puedes dividir un número por cero.");
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

		} catch (IOException e) {
			System.out.println(e);
			System.out.println(
					"El archivo no existe.\nPorfavor agregarlo en la siguiente ubicacion: " + FileController.PATH);
		}
	}

}
