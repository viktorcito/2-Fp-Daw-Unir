package testingsecuenciales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ejercicio01LeerFichero {

	public static void main(String[] args) {
		File fichero = new File("d:/ficheros/quijote.txt");

			try {
				FileReader fileReader = new FileReader(fichero);
				
				System.out.println("fichero correcto");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				System.out.println("estamos en finnaly");
			}
		 
		
		System.out.println("salida del try catch");
		

	}

}
