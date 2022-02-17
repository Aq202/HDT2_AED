package hojaTrabajo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase FileController.
 * @author diego
 * Programado el 16/02/2022
 *
 */

public class FileController {
	
	public static final String PATH = System.getProperty("user.dir") + "\\datos.txt";

	/**
	 * Metodo que se encarga de obtener todas las filas del archivo datos.txt
	 * @return String[]. Array con cada una de las filas de texto por casilla.
	 * @throws IOException
	 */
	public static String[] readFile() throws IOException {
		
		File doc = new File(PATH);

		  BufferedReader obj = new BufferedReader(new FileReader(doc));
		  ArrayList<String> linesList = new ArrayList<String>();

		  String line;
		  while ((line = obj.readLine()) != null) {
		    linesList.add(line);
		  }
		  
		  obj.close();
		  
		  return linesList.toArray(new String[linesList.size()]);
	}
}
