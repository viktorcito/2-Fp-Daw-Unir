package testingsecuenciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ejercicio02LeerQuijote {

	public static void main(String[] args) {
		
		// Fuente el fichero en dicso
		File fichero = new File("d:/ficheros/quijote.txt");
		String linea = null;
		// El flujo
		try {
			FileReader fileReader = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fileReader);
			linea = bf.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = bf.readLine();
			}
			System.out.println("lectura terminada");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nSEGUNDA LECTURA CON SCANNER\n");
		
		try {
			Scanner leer = new Scanner(fichero);
			while(leer.hasNext()) {
				System.out.println(leer.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("FIN DE PROGRAMA");
		

	}

}
