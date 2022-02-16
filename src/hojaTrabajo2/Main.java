package hojaTrabajo2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		PostfixCalculator calculator = new PostfixCalculator();
		System.out.println(calculator.Evaluate("6 2 3 + *"));
		
		try {
			FileController.readFile();
		} catch (IOException e) {
			System.out.println(e);
			System.out.println("El archivo no existe.\nPorfavor agregarlo en la siguiente ubicacion: " + FileController.PATH);
		}
	}

}
